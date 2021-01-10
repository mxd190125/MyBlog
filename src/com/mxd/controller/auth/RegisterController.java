package com.mxd.controller.auth;


import com.mxd.service.RegisterService;
import com.mxd.service.impl.RegisterServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = "/register")
public class RegisterController extends HttpServlet {

    private RegisterService registerService = new RegisterServiceImpl();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        HttpSession session = request.getSession();
        if (username.trim().equals("") || password.trim().equals("") || email.trim().equals("")){
            session.setAttribute("error" , "输入内容不能为空！");
            request.getRequestDispatcher("index.jsp").forward(request , response);
        }else {
            int i = registerService.registerUser(username, password, email);
            if (i>0){
                session.setAttribute("error" , "注册成功，请登录！");
                request.getRequestDispatcher("index.jsp").forward(request , response);
            }else {
                session.setAttribute("error" , "注册失败！");
                request.getRequestDispatcher("index.jsp").forward(request , response);
            }
        }

    }
}
