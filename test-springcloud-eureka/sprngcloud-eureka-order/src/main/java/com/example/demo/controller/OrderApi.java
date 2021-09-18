package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class OrderApi {
    @Autowired
    private RestTemplate restTemplate;
    @RequestMapping("/getorder")
    public String getorder() {
        // 调用member服务
        // url一般使用的都是eureka中心的地址
        // String url1="http://127.0.0.1:9100/getmember";
        // 使用status里面点开的地址也能访问，但是这个地址是随机给的
        // String url2 = "http://laptop-7hmp32ro:9100/getmember";
        // 使用eureka中的服务器别名调用
        // 但是这样需要一个注解：@LoadBalanced配置在restTemplate实体对象
        // 这样就能使用服务别名进行访问，而且使restTemplate具有客户端负载均衡能力
        // 服务别名不区分大小写
        String url = "http://eureka-member/getmember";
        String result = restTemplate.getForObject(url, String.class);
        return result;
    }
}

