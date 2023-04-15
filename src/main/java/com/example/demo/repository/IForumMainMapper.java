package com.example.demo.repository;

import com.example.demo.bean.ForumMain;
import com.example.demo.bean.MyInfo;
import com.example.demo.bean.MyMain;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface IForumMainMapper {
    List<ForumMain> selectByType(Map<String, Object> parm);

    int saveMainInfo(MyInfo info);

    public int saveMainContent(MyMain main);

    // 完成细节,表单提交保存
    int insertMain(ForumMain main);

    int insertInfo(ForumMain main);

    int updateMainRecommend(Integer recommend, String mainId);

    int insertSecond(String secId, String mainId, String content, Integer sequence, Integer resequence,
                     String reId, String username, String nickname);

    int updateInfo(String mainId, String nickname);

    int updateBaseUserinfo(String username);

    int selectInfo(String mainId);


    // 按类别查看帖子
    List<Map<String, Object>> selectMainByType(String mainType, Integer start, Integer offset);

    // 查看精华帖子
    List<Map<String, Object>> selectMainByReCommend(Integer start, Integer offset);

    List<Map<String, Object>> selectMainByTitle(String mainTitle);

    // 这个是获取版主的信息
    List<Map<String, Object>> selectBanzhuByMainType(String mainType);

    // 获取版主姓名
    List<Map<String, Object>> selectBanzhuAndUserByMainType(String mainType);

    // 按类型获取总数
    Long selectMainCountByMainType(String mainType);

    // 按精华获取总数
    Long selectMainCountByRecommend();

    // 获取详细的帖子主贴
    Map<String, Object> selectMainByMainId(String mainId);

    // 获取跟帖
    List<Map<String, Object>> selectSecond(String mainId, String order, Integer start, Integer offset);

    long selectSecondCount(String mainId);

    // 如果传递过来的mainType 证明这是一个2级菜单
    // 如果传递过来的是mainId 证明这是一个3级菜单
    Map<String, Object> selectDictionaryByDictKey(String mainType);

    Map<String, Object> selectMainLeftDictByMainId(String mainId);

    // 获取模块分类
    List<Map<String, Object>> selectDictionary(String group);

}
