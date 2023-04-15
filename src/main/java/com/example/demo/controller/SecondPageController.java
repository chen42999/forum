package com.example.demo.controller;

import com.example.demo.service.ISecondPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
public class SecondPageController {

    @Autowired
    private ISecondPageService secondPageService;

    @RequestMapping(value = "/secondPageContent", method = RequestMethod.GET)
    public ModelAndView goSecondPage(String mainId,
                                     @RequestParam(name = "page", defaultValue = "1") Integer page,
                                     @RequestParam(name = "row", defaultValue = "15") Integer row) {
        ModelAndView modelAndView = new ModelAndView("/jsp/secondPage");
        Map<String, Object> mainAndSeconds = secondPageService.getMainAndSeconds(mainId, (page-1)*row, row);
        modelAndView.addObject("mainAndSeconds", mainAndSeconds);

        Long count = secondPageService.getSecondCount(mainId);
        Map<String, String> parm = new HashMap<>();
        parm.put("mainId", mainId);
        String pageHtml = secondPageService.getPage(count, page, row, parm);
        modelAndView.addObject("pageHtml", pageHtml);
        return modelAndView;
    }

    @PostMapping("/saveSecondPage")
    public ModelAndView saveSecondPage(HttpServletRequest request,
                                       String mainId,
                                       String content) {
        ModelAndView modelAndView = new ModelAndView();
        String mainCreatuser = request.getRemoteAddr();
        int res = secondPageService.saveSecondPage(mainId, content, mainCreatuser);
        if (res != 0) {
            modelAndView.setViewName("redirect:/secondPageContent?mainId=" + mainId);
        } else {
            modelAndView.setViewName("404");
        }
        return modelAndView;
    }
}
