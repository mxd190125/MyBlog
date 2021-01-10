package com.mxd.controller.admin;


import com.mxd.service.DeleteUserService;
import com.mxd.service.impl.DeleteUserServiceImpl;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/deleteUser")
public class DeleteUserController extends HttpServlet {
    private DeleteUserService deleteUserService = new DeleteUserServiceImpl();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/json;charset=utf-8");
        HttpSession session = request.getSession();
        PrintWriter out = response.getWriter();
        JSONObject json = new JSONObject();

        int userId = Integer.valueOf(request.getParameter("userId"));
        int i = deleteUserService.deleteUser(userId);
        json.put("status" , i);
        out.println(json);
    }
}
