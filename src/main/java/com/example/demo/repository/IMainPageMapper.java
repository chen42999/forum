package com.example.demo.repository;

import com.example.demo.bean.MyInfo;
import com.example.demo.bean.MyMain;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface IMainPageMapper {

    int saveMainInfo(MyInfo info);
    public int saveMainContent(MyMain main);
    List<Map<String, Object>> getMainPage(int row, int offset);
    Long getMainCount();
//    String getPage(Long count, Integer currentPage, Integer offset);
}
