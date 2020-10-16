package com.fgo.servant.service.impl;

import com.fgo.servant.mapper.ServantMapper;
import com.fgo.servant.model.result.ServantResult;
import com.fgo.servant.service.ServantService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ServantServiceImpl implements ServantService {

    @Resource
    private ServantMapper servantMapper;

    @Override
    public List<ServantResult> list() {
        return servantMapper.list();
    }

}
