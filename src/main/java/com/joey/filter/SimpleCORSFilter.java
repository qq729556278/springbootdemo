package com.joey.filter;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by aijiao on 2016/11/16.
 */
@Component
public class SimpleCORSFilter implements Filter {
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletResponse response = (HttpServletResponse) res;
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "x-requested-with");
        HttpServletRequest request = (HttpServletRequest) req;
        HttpSession session = request.getSession();
        System.out.println("########filter start########");
        String url = request.getRequestURI();
        // 需要登录路径过滤
        System.out.println(url);
        if (url.equals("/view/index.jsp") || url.equals("/")) {
            if (session.getAttribute("userSession") == null) {
                RequestDispatcher dispatcher = req
                        .getRequestDispatcher("/login");
                dispatcher.forward(req, res);
                return;
            } else {
                chain.doFilter(req, res);
                return;
            }
        } else {
            chain.doFilter(req, res);
            return;
        }
    }

    public void init(FilterConfig filterConfig) {
    }

    public void destroy() {
    }

}
