package com.example.demo.controller;

import com.example.demo.bean.Dictionary;
import com.example.demo.bean.ForumMain;
import com.example.demo.service.IIndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;
import java.util.stream.Collectors;

@Controller
public class IndexController {

    @Autowired
    private IIndexService indexService;

    @RequestMapping({"/", "/index"})
    public ModelAndView index() {
        List<Dictionary> dictionaries = indexService.selectDictionary();
//        List<Map<String, List<ForumMain>>> forumMains = indexService.selectForumMain();

        ModelAndView modelAndView = new ModelAndView("index");

        // 获取str.getDictGroup()为"java"的数据并且去重
        Set<Dictionary> java = dictionaries.stream().filter(str -> str.getDictGroup().equals("java")).collect(Collectors.toSet());

        List<Map<String, List<ForumMain>>> list = new ArrayList<>();

        for (Dictionary dictionary : dictionaries) {
            List<ForumMain> top5 = indexService.getRecommendTop5(dictionary.getDictKey());
            if (top5 != null && top5.size() > 0) {
                Map<String, List<ForumMain>> map = new HashMap<>();
                map.put(dictionary.getDictKey(), top5);
                list.add(map);
            }
        }

        modelAndView.addObject("java", java);
        modelAndView.addObject("top5s", list);

//        java.forEach(System.out::println);
//        forumMains.stream().filter(i -> i.values()).forEach(System.out::println);

        return modelAndView;
    }
}
