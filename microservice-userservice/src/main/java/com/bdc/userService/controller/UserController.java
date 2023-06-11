package com.bdc.userService.controller;

import com.bdc.userService.commom.vo.Result;
import com.bdc.userService.commom.vo.ResultCode;
import com.bdc.userService.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * 用户接口
 * @author bc
 * @since 2023-05-13
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService userService;

    /**
     * 用户登录
     * @param userName
     * @param passWord
     * @return
     */
    @PostMapping("/login")
    public Result login(@RequestParam(name = "userName") String userName,
                                             @RequestParam(name = "passWord") String passWord) {
        try {
            Map<String, Object> data = userService.login(userName, passWord);
            if (data != null) {
                return Result.success(data);
            }
            return Result.failure(20002, "用户名或密码错误");
        } catch (Exception e) {
            e.printStackTrace();
            return Result.failure(20005, "登录出错");
        }
    }

    /**
     * 用户注册
     * @param userName
     * @param passWord
     * @return
     */
    @PostMapping("/register")
    public Result register(@RequestParam(name = "userName") String userName,
                                                @RequestParam(name = "passWord") String passWord) {
        Map<String, Object> data = userService.register(userName, passWord);
        if (data != null) {
            return Result.success(data);
        }
        return Result.failure(20002, "账号已注册");
    }

    /**
     * 用户修改密码
     * @param request
     * @param oldPassword
     * @param newPassword
     * @return
     */
    @PostMapping("/changePassword")
    public Result changePassword(HttpServletRequest request,
                                 @RequestParam(name = "oldPassword") String oldPassword,
                                 @RequestParam(name = "newPassword") String newPassword) {
        Map<String, Object> data = userService.changePassword(request, oldPassword, newPassword);
        if(data != null && data.get("fail") != null){
            return Result.failure(20005, (String) data.get("fail"));
        }
        if(data != null && data.get("fail1") != null){
            return Result.failure(20002, (String) data.get("fail1"));
        }
        if (data != null) {
            return Result.success(data);
        }
        return Result.failure(20002, "原密码错误");
    }

    /**
     * 查询所有用户
     * @return
     */
    @GetMapping("/selectAllUser")
    public Result selectAllUser(){
        Map<String, Object> data = userService.selectAllUser();
        if(data != null){
            return Result.success(data);
        }
        return Result.failure(ResultCode.ERROR);
    }


}
