package com.example.demo.controller;

import com.example.demo.bean.MyMain;
import com.example.demo.service.IMainPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
public class MainPageController {

    @Autowired
    private IMainPageService mainPageService;

    @RequestMapping("/goMainPage")
    public ModelAndView goMainPage(HttpServletRequest request,
                                   @RequestParam(name = "page", defaultValue = "1") Integer page,
                                   @RequestParam(name = "row", defaultValue = "40") Integer row) {
        ModelAndView modelAndView = new ModelAndView("/jsp/mainPage");
        List<Map<String, Object>> mainContent = mainPageService.getMainPage((page - 1) * row, row);
        modelAndView.addObject("main", mainContent);

        // 得到帖子的总数
        Long mainCount = mainPageService.getMainCount();
        // 获取分页
        StringBuffer pageHtml = mainPageService.getPage(mainCount, page, row);
        modelAndView.addObject("pageHtml", pageHtml);
        return modelAndView;
    }

    @RequestMapping("/saveUeditorContent")
    public ModelAndView saveUeditor(HttpServletRequest request,
                                    @RequestParam("content") String content,
                                    @RequestParam("mainTitle") String mainTitle) {
        ModelAndView modelAndView = new ModelAndView();
        String mainCreatuser = request.getRemoteAddr();

        MyMain main = new MyMain();
        main.setMainContent(content);
        main.setMainTitle(mainTitle);
        main.setMainCreatuser(mainCreatuser);

        int i = mainPageService.saveMainContent(main);
        if (i == 1) {
            modelAndView.setViewName("redirect:/goMainPage");
        } else {
            modelAndView.setViewName("error");
        }
        return modelAndView;
    }

}
