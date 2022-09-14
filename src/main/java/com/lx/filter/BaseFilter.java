package com.lx.filter;

import com.lx.util.BuildResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// 注入spring容器
@Component
// 定义filterName 和过滤的url
@WebFilter(filterName = "baseFilter", urlPatterns = "/*")
public class BaseFilter implements Filter {
    @Autowired
    private BuildResponseUtil buildResponseUtil;


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;

//        request.getRequestDispatcher("/result/json").forward(servletRequest, servletResponse);
//        filterChain.doFilter(servletRequest,servletResponse);
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        buildResponseUtil.buildResp(request, response);
    }

}