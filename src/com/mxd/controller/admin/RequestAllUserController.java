package com.mxd.controller.admin;


import com.mxd.bean.User;
import com.mxd.service.RequestAllUserService;
import com.mxd.service.impl.RequestAllUserServiceImpl;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(urlPatterns = "/requestAllUser")
public class RequestAllUserController extends HttpServlet {

    private RequestAllUserService requestAllUserService = new RequestAllUserServiceImpl();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/json;charset=utf-8");
        HttpSession session = request.getSession();
        PrintWriter out = response.getWriter();
        JSONObject json = new JSONObject();

        ArrayList<User> users = requestAllUserService.requestAllUser();
        json.put("status" , 1);
        json.put("users" , users);
        out.println(json);
    }

}
