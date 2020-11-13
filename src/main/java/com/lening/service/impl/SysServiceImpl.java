package com.lening.service.impl;

import com.lening.entity.MenuBean;
import com.lening.mapper.SysMapper;
import com.lening.service.SysService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 创作时间：2020/11/4 14:48
 * 作者：李增强
 */
@Service
public class SysServiceImpl implements SysService {
    @Resource
    private SysMapper sysMapper;

    @Override
    public List<MenuBean> getMenuList() {
        return sysMapper.getMenuList();
    }
}
