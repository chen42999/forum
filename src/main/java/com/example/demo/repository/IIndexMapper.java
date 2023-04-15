package com.example.demo.repository;

import com.example.demo.bean.Dictionary;
import com.example.demo.bean.ForumMain;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface IIndexMapper {
    List<Dictionary> selectDictionary();
    List<Map<String,Object>> selectDictionaryByGroup(String group);

    @Deprecated  // 废弃掉该接口
    List<Map<String,List<ForumMain>>> selectForumMain();
    List<ForumMain> getRecommendTop5(String typeKey);
    @Deprecated
    List<ForumMain> selectByType(Map<String,Object> parm);
    List<ForumMain> findAllForumMain();
}
