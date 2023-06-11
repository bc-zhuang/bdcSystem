package com.bdc.adminService.controller;

import com.bdc.adminService.common.vo.Result;
import com.bdc.adminService.common.vo.ResultCode;
import com.bdc.adminService.service.IFirstbusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * 管理员一级业务管理接口
 * @author bc
 * @since 2023-05-15
 */
@RestController
@RequestMapping("/adminService/firstbusiness")
public class FirstbusinessController {

    @Autowired
    IFirstbusinessService firstbusinessService;

    /**
     * 查询所有一级业务
     * @return
     */
    @GetMapping("/selectAllFirst")
    public Result selectAllFirst(){
        Map<String, Object> data = firstbusinessService.selectAllFirst();
        if(data != null){
            return Result.success(data);
        }
        return Result.failure(ResultCode.DATA_NONE);
    }

    /**
     * 添加新的一级业务
     * @param name
     * @return
     */
    @PostMapping("/addFirst")
    public Result addFirst(@RequestParam String name){
        Map<String, Object> data = firstbusinessService.addFirst(name);
        if(data != null){
            return Result.success(data);
        }
        return Result.failure(ResultCode.ERROR);
    }

    /**
     * 修改一级业务信息
     * @param id
     * @param name
     * @return
     */
    @PostMapping("/change")
    public Result change(@RequestParam Integer id,
                         @RequestParam String name){
        Map<String, Object> data = firstbusinessService.change(id, name);
        if(data != null){
            return Result.success(data);
        }
        return Result.failure(ResultCode.ERROR);
    }

}
