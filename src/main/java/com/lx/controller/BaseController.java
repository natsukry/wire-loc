package com.lx.controller;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.lx.service.MockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.GsonJsonParser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description:
 * Author:lixin_natsu
 * Date:2022-09-11
 * Time:8:01 PM
 */
@RestController
public class BaseController {
    @Autowired
    private MockService mockService;
    @GetMapping("/info")
    public String getInfo(){
        return "aaaa";
    }
//    @GetMapping("/result/json")
//    public String result(){
////        String str = "{\"name\":\"zhangsan\",\"password\":\"zhangsan123\",\"email\":\"10371443@qq.com\"}";
////        JsonElement jsonElement = JsonParser.parseString(str);
////        System.out.println(jsonElement.toString());
////        return jsonElement.toString();
//        return mockService.getMatchingResp();
//    }
}
