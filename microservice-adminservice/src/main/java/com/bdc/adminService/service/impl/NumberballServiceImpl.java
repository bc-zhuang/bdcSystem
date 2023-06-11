package com.bdc.adminService.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bdc.adminService.entity.Numberball;
import com.bdc.adminService.mapper.NumberballMapper;
import com.bdc.adminService.service.INumberballService;
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
public class NumberballServiceImpl extends ServiceImpl<NumberballMapper, Numberball> implements INumberballService {

    // 查询所有号球数量
    @Override
    public Map<String, Object> selectAllFirst() {
        Map<String, Object> data = new HashMap<>();
        List<Numberball> list = this.baseMapper.selectList(null);
        data.put("list", list);
        return data;
    }

    // 根据不动产中心id查询号球数量
    @Override
    public Map<String, Object> selectByCenterId(Integer id) {
        Map<String, Object> data = new HashMap<>();
        QueryWrapper<Numberball> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(Numberball::getCenterId, id);
        List<Numberball> list = this.baseMapper.selectList(queryWrapper);
        if(list != null){
            data.put("list", list);
            return data;
        }
        return null;
    }

    // 根据号球id修改号球数量
    @Override
    public Map<String, Object> changeNumberById(Integer id, Integer number) {
        Map<String, Object> data = new HashMap<>();
        UpdateWrapper<Numberball> updateWrapper = new UpdateWrapper<>();
        updateWrapper.lambda().eq(Numberball::getId, id);
        updateWrapper.lambda().set(Numberball::getNumber, number);
        int i = this.baseMapper.update(null, updateWrapper);
        if(i == 1){
            data.put("mages", i);
            return data;
        }
        return null;
    }
}
