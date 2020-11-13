package com.lening.controller;

import com.alibaba.fastjson.JSONArray;
import com.lening.entity.MenuBean;
import com.lening.service.SysService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

/**
 * 创作时间：2020/11/4 14:36
 * 作者：李增强
 */
@RequestMapping("/sys")
@Controller
public class SysController {

    @Resource
    private SysService sysService;

    @RequestMapping("/getMenuJson")
    public String getMenuJson(Model model){
        List<MenuBean> list = sysService.getMenuList();
        String json = JSONArray.toJSONString(list);
        model.addAttribute("json", json);
        return "left";
    }
}
