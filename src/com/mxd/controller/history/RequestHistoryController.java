package com.mxd.controller.history;


import com.mxd.bean.Blog;
import com.mxd.service.RequestHistoryService;
import com.mxd.service.impl.RequestHistoryServiceImpl;
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

@WebServlet(urlPatterns = "/requestHistory")
public class RequestHistoryController extends HttpServlet {

    private RequestHistoryService requestHistoryService = new RequestHistoryServiceImpl();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/json;charset=utf-8");
        HttpSession session = request.getSession();
        PrintWriter out = response.getWriter();
        JSONObject json = new JSONObject();

        int userId = Integer.valueOf(request.getParameter("userId").toString());
        ArrayList<Blog> blogs = requestHistoryService.requetHistory(userId);
        if (blogs == null || blogs.size() == 0){
            json.put("status" , 0);
        }else {
            json.put("status" , 1);
        }
        json.put("blogs" , blogs);
        out.println(json);
    }
}
