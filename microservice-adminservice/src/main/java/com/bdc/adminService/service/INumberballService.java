package com.bdc.adminService.service;

import com.bdc.adminService.entity.Numberball;
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
public interface INumberballService extends IService<Numberball> {

    Map<String, Object> selectAllFirst();

    Map<String, Object> selectByCenterId(Integer id);

    Map<String, Object> changeNumberById(Integer id, Integer number);
}
