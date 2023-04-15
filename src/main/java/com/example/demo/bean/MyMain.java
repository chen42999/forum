package com.example.demo.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MyMain {

    private String mainId;
    private String mainTitle;
    private String mainContent;
    private String mainCreatime;
    private String mainCreatuser;
    private Integer mainCommend;
}
