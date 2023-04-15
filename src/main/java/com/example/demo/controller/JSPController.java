package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/ueditor/jsp")
public class JSPController {

    @RequestMapping("/controller")
    public void getConfigInfo(HttpServletRequest request, HttpServletResponse response, String action, MultipartFile upfile) throws IOException {
        if (action.equals("config")) {
            //重定向到配置文件
            response.sendRedirect("/ueditor/jsp/config.json");
            return;
        }


    }
}
