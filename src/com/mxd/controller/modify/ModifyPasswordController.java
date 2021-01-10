package com.mxd.controller.modify;

import com.mxd.bean.User;
import com.mxd.service.ModifyPasswordService;
import com.mxd.service.impl.ModifyPasswordServiceImpl;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/modifyPassword")
public class ModifyPasswordController extends HttpServlet {
    private ModifyPasswordService modifyPasswordService = new ModifyPasswordServiceImpl();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/json;charset=utf-8");

        PrintWriter out = response.getWriter();
        String newPassword = request.getParameter("password");
        JSONObject json = new JSONObject();
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        Integer userId = user.getId();
        // 更改数据库
        int i = modifyPasswordService.modifyPassword(userId, newPassword);
        json.put("status" , i);
        out.println(json);
    }
}
