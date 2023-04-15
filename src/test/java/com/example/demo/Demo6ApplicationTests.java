package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.DigestUtils;

import java.nio.charset.StandardCharsets;

@SpringBootTest
class Demo6ApplicationTests {

    @Test
    void contextLoads() {
        String md5 = DigestUtils.md5DigestAsHex("123456".getBytes(StandardCharsets.UTF_8));
        System.out.println(md5);
    }
}
