package com.lx.service;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.lx.util.FileUtils;
import com.lx.util.MockMapUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * Description:
 * Author:lixin_natsu
 * Date:2022-09-11
 * Time:9:03 PM
 */
@Service
public class MockService {
    @Autowired
    private MockMapUtil mockMapUtil;
    // find matching, return response as String
    public String getMatchingResp(){
        for (Map.Entry<Map<String, String>, Map<String, String>> mapMapEntry : mockMapUtil.getMockMap().entrySet()) {
            return mapMapEntry.getValue().get("body");
        }
        return "error";
    }

}
