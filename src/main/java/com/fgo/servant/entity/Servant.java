package com.fgo.servant.entity;

import lombok.Data;

/**
 * 从者
 * */
@Data
public class Servant {

    // 主键id
    private Long id;

    // 姓名
    private String name;

    // 职阶id
    private Long classId;

    // 评分id
    private Long scoreId;

}