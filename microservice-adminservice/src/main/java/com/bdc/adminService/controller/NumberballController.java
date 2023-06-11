package com.bdc.adminService.controller;

import com.bdc.adminService.common.vo.Result;
import com.bdc.adminService.common.vo.ResultCode;
import com.bdc.adminService.service.INumberballService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * 管理员号球数量管理接口
 * @author bc
 * @since 2023-05-15
 */
@RestController
@RequestMapping("/adminService/numberball")
public class NumberballController {

    @Autowired
    INumberballService numberballService;

    /**
     * 查询所有号球数量
     * @return
     */
    @GetMapping("/selectAll")
    public Result selectAll(){
        Map<String, Object> data = numberballService.selectAllFirst();
        if(data != null){
            return Result.success(data);
        }
        return Result.failure(ResultCode.DATA_NONE);
    }

}
