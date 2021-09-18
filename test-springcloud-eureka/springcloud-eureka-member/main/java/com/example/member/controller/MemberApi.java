package com.example.member.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberApi {

    /**
     *  为了区分负载均衡
     */
    @Value("${server.port}")
    private String port;


    @RequestMapping("/getmember")
    public String Member() {
        return "这里是会员服务,端口号为："+port ;
    }
}

