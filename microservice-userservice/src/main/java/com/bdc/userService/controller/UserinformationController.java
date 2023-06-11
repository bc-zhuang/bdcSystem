package com.bdc.userService.controller;

import com.bdc.userService.commom.vo.Result;
import com.bdc.userService.commom.vo.ResultCode;
import com.bdc.userService.service.IUserinformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * 用户实名信息接口
 * @author bc
 * @since 2023-05-13
 */
@RestController
@RequestMapping("/userinformation")
public class UserinformationController {
    @Autowired
    IUserinformationService userinformationService;

    /**
     * 查询用户实名信息
     * @param request
     * @return
     */
    @GetMapping("/selectUserInfo")
    public Result selectUserInfo(HttpServletRequest request){
        Map<String, Object> data = userinformationService.selectUserInfo(request);
        if(data != null && data.get("fail") != null){
            return Result.failure(20003, (String) data.get("fail"));
        }
        if(data != null){
            return Result.success(data);
        }
        return Result.failure(20005, "查询出错");
    }

    /**
     * 用户添加实名信息
     * @param request
     * @param name
     * @param idNo
     * @return
     */
    @PostMapping("/addInfo")
    public Result addInfo(HttpServletRequest request, @RequestParam String name, @RequestParam String idNo){
        Map<String, Object> data = userinformationService.addInfo(request, name, idNo);
        if(data != null && data.get("fail") != null){
            return Result.failure(20003, (String) data.get("fail"));
        }
        if(data != null){
            return Result.success(data);
        }
        return Result.failure(20005, "实名认证出错");
    }

    /**
     * 查询所有用户实名信息
     * @return
     */
    @GetMapping("/selectAll")
    public Result selectAll(){
        Map<String, Object> data = userinformationService.selectAll();
        if(data != null){
            return Result.success(data);
        }
        return Result.failure(ResultCode.ERROR);
    }

}
