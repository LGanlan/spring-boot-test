package com.fgo.module.servant.controller;

import com.fgo.module.servant.model.param.ServantParam;
import com.fgo.module.servant.model.result.ServantResult;
import com.fgo.module.servant.service.ServantService;
import com.fgo.util.ResponseData;
import com.fgo.util.page.LayuiPageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
     * 列表页
     */
    @RequestMapping("/add")
    public String add() {
        return "/servant/servant_add";
    }

    /**
     * 编辑页
     */
    @RequestMapping("/edit")
    public String edit(ServantParam servantParam, Model model) {
        model.addAttribute("id", servantParam.getId().toString());
        return "/servant/servant_edit";
    }

    /**
     * 列表
     */
    @ResponseBody
    @RequestMapping("/list")
    public LayuiPageInfo list(ServantParam servantParam) {
        return servantService.list(servantParam);
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
            servantService.delete(servantParam);
            return ResponseData.success();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseData.error();
        }
    }

    /**
     * 详情
     */
    @ResponseBody
    @RequestMapping("/detail")
    public ResponseData detail(ServantParam servantParam) {
        try {
            ServantResult detail = servantService.detail(servantParam);
            return ResponseData.success(detail);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseData.error();
        }
    }

}