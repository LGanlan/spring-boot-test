package com.fgo.module.servant.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fgo.module.servant.entity.Servant;
import com.fgo.module.servant.mapper.ServantMapper;
import com.fgo.module.servant.model.param.ServantParam;
import com.fgo.module.servant.model.result.ServantResult;
import com.fgo.module.servant.service.ServantService;
import com.fgo.util.page.LayuiPageFactory;
import com.fgo.util.page.LayuiPageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ServantServiceImpl implements ServantService {

    @Resource
    private ServantMapper servantMapper;

    @Override
    public LayuiPageInfo list(ServantParam servantParam) {
        Page page = LayuiPageFactory.defaultPage();
        IPage<ServantResult> servantResultPage = servantMapper.list(page, servantParam);
        return LayuiPageFactory.createPageInfo(servantResultPage);
    }

    @Override
    public int insert(ServantParam servantParam) {
        Servant servant = new Servant();
        BeanUtil.copyProperties(servantParam, servant);
        return servantMapper.insert(servant);
    }

    @Override
    public int update(ServantParam servantParam) {
        Servant servant = new Servant();
        BeanUtil.copyProperties(servantParam, servant);
        return servantMapper.updateById(servant);
    }

    @Override
    public int delete(ServantParam servantParam) {
        return servantMapper.deleteById(servantParam.getId());
    }

    @Override
    public ServantResult detail(ServantParam servantParam) {
        Servant servant = servantMapper.selectById(servantParam.getId());
        ServantResult servantResult = new ServantResult();
        BeanUtil.copyProperties(servant, servantResult);
        servantResult.setId(servant.getId().toString());
        return servantResult;
    }

}