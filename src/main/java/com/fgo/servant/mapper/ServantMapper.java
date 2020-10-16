package com.fgo.servant.mapper;

import com.fgo.servant.model.result.ServantResult;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ServantMapper {

    /**
     * 列表
     */
    List<ServantResult> list();

}