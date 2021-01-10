package com.mxd.controller.history;

import com.mxd.bean.Blog;
import com.mxd.service.CheckHistoryService;
import com.mxd.service.impl.CheckHistoryServiceImpl;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/checkHistory")
public class CheckHistoryController extends HttpServlet {

    private CheckHistoryService checkHistoryService = new CheckHistoryServiceImpl();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/json;charset=utf-8");
        HttpSession session = request.getSession();
        PrintWriter out = response.getWriter();
        JSONObject json = new JSONObject();

        int blogId = Integer.valueOf(request.getParameter("blogId"));
        Blog blog = checkHistoryService.checkHistory(blogId);

        json.put("status" , 1);
        json.put("blog" , blog);
        out.println(json);
    }

}
