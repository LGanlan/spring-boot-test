package com.fgo.servant.service;

import com.fgo.servant.model.result.ServantResult;

import java.util.List;

public interface ServantService {

    /**
     * 列表
     */
    public List<ServantResult> list();

}
