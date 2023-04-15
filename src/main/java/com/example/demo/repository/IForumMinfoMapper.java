package com.example.demo.repository;

import com.example.demo.bean.ForumMain;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

@Mapper
public interface IForumMinfoMapper {
    // 获取版块信息
    Map<String, Object> selectMinfoByMainType(String mainType);

    // 更新数据
    int updateMinfo(ForumMain main);

    int updateInfo(String mainType);

    int updateMinfoForReply(String mainId);
}
