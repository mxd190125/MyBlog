package com.mxd.controller.home;

import com.mxd.service.SubDiscussService;
import com.mxd.service.impl.SubDiscussServiceImpl;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/subDiscuss")
public class SubDiscussController extends HttpServlet {

    private SubDiscussService subDiscussService = new SubDiscussServiceImpl();
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/json;charset=utf-8");
        PrintWriter out = response.getWriter();
        JSONObject json = new JSONObject();

        int blogId = Integer.valueOf(request.getParameter("blogId").toString());
        int discusserId = Integer.valueOf(request.getParameter("discusser").toString());
        String content = request.getParameter("content");

        int i = subDiscussService.subDiscuss(content, blogId, discusserId);
        json.put("status" , i);
        out.println(json);
    }
}
