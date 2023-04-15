package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.example.demo.bean.ForumMain;
import com.example.demo.bean.User;
import com.example.demo.service.impl.ForumServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class ForumMainController {

    @Resource
    ForumServiceImpl fS;

    @RequestMapping(value = "/mainContent")
    public ModelAndView viewContro(HttpServletRequest request,
                                   @RequestParam(name = "page", defaultValue = "1") Integer page,
                                   @RequestParam(name = "row", defaultValue = "40") Integer row,
                                   String mainType) {
        ModelAndView mav = new ModelAndView();

        //获取main 与 info
        List<Map<String, Object>> mainContents = fS.getMainPage(mainType, (page - 1) * row, row);
        mav.addObject("main", mainContents);

        //获取minfo信息
        Map<String, Object> mainInfo = fS.getMinfo(mainType);
        mav.addObject("minfo", mainInfo);

        //获取总共多少帖子
        Long count = fS.getMainCount(mainType);

        Map<String, String> parm = new HashMap<String, String>();
        parm.put("mainType", mainType);//参数回传

        String pageHtml = fS.getPage(count, page, row, parm);
        mav.addObject("pageHtml", pageHtml);

        //获取版主
        List<Map<String, Object>> banzhu = fS.getBanzhuAndSyslogin(mainType);
        mav.addObject("banzhu", banzhu);

        //获取分类
        List<Map<String, Object>> fenlei = fS.getDictionaryByGroup("fenlei");
        mav.addObject("fenlei", fenlei);

        mav.addObject("mainType", mainType);

        mav.setViewName("/jsp/mainContent");

        return mav;
    }

    @RequestMapping(value = "/findMainByTitle")
    public ModelAndView findMainByTitle(String mainTitle) {
        ModelAndView mav = new ModelAndView("jinghua");

        List<Map<String, Object>> mainContents = fS.getMainByTitle(mainTitle);
        mav.addObject("main", mainContents);

        return mav;
    }

    @RequestMapping(value = "/JinghuaContent")
    public ModelAndView viewJinghuaContro(HttpServletRequest request, @RequestParam(name = "page", defaultValue = "1") Integer page, @RequestParam(name = "row", defaultValue = "40") Integer row, String mainType) {
        ModelAndView mav = new ModelAndView();

        //获取main 与 info
        List<Map<String, Object>> mainContents = fS.getMainPage(null, (page - 1) * row, row);
        mav.addObject("main", mainContents);

        //获取minfo信息
		/*Map<String, Object> mainInfo = fS.getMinfo(mainType);
		mav.addObject("minfo", mainInfo);*/

        //获取总共多少帖子
        Long count = fS.getMainCount(mainType);

        //Map<String,String> parm = new HashMap<String, String>();
        //parm.put("mainType", mainType);//参数回传

        String pageHtml = fS.getPage(count, page, row, null);
        mav.addObject("pageHtml", pageHtml);

        //获取版主
		/*List<Map<String, Object>> banzhu = fS.getBanzhuAndSyslogin(mainType);
		mav.addObject("banzhu", banzhu);*/

        //获取分类
		/*List<Map<String, Object>> fenlei = fS.getDictionaryByGroup("fenlei");
		mav.addObject("fenlei", fenlei);*/

        /*mav.addObject("mainType", mainType);*/

        mav.setViewName("jinghua");

        return mav;
    }


    @RequestMapping(value = "/saveMainContent")
    public ModelAndView saveMain(HttpServletRequest request, String mainFlag, String content,
                                 String mainTitle, String mainType) {
        ModelAndView mav = new ModelAndView("redirect:/mainContent?mainType=" + mainType);

        HttpSession session = request.getSession();

        User userEntity = (User) session.getAttribute("loginEntity");

        ForumMain main = new ForumMain();
        main.setMainId(UUID.randomUUID().toString());
        main.setMainTitle(mainTitle);
        main.setMainFlag(mainFlag);
        main.setMainContent(content);
        main.setMainType(mainType);
        main.setMainDelete("n");
        main.setMainCreatuser(userEntity.getUsername());
        main.setMainNickname(userEntity.getWxname());
        main.setMainZan(0);

        fS.insertMain(main);

        return mav;
    }

    @RequestMapping(value = "/jinghua")
    @ResponseBody
    public Map<String, Boolean> editJinghua(String mainId, String flag) {
        Map<String, Boolean> resultMap = new HashMap<>();

        if ("qx".equals(flag)) {
            fS.editJinghua(5, mainId);
            resultMap.put("success", true);
        } else if ("sz".equals(flag)) {
            fS.editJinghua(1, mainId);
            resultMap.put("success", true);
        } else {
            resultMap.put("success", false);
        }

        return resultMap;
    }

    @RequestMapping(value = "/seachLogin")
    @ResponseBody
    public Map<String, Boolean> seachLogin(HttpServletRequest request) {
        Map<String, Boolean> resultMap = new HashMap<>();

        HttpSession session = request.getSession();
        User userEntity = (User) session.getAttribute("loginEntity");
        if (userEntity != null) {
            resultMap.put("success", true);
        } else {
            resultMap.put("success", false);
        }

        return resultMap;
    }
}
