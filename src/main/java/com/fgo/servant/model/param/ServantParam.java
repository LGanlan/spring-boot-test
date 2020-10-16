package com.fgo.servant.model.param;

import lombok.Data;

/**
 * 从者
 * */
@Data
public class ServantParam {

        // 主键id
        private Long id;

        // 姓名
        private String name;

        // 职阶id
        private Long classId;

        // 评分id
        private Long scoreId;

        // 是否拥有（0 否 1 是）
        private int isHas;

}