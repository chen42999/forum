package com.example.demo.repository;

import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface ISecondPageMapper {

    // 主贴
    Map<String, Object> selectMain(String mainId, Integer start, Integer offset);
    // 跟帖
    List<Map<String, Object>> selectSecond(String mainId, Integer start, Integer offset);
    int saveSecondPage(String secId, String mainId,String content, String creatuser);

    Long getSecondCount(String mainId);
}
