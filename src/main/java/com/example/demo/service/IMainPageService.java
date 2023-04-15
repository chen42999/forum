package com.example.demo.service;

import com.example.demo.bean.MyInfo;
import com.example.demo.bean.MyMain;

import java.util.List;
import java.util.Map;

public interface IMainPageService {

    int saveMainInfo(MyInfo info);
    int saveMainContent(MyMain main);
    List<Map<String, Object>> getMainPage(int row, int offset);
    Long getMainCount();
    StringBuffer getPage(Long count, Integer currentPage, Integer offset);
}
