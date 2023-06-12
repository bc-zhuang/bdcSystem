package com.bdc.adminService.service;

import com.bdc.adminService.entity.Admin;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author bc
 * @since 2023-05-15
 */
public interface IAdminService extends IService<Admin> {

    Map<String, Object> login(String userName, String passWord);

    String selectAllUser();

    Map<String, Object> selectByPhone(String phone);

    Map<String, Object> delete(Integer id);

    Map<String, Object> changePower(Integer id, Integer power);

    Map<String, Object> changeUser(Integer id, String phone, String paswd, Integer state, Integer power);
}
