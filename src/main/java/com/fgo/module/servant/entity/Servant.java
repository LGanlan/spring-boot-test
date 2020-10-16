package com.fgo.module.servant.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 从者
 * */
@Data
@TableName("servant")
public class Servant {

    // 主键id
    @TableField("id")
    private Long id;

    // 姓名
    @TableField("name")
    private String name;

    // 职阶id
    @TableField("class_id")
    private Long classId;

    // 评分id
    @TableField("score_id")
    private Long scoreId;

    // 是否拥有（0 否 1 是）
    @TableField("is_has")
    private int isHas;

}