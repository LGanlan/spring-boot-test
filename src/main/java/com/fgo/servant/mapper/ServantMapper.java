package com.fgo.servant.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fgo.servant.entity.Servant;
import com.fgo.servant.model.result.ServantResult;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ServantMapper extends BaseMapper<Servant> {

    /**
     * 列表
     */
    IPage<ServantResult> list(@Param("page") Page page);

}