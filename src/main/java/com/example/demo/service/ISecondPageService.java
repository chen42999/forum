package com.example.demo.service;

import java.util.Map;

public interface ISecondPageService {

    Map<String, Object> getMainAndSeconds(String mainId, Integer start, Integer offset);

    int saveSecondPage(String mainId, String content, String creatuser);

    Long getSecondCount(String mainId);

    String getPage(Long count, Integer currentPage,
                   Integer offset, Map<String, String> parm);
}
