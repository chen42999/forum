package com.example.demo.service.impl;

import com.example.demo.bean.MyInfo;
import com.example.demo.bean.MyMain;
import com.example.demo.repository.IMainPageMapper;
import com.example.demo.service.IMainPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class MainPageServiceImpl implements IMainPageService {

    @Autowired
    private IMainPageMapper mainPageMapper;

    @Override
    public int saveMainInfo(MyInfo info) {
        return mainPageMapper.saveMainInfo(info);
    }

    @Override
    public int saveMainContent(MyMain main) {
        String mainId = UUID.randomUUID().toString();

        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        String mainCreatime = format.format(date);
        ;
        Integer mainCommend = 0;

        main.setMainId(mainId);
        main.setMainCreatime(mainCreatime);
        main.setMainCommend(mainCommend);

        MyInfo info = new MyInfo();
        info.setMainId(mainId);
        info.setInfoReply(0);
        info.setInfoSee(0);
        info.setInfoLastuser(main.getMainCreatuser());
        info.setInfoLastime(mainCreatime);
        mainPageMapper.saveMainInfo(info);

        return mainPageMapper.saveMainContent(main);
    }

    @Override
    public List<Map<String, Object>> getMainPage(int row, int offset) {

        return mainPageMapper.getMainPage(row, offset);
    }

    @Override
    public Long getMainCount() {
        return mainPageMapper.getMainCount();
    }

    @Override
    public StringBuffer getPage(Long count, Integer currentPage, Integer offset) {
        Long currentLong = Long.parseLong(currentPage + "");
        Long countPage = 0L;
        // 计算总数
        if (count % offset != 0) {
            countPage = count / offset + 1;
        } else {
            countPage = count / offset;
        }

        // 使用StringBuffer字符串拼接
        StringBuffer buffer = new StringBuffer();
        if (countPage > 1) {
            buffer.append("<span class=\"page\"><a href=\"?page=" + (currentPage - 1));
            buffer.append("\"> << </a></span>");
        } else {
            buffer.append("<span class=\"page\"><a href=\"?page=1");
            buffer.append("\"> << </a></span>");
        }
        buffer.append("<span class=\"page\" style=\"width: 50px !important;\">");
        buffer.append("<a href=\"?page=1");
        buffer.append("\">start</a>");
        buffer.append("</span>");

        if ((countPage - currentLong + 1) >= 5) {
            for (Long i = currentLong; i < countPage; i++) {
                buffer.append("<span class=\"page\">");
                buffer.append("<a href=\"?page=").append(i);
                buffer.append("\">").append(i).append("</a>");
                buffer.append("</span>");
            }
        } else if (countPage - 4 > 0) {
            for (Long i = currentLong - 4; i <= countPage; i++) {
                buffer.append("<span class=\"page\">");
                buffer.append("<a href=\"?page=").append(i);
                buffer.append("\">").append(i).append("</a>");
                buffer.append("</span>");
            }
        } else {
            for (Long i = 1L; i <= countPage; i++) {
                buffer.append("<span class=\"page\">");
                buffer.append("<a href=\"?page=").append(i);
                buffer.append("\">").append(i).append("</a>");
                buffer.append("</span>");
            }
        }

        buffer.append("<span class=\"page\" style=\"width: 40px !important;\">");
        buffer.append("<a href=\"?page=" + (countPage == 0 ? 1 : countPage));
        buffer.append("\">end</a>");
        buffer.append("</span>");

        if (currentLong < countPage) {
            buffer.append("<span class=\"page\">");
            buffer.append("<a href=\"?page=" + currentLong + 1);
            buffer.append("\"> >> </a>");
            buffer.append("</span>");
        } else {
            buffer.append("<span class=\"page\">");
            buffer.append("<a href=\"?page=" + currentLong);
            buffer.append("\"> >> </a>");
            buffer.append("</span>");
        }

        // 输出总页数
        buffer.append("<span>");
        buffer.append(" 共" + countPage + "页");
        buffer.append("</span>");

        return buffer;
    }
}
