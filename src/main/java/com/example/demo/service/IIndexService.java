package com.example.demo.service;

import com.example.demo.bean.Dictionary;
import com.example.demo.bean.ForumMain;

import java.util.List;
import java.util.Map;

public interface IIndexService {
    List<Dictionary> selectDictionary();

    @Deprecated
    List<Map<String,List<ForumMain>>> selectForumMain();
    //    List<ForumMain> selectForumMain();
    List<ForumMain> findAllForumMain();
    List<ForumMain> getRecommendTop5(String typeKey);
}
