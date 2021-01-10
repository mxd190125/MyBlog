package com.mxd.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter(filterName = "loginFilter",
           urlPatterns = {"/*"},
           initParams = {@WebInitParam(name = "permitUrls" , value = "/login,/register,/logOut,/index.jsp,/validCode,.css,.js.png.html")})
public class LoginFilter implements Filter {
    String[] permitUrls = null;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        permitUrls = filterConfig.getInitParameter("permitUrls").split(",");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        System.out.println("===========    LoginFilter|requestURI："+request.getRequestURI());
        boolean flag = false;
        for (String url : permitUrls) {
            if (request.getRequestURI().endsWith(url)) {
                flag = true;
            }
        }

        if (flag || request.getSession().getAttribute("user") !=null){
            System.out.println("允许访问");
            filterChain.doFilter(servletRequest, servletResponse);
        }else {
            System.out.println("不允许访问");
            request.getSession().setAttribute("error" , "未登录！");
            request.getRequestDispatcher("/index.jsp").forward(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
