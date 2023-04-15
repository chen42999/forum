package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller()
public class TestController {

    @RequestMapping("/login")
    public String ueditTest(){

        return "login";
    }

    @RequestMapping("/ueTest")
    public String test2() {
        return "../ueditor/index";
    }

    @RequestMapping("/controller")
    public String test3() {
        return "../ueditor/jsp/controller";
    }

    @RequestMapping("/saveUeditor")
    public ModelAndView saveUeditor(String content) {
        ModelAndView mav = new ModelAndView("test03");
        mav.addObject("content", content);
        return mav;
    }
}
