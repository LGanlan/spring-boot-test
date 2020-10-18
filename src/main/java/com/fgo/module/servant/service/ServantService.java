package com.fgo.module.servant.service;

import com.fgo.module.servant.model.param.ServantParam;
import com.fgo.module.servant.model.result.ServantResult;
import com.fgo.util.page.LayuiPageInfo;

public interface ServantService {

    /**
     * 列表
     */
    public LayuiPageInfo list(ServantParam servantParam);

    /**
     * 添加
     */
    int insert(ServantParam servantParam);

    /**
     * 修改
     */
    int update(ServantParam servantParam);

    /**
     * 删除
     */
    int delete(ServantParam servantParam);

    /**
     * 详情
     */
    ServantResult detail(ServantParam servantParam);

}