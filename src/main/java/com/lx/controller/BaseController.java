package com.lx.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description:
 * Author:Jason Li
 * Date:2022-09-11
 * Time:8:01 PM
 */
@RestController
public class BaseController {

    @GetMapping("/info")
    public String getInfo(){
        return "aaaa";
    }
}
