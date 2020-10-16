package com.fgo.servant.controller;

import com.fgo.servant.model.param.ServantParam;
import com.fgo.servant.service.ServantService;
import com.fgo.util.ResponseData;
import com.fgo.util.page.LayuiPageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
    public LayuiPageInfo list() {
        return servantService.list();
    }

    /**
     * 添加
     */
    @ResponseBody
    @RequestMapping("/insert")
    public ResponseData insert(ServantParam servantParam) {
        try {
            servantService.insert(servantParam);
            return ResponseData.success();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseData.error();
        }
    }

    /**
     * 修改
     */
    @ResponseBody
    @RequestMapping("/update")
    public ResponseData update(ServantParam servantParam) {
        try {
            servantService.update(servantParam);
            return ResponseData.success();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseData.error();
        }
    }

    /**
     * 删除
     */
    @ResponseBody
    @RequestMapping("/delete")
    public ResponseData delete(ServantParam servantParam) {
        try {
            return ResponseData.success();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseData.error();
        }
    }

}