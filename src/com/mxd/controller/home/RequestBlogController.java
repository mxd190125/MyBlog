package com.mxd.controller.home;


import com.mxd.bean.Blog;
import com.mxd.service.RequestBlogService;
import com.mxd.service.impl.RequestBlogServiceImpl;
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

@WebServlet(urlPatterns = "/requestBlog")
public class RequestBlogController extends HttpServlet {
    private RequestBlogService requestBlogService = new RequestBlogServiceImpl();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
//        response.setContentType("text/json;charset=utf-8");
        HttpSession session = request.getSession();
        PrintWriter out = response.getWriter();
        JSONObject json = new JSONObject();
        // 获取所有博客和其所属的评论
        ArrayList<Blog> blogs = requestBlogService.requestBlog();
        session.setAttribute("blogs" , blogs);
        request.getRequestDispatcher("static/page/home.jsp").forward(request , response);
    }
}
