package com.fgo.util;

import lombok.Data;

/**
 * 响应数据封装
 */
@Data
public class ResponseData {

    // 响应码
    private Integer code;

    // 返回数据
    private Object data;

    public ResponseData(Integer code) {
        this.code = code;
    }

    public ResponseData(Object data) {
        this.code = 200;
        this.data = data;
    }

    public static ResponseData success() {
        return new ResponseData(200);
    }

    public static ResponseData success(Object data) {
        return new ResponseData(data);
    }

    public static ResponseData error() {
        return new ResponseData(500);
    }

}