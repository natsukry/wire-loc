package com.lx.util;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * Description: read and parse mapping
 * Author:Jason Li
 * Date:2022-09-11
 * Time:10:07 PM
 */
@Component
public class MockMapUtil {
    // K : requestJson method->val url->val
    // V : responseJson method->val url->val
    private HashMap<Map<String, String>, Map<String, String>> mockMap = new HashMap<>();

    @PostConstruct
    public void parseMapping() throws Exception {
        // read mapping files
        // parse status, body

        String dir = this.getClass().getClassLoader().getResource("mapping").getPath();
        System.out.println(dir);
        File dirFile = new File(dir); // /mapping

        for (File f : dirFile.listFiles()) { // /mapping/tax
            String str = FileUtils.readAsString(f);
            JsonObject jsonObject = JsonParser.parseString(str).getAsJsonObject();

            JsonObject requestJObj = jsonObject.get("request").getAsJsonObject();
            Map<String, String> requestMap = new HashMap();

            requestMap.put("method", trimHeadEnd(requestJObj.get("method").toString()));
            requestMap.put("urlPath", trimHeadEnd(requestJObj.get("urlPath").toString()));
            if (null != requestJObj.get("mock")){
                requestMap.put("mock", trimHeadEnd(requestJObj.get("mock").toString()));
            }


            JsonObject responseJObj = jsonObject.get("response").getAsJsonObject();
            Map<String, String> responseMap = new HashMap();
            responseMap.put("status", trimHeadEnd(responseJObj.get("status").toString()));
            responseMap.put("body", trimHeadEnd(responseJObj.get("body").toString()));


            mockMap.put(requestMap, responseMap);

            System.out.println(mockMap);
        }
    }

    public HashMap<Map<String, String>, Map<String, String>> getMockMap() {
        return mockMap;
    }

    public String trimHeadEnd(String str) {
        if (str.contains("\"")) {
            return str.substring(1, str.length() - 1);
        }
        return str;
    }


}
