package com.mxd.controller.auth;

import com.mxd.bean.User;
import com.mxd.service.LoginService;
import com.mxd.service.impl.LoginServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = "/login")
public class LoginController extends HttpServlet {

    private LoginService loginService = new LoginServiceImpl();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String code = request.getParameter("code");
        HttpSession session = request.getSession();
        String trueCode = (String) session.getAttribute("code");

        if (code.trim().equals("") || !code.equals(trueCode)){
            // 验证码错误！
            session.setAttribute("error" , "验证码错误！");
            request.getRequestDispatcher("index.jsp").forward(request , response);
        }else {
            User user = loginService.getUser(username, password);
            if (user!=null){
                String role = user.getRole();
                session.setAttribute("username" , username);
                session.setAttribute("user" , user);
                session.setAttribute("role" , role);
                session.setAttribute("photoUrl" , user.getPhotoUrl());
//                request.getSession().setAttribute("path" , request.getContextPath() + "/");
                request.getSession().setAttribute("path" , "http://121.196.145.152:8080/MyBlog/");
                if (role.equals("user")) {
                    request.getRequestDispatcher("/requestBlog").forward(request , response);
                }else if (role.equals("admin")){
                    request.getRequestDispatcher("/static/page/admin/manageUser.jsp").forward(request , response);
                }
            }else {
                session.setAttribute("error" , "用户名或密码错误！");
                request.getRequestDispatcher("index.jsp").forward(request , response);
            }
        }

    }
}
