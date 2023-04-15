package com.example.demo.service.impl;

import com.example.demo.bean.Dictionary;
import com.example.demo.bean.ForumMain;
import com.example.demo.repository.IIndexMapper;
import com.example.demo.service.IIndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class IndexServiceImpl implements IIndexService {

    @Autowired
    private IIndexMapper indexMapper;

    @Override
    public List<Dictionary> selectDictionary() {
        return indexMapper.selectDictionary();
    }

    @Override
    public List<Map<String,List<ForumMain>>> selectForumMain() {
        return indexMapper.selectForumMain();
    }

    @Override
    public List<ForumMain> findAllForumMain() {
        return indexMapper.findAllForumMain();
    }

    @Override
    public List<ForumMain> getRecommendTop5(String typeKey) {
        return indexMapper.getRecommendTop5(typeKey);
    }
}
