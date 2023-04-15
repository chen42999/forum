package com.example.demo.service;

import com.example.demo.bean.ForumMain;

import java.util.List;
import java.util.Map;

public interface IForumMainService {
    List<Map<String, Object>> getMainPage(String mainType, Integer start, Integer offset);

    List<Map<String, Object>> selectMainByReCommend(Integer start, Integer offset);

    List<ForumMain> getRecommendTop5 (String mainType);

    List<Map<String, Object>> getMainByTitle(String mainTitle);

    List<Map<String, Object>> getBanzhu(String mainType);

    public Map<String, Object> getMinfo(String mainType);

    List<Map<String, Object>> getBanzhuAndSyslogin(String mainType);

    Long getMainCount(String mainType);


    public String getPage(Long count, Integer currentPage, Integer offset, Map<String, String> parm);

    int insertMain(ForumMain main);

    int editJinghua(Integer recommend, String mainId);

    int insertSecond(String mainId, String content, Integer sequence, Integer resequence,
                     String reId, String username, String nickname);

    int getSequence(String mainId);

    Map<String,Object> convert (String content);

    Map<String,Object> getSecondMain (String mainId);

    List<Map<String,Object>> getSecond (String mainId,String order,Integer start,Integer offset);

    long getSecondCount (String mainId);

    Map<String,Object> getPath2 (String mainType,String mainId);

    List<Map<String,Object>> getDictionaryByGroup (String group);

}
