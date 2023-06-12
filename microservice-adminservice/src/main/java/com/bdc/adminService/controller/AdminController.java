package com.bdc.adminService.controller;

import com.alibaba.fastjson.JSONObject;
import com.bdc.adminService.common.vo.Result;
import com.bdc.adminService.common.vo.ResultCode;
import com.bdc.adminService.service.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * 管理员用户管理接口
 * @author bc
 * @since 2023-05-15
 */
@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    IAdminService adminService;

    /**
     * 管理员登录
     */
    @PostMapping("/login")
    public Result login(@RequestParam(value = "userName") String userName, @RequestParam(value = "passWord")String passWord){
        Map<String, Object> data = adminService.login(userName, passWord);
        if(data != null){
            return Result.success(data);
        }
        return Result.failure(ResultCode.ERROR);
    }

    /**
     * 查询所有用户信息
     */
    @GetMapping("/selectAllUser")
    public JSONObject selectAllUser(){
        String str = adminService.selectAllUser();
        System.out.println(str);

        JSONObject jsonObject = JSONObject.parseObject(str);
        if(jsonObject != null){
            return jsonObject;
        }
        return JSONObject.parseObject("{\"code\":2,\"msg\":\"操作失败\"");
    }

    /**
     * 根据用户手机号查询用户
     */
    @PostMapping("/selectByPhone")
    public Result selectByPhone(@RequestParam String phone){
        Map<String, Object> data = adminService.selectByPhone(phone);
        if(data != null){
            return Result.success(data);
        }
        return Result.failure(ResultCode.ERROR);
    }

    /**
     * 删除用户
     * @param id 用户id
     * @return
     */
    @PostMapping("/delete")
    public Result delete(@RequestParam Integer id){
        Map<String, Object> data = adminService.delete(id);
        if(data != null){
            return Result.success(data);
        }
        return Result.failure(ResultCode.ERROR);
    }

    /**
     * 根据用户id修改用户权限，0表示普通用户，1表示管理员
     * @param id 用户id
     * @param power 用户权限
     * @return
     */
    @PostMapping("/changePower")
    public Result changePower(@RequestParam Integer id, @RequestParam Integer power){
        Map<String, Object> data = adminService.changePower(id, power);
        if(data != null){
            return Result.success(data);
        }
        return Result.failure(ResultCode.ERROR);
    }

    /**
     * 根据用户id修改用户的全部信息
     * @param id 用户id
     * @param phone 用户账号
     * @param paswd 密码
     * @param state 状态
     * @param power 权限
     * @return
     */
    @PostMapping("/changeUser")
    public  Result changeUser(@RequestParam Integer id,
                              @RequestParam String phone,
                              @RequestParam String paswd,
                              @RequestParam Integer state,
                              @RequestParam Integer power){
        Map<String, Object> data = adminService.changeUser(id, phone, paswd, state, power);
        if(data != null){
            return Result.success(data);
        }
        return Result.failure(ResultCode.ERROR);
    }




}
