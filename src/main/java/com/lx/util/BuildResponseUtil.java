package com.lx.util;

import com.lx.constant.MapField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * Description:
 * Author:Jason Li
 * Date:2022-09-11
 * Time:10:25 PM
 */
@Component
public class BuildResponseUtil {
    @Autowired
    private MockMapUtil mockMapUtil;

    public Map<String, String> findMatchResp(HttpServletRequest request) {
        String uri = request.getRequestURI();
        String method = request.getMethod();

        HashMap<Map<String, String>, Map<String, String>> mockMap = mockMapUtil.getMockMap();
        for (Map.Entry<Map<String, String>, Map<String, String>> entry : mockMap.entrySet()) {
            Map<String, String> keyMap = entry.getKey();
            if (keyMap.get(MapField.METHOD).equalsIgnoreCase(method)
                    && keyMap.get(MapField.URL_PATH).equalsIgnoreCase(uri)) {
                if (null !=request.getHeader("mock")) {
                    if (null != keyMap.get("mock")) {
                        if (request.getHeader("mock").equals(keyMap.get("mock"))) {
                            return entry.getValue();
                        }
                    }
                } else {
                    return entry.getValue();
                }
            }
        }
        // TODO
        return null;

    }

    public void buildResp(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Map<String, String> matchResp = findMatchResp(request);
        if (null != matchResp) {
            response.setStatus(Integer.parseInt(matchResp.get(MapField.STATUS)));
            response.setContentType("application/json;charset=utf-8");
            PrintWriter writer = response.getWriter();
            writer.println("{");
            writer.println(matchResp.get(MapField.BODY));
            writer.println("}");
            writer.close();
        } else {
            // no mapping
            response.setStatus(404);
            response.setContentType("application/json;charset=utf-8");
            PrintWriter writer = response.getWriter();
            writer.write("No Mapping Found");
            writer.close();
        }
    }
}
