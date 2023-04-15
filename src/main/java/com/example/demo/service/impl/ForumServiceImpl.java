package com.example.demo.service.impl;

import com.example.demo.bean.ForumMain;
import com.example.demo.repository.IForumMainMapper;
import com.example.demo.repository.IForumMinfoMapper;
import com.example.demo.service.IForumMainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Map.Entry;

@Service
public class ForumServiceImpl implements IForumMainService {

    @Autowired
    private IForumMainMapper forumMainMapper;
    @Autowired
    private IForumMinfoMapper forumMinfoMapper;

    /**
     * 按类别查看帖子
     *
     * @param mainType
     * @param start
     * @param offset
     * @return
     */
    @Override
    public List<Map<String, Object>> getMainPage(String mainType, Integer start, Integer offset) {
        List<Map<String, Object>> maps = null;
        if (mainType != null) {
            //按类别查看帖子
            maps = forumMainMapper.selectMainByType(mainType, start, offset);
        } else {
            //查看精华帖子
            maps = forumMainMapper.selectMainByReCommend(start, offset);
        }
        return maps;
    }

    /**
     * 查看精华帖子
     *
     * @param start
     * @param offset
     * @return
     */
    @Override
    public List<Map<String, Object>> selectMainByReCommend(Integer start, Integer offset) {
        return forumMainMapper.selectMainByReCommend(start, offset);
    }

    @Override
    public List<ForumMain> getRecommendTop5(String mainType) {
        Map<String,Object> map = new HashMap<>();
        map.put("mainType", mainType);
        map.put("mainRecommend", 1);
        map.put("start", 0);
        map.put("offset", 3);
        // parm 共有4个参数 mainType 论点内容 varchar 不是必须 mainRecommend 精华 integer 不是必须
        // start 分页开始位置 integer *必须参数 offset 偏移量,查询多少条数据 *必须参数
        return forumMainMapper.selectByType(map);
    }

    @Override
    public List<Map<String, Object>> getMainByTitle(String mainTitle) {
        return forumMainMapper.selectMainByTitle(mainTitle);
    }

    /**
     * 这个是获取版主的信息
     */
    @Override
    public List<Map<String, Object>> getBanzhu(String mainType) {
        return forumMainMapper.selectBanzhuByMainType(mainType);
    }

    /**
     * 获取版块信息
     */
    @Override
    public Map<String, Object> getMinfo(String mainType) {
        return forumMinfoMapper.selectMinfoByMainType(mainType);
    }

    /**
     * 获取版主姓名
     */
    @Override
    public List<Map<String, Object>> getBanzhuAndSyslogin(String mainType) {
        return forumMainMapper.selectBanzhuAndUserByMainType(mainType);
    }

    /**
     * 返回总数
     */
    @Override
    public Long getMainCount(String mainType) {
        Long count = 0L;
        if (mainType != null && mainType.equals("null")) {
            count = forumMainMapper.selectMainCountByMainType(mainType);
        } else {
            count = forumMainMapper.selectMainCountByRecommend();
        }
        return count;
    }

    @Override
    public String getPage(Long count, Integer currentPage, Integer offset, Map<String, String> parm) {
        Long currentLong = Long.parseLong(currentPage + "");
        Long countPage = 0L;

        if (count % offset != 0) {
            countPage = count / offset + 1;
        } else {
            countPage = count / offset;
        }

        StringBuffer sbParm = new StringBuffer("");

        //设置额外附加参数
        if (parm != null) {
            Set<Map.Entry<String, String>> entrySet = parm.entrySet();

            for (Entry<String, String> entry : entrySet) {
                sbParm.append("&" + entry.getKey() + "=" + entry.getValue());
            }

        }

        StringBuffer sb = new StringBuffer();
        if (currentPage > 1) {
            Set<Entry<String, String>> entrySet = parm.entrySet();
            sb.append("<span class=\"page\"><a href=\"?page=" + (currentPage - 1));
            sb.append(sbParm);
            sb.append("\">«</a></span>");
        } else {
            sb.append("<span class=\"page\"><a href=\"?page=1");
            sb.append(sbParm);
            sb.append("\">«</a></span>");
        }
        sb.append("<span class=\"page\" style=\"width: 50px !important;\">");

        sb.append("<a href=\"?page=1");
        sb.append(sbParm);
        sb.append("\">start</a>");

        sb.append("</span>");

        //中间页数导航
        if ((countPage - currentLong + 1) >= 5) {
            for (Long i = currentLong; i < currentPage + 5; i++) {
                sb.append("<span class=\"page\">");

                sb.append("<a href=\"?page=" + i);
                sb.append(sbParm);
                sb.append("\">" + i + "</a>");

                sb.append("</span>");
            }
        } else if (countPage - 4 > 0) {
            for (long i = countPage - 4; i <= countPage; i++) {
                sb.append("<span class=\"page\">");

                sb.append("<a href=\"?page=" + i);
                sb.append(sbParm);
                sb.append("\">" + i + "</a>");

                sb.append("</span>");
            }
        } else {
            for (long i = 1; i <= countPage; i++) {
                sb.append("<span class=\"page\">");

                sb.append("<a href=\"?page=" + i);
                sb.append(sbParm);
                sb.append("\">" + i + "</a>");

                sb.append("</span>");
            }
        }

        sb.append("<span class=\"page\" style=\"width: 40px !important;\">");

        sb.append("<a href=\"?page=" + (countPage == 0 ? 1 : countPage));
        sb.append(sbParm);
        sb.append("\">end</a>");

        sb.append("</span>");

        if (currentLong < countPage) {
            sb.append("<span class=\"page\">");

            sb.append("<a href=\"?page=" + currentLong + 1);
            sb.append(sbParm);
            sb.append("\">»</a>");

            sb.append("</span>");
        } else {
            sb.append("<span class=\"page\">");

            sb.append("<a href=\"?page=" + currentLong);
            sb.append(sbParm);
            sb.append("\">»</a>");

            sb.append("</span>");
        }

        sb.append("<span>");
        sb.append("<input id=\"pageNum\" type=\"text\" placeholder=\"共" + countPage + "页\" style=\"width: 75px;height: 30px;\">");
        sb.append("</span>");

        sb.append("<span>");
        sb.append("<button type=\"button\" class=\"btn btn-primary btn-xs\" style=\"padding-bottom: 1px;\" onclick=\"goPage('" + sbParm.toString() + "')\">跳转</button>");
        sb.append("</span>");


        return sb.toString();
    }

    /**
     * 第二阶段
     * 完成细节,表单提交保存.
     * 更新数据.
     */
    @Override
    public int insertMain(ForumMain main) {
        int flag = 0;
        flag = forumMainMapper.insertMain(main);
        flag += forumMainMapper.insertInfo(main);
        flag += forumMinfoMapper.updateMinfo(main);

        return flag;
    }

    @Override
    public int editJinghua(Integer recommend, String mainId) {
        return forumMainMapper.updateMainRecommend(recommend, mainId);
    }

    @Override
    public int insertSecond(String mainId, String content, Integer sequence, Integer resequence, String reId,
                            String username, String nickname) {
        String secId = UUID.randomUUID().toString();
        int count = 0;
        count = forumMainMapper.insertSecond(secId, mainId, content, sequence, resequence, reId, username, nickname);
        count += forumMainMapper.updateInfo(mainId, nickname);
        count += forumMainMapper.updateBaseUserinfo(username);
        count += forumMinfoMapper.updateMinfoForReply(mainId);

        return count;
    }

    @Override
    public int getSequence(String mainId) {
        return forumMainMapper.selectInfo(mainId);
    }

    /**
     * 该方法是一个隐藏方法,用户可以使使用<re></re>标签给用户发送信息
     * map key
     * 1 content
     * 2 sequence
     * 3 user
     *
     * @param content
     * @return
     */
    @Override
    public Map<String, Object> convert(String content) {
        Map<String, Object> resultMap = new HashMap<>();
        List<String> listSequence = new ArrayList<>();
        List<String> listNickname = new ArrayList<>();
        while (content.indexOf("^re^") > -1 && content.indexOf("^/re^") > -1) {
            String temp = content.substring(content.indexOf("^re^"), content.indexOf("^/re^") + 5);
            content = content.replace(temp, "");
            temp = temp.replace("^re^", "").replace("^/re^", "").replace("，", ",");
            if ("".equals(temp.trim().indexOf(","))) {
                String[] temps = temp.split(",");
                for (String item : temps) {
                    item = item.trim();
                    if (item.indexOf("@") > -1 && item.length() > 1) {
                        item = item.replace("@", "");
                        if (!"".equals(item.trim())) {
                            listSequence.add(item);
                        }
                    } else if (item.indexOf("#") > -1) {
                        item = item.replace("#", "");
                        if (!"".equals(item.trim())) {
                            listNickname.add(item);
                        }
                    }
                }
            }
        }

        resultMap.put("content", content);

        if (listSequence.size() > 0) {
            resultMap.put("sequence", listSequence);
        }
        if (listNickname.size() > 0) {
            resultMap.put("user", listNickname);
        }

        return resultMap;
    }

    /**
     * 获取详细的帖子主贴
     * @param mainId
     * @return
     */
    @Override
    public Map<String, Object> getSecondMain(String mainId) {

        return forumMainMapper.selectMainByMainId(mainId);
    }

    /**
     * 获取跟帖
     * @param mainId
     * @param order
     * @param start
     * @param offset
     * @return
     */
    @Override
    public List<Map<String, Object>> getSecond(String mainId, String order, Integer start, Integer offset) {
        List<Map<String, Object>> maps = forumMainMapper.selectSecond(mainId, order, start, offset);
        for (Map<String, Object> entity : maps){
            java.sql.Timestamp timestamp = (java.sql.Timestamp)entity.get("sec_creatime");
            long time = timestamp.getTime();    //转换为Long
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日    hh时mm分ss秒");
            String creatime = simpleDateFormat.format(new Date(time));					   //时间转换
            entity.put("sec_creatime", creatime);										   //修改元素
        }

        return maps;
    }

    @Override
    public long getSecondCount(String mainId) {
        return forumMainMapper.selectSecondCount(mainId);
    }

    /**
     * 如果传递过来的mainType 证明这是一个2级菜单
     * 如果传递过来的是mainId 证明这是一个3级菜单
     * @param mainType
     * @param mainId
     * @return
     */
    @Override
    public Map<String, Object> getPath2(String mainType, String mainId) {

        if (mainId == null) {
            return forumMainMapper.selectDictionaryByDictKey(mainType);
        } else {
            return forumMainMapper.selectMainLeftDictByMainId(mainId);
        }
    }

    /**
     * 获取模块分类
     * @return
     */
    @Override
    public List<Map<String, Object>> getDictionaryByGroup(String group) {
        return forumMainMapper.selectDictionary(group);
    }


}
