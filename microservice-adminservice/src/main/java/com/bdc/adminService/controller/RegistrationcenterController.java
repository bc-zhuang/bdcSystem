package com.bdc.adminService.controller;

import com.bdc.adminService.common.vo.Result;
import com.bdc.adminService.common.vo.ResultCode;
import com.bdc.adminService.service.IRegistrationcenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * 管理员不动产登记中心管理接口
 * @author bc
 * @since 2023-05-15
 */
@RestController
@RequestMapping("/adminService/registrationcenter")
public class RegistrationcenterController {
    @Autowired
    IRegistrationcenterService registrationcenterService;

    /**
     * 查询所有不动产登记中心
     * @return
     */
    @GetMapping("/selectAll")
    public Result selectAll(){
        Map<String, Object> data = registrationcenterService.selectAll();
        if(data != null){
            return Result.success(data);
        }
        return Result.failure(ResultCode.DATA_NONE);
    }

    /**
     * 更改不动产登记中心的信息
     * @param id
     * @param name
     * @param address
     * @param phone
     * @return
     */
    @PostMapping("/change")
    public Result change(@RequestParam Integer id,
                         @RequestParam String name,
                         @RequestParam String address,
                         @RequestParam String phone){
        Map<String, Object> data = registrationcenterService.change(id, name, address, phone);
        if(data != null){
            return Result.success(data);
        }
        return Result.failure(ResultCode.DATA_NONE);
    }
}
