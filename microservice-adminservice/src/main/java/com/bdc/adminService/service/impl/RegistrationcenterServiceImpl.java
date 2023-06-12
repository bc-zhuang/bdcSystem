package com.bdc.adminService.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.bdc.adminService.entity.Registrationcenter;
import com.bdc.adminService.mapper.RegistrationcenterMapper;
import com.bdc.adminService.service.IRegistrationcenterService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author bc
 * @since 2023-05-15
 */
@Service
public class RegistrationcenterServiceImpl extends ServiceImpl<RegistrationcenterMapper, Registrationcenter> implements IRegistrationcenterService {

    // 查询所有不动产登记中心
    @Override
    public Map<String, Object> selectAll() {
        Map<String, Object> data = new HashMap<>();
        List<Registrationcenter> list = this.baseMapper.selectList(null);
        data.put("list", list);
        return data;
    }

    @Override
    public Map<String, Object> change(Integer id, String name, String address, String phone) {
        Map<String, Object> data = new HashMap<>();
        Registrationcenter registrationcenter = this.baseMapper.selectById(id);
        if(registrationcenter != null){
            UpdateWrapper<Registrationcenter> updateWrapper = new UpdateWrapper<>();
            updateWrapper.lambda().eq(Registrationcenter::getId, registrationcenter.getId());
            updateWrapper.lambda().set(Registrationcenter::getName, name);
            updateWrapper.lambda().set(Registrationcenter::getAddress, address);
            updateWrapper.lambda().set(Registrationcenter::getPhone, phone);
            int i = this.baseMapper.update(null, updateWrapper);
            data.put("mages", i);
            return data;
        }
        return null;
    }

    // 添加不动产中心
    @Override
    public Map<String, Object> addCneter(String name, String address, String phone) {
        Map<String, Object> data = new HashMap<>();
        Registrationcenter registrationcenter = new Registrationcenter();
        registrationcenter.setName(name);
        registrationcenter.setAddress(address);
        registrationcenter.setPhone(phone);
        int i = this.baseMapper.insert(registrationcenter);
        if(i == 1){
            data.put("mages", i);
            return data;
        }
        return null;
    }
}
