package com.fgo.module.common;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class commontroller {

    private String prefix = "/common";

    /**
     * 首页
     */
    @RequestMapping("")
    public String index() {
        return prefix + "/index";
    }

    /**
     * 欢迎页
     */
    @RequestMapping("/welcome")
    public String welcome() {
        return prefix + "/page/welcome";
    }

    /**
     * 菜单页
     */
    @RequestMapping("/menu")
    public String menu() {
        return prefix + "/page/menu";
    }

}