package com.example.demo.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MyInfo {

    private Integer infoId;
    private String mainId;
    private Integer infoSee;
    private Integer infoReply;
    private String infoLastuser;
    private String infoLastime;
}
