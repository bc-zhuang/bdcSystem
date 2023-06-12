package com.bdc.reservationService.controller;

import com.bdc.reservationService.common.vo.Result;
import com.bdc.reservationService.common.vo.ResultCode;
import com.bdc.reservationService.service.IReservationinformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * 预约信息管理
 * @author bc
 * @since 2023-05-16
 */
@RestController
@RequestMapping("/reservationService/reservationinformation")
public class ReservationinformationController {

    @Autowired
    IReservationinformationService reservationinformationService;

    /** 添加预约信息
     * @param request
     * @param time_re 预约的时段
     * @param center_id 不动产登记中心的id
     * @param first_id 一级业务id
     * @param window 窗口号
     * @return
     */
    @PostMapping("/addInfo")
    public Result addInfo(HttpServletRequest request,
                          @RequestParam String time_re,
                          @RequestParam Integer center_id,
                          @RequestParam Integer first_id,
                          @RequestParam String window){
        // 查询用户是否可以进行预约
        Map<String, Object> mages = reservationinformationService.isPunish(request);
        if(mages == null) {
            Map<String, Object> data = reservationinformationService.addInfo(request, time_re, center_id, first_id, window);
            if (data != null) {
                return Result.success(data);
            }
            return Result.failure(ResultCode.ERROR);
        }
        else {
            return Result.success(mages);
        }
    }

    /** 根据预约信息中的id取消预约，距离预约时段小于2个小时无法取消
     * @param id 该预约信息的id
     * @return
     */
    @PostMapping("/cancelReservation")
    public Result cancelReservation(@RequestParam String id){
        Map<String, Object> data = reservationinformationService.cancelReservation(id);
        if(data != null){
            return Result.success(data);
        }
        return Result.failure(ResultCode.ERROR);
    }

    /** 修改预约信息
     * @param id 该预约的id号
     * @param time_re 预约时段
     * @param center_id 不动产登记中心id
     * @param first_id 一级业务id
     * @param window 窗口号
     * @return
     */
    @PostMapping("/changeInfo")
    public Result changeInfo(@RequestParam Integer id,
                                          @RequestParam String time_re,
                                          @RequestParam Integer center_id,
                                          @RequestParam Integer first_id,
                                          @RequestParam String window){
        Map<String, Object> data = reservationinformationService.changeInfo(id, time_re, center_id, first_id, window);
        if(data != null){
            return Result.success(data);
        }
        return Result.failure(ResultCode.ERROR);
    }

    /** 根据用户id查询用户所有的预约信息
     * @return
     */
    @PostMapping("/selectAll")
    public Result selectAll(HttpServletRequest request){
        Map<String, Object> data = reservationinformationService.selectAll(request);
        if(data != null){
            return Result.success(data);
        }
        return Result.failure(ResultCode.ERROR);
    }

    /**
     * 查询所有预约信息
     */
    @GetMapping("/selectALL")
    public Result selectALL(){
        Map<String, Object> data = reservationinformationService.selectALL();
        if(data != null){
            return Result.success(data);
        }
        return Result.failure(ResultCode.ERROR);
    }

    /**
     * 根据一级业务id查询预约信息
     */
    @PostMapping("/selectByFirst")
    public Result selectByFirst(@RequestParam Integer first_id){
        Map<String, Object> data = reservationinformationService.selectByFirst(first_id);
        if(data != null){
            return Result.success(data);
        }
        return Result.failure(ResultCode.ERROR);
    }



}
