package com.fgo.servant.controller;

import com.fgo.servant.model.result.ServantResult;
import com.fgo.servant.service.ServantService;
import com.fgo.util.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 从者控制器
 */
@Controller
@RequestMapping("/servant")
public class ServantController {

    @Autowired
    private ServantService servantService;

    /**
     * 列表页
     */
    @RequestMapping("")
    public String index() {
        return "/servant/servant";
    }

    /**
     * 列表
     */
    @ResponseBody
    @RequestMapping("/list")
    public ResponseData list() {
        try {
            List<ServantResult> list = servantService.list();
            return ResponseData.success(list);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseData.error();
        }
    }

}