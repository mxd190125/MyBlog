package com.mxd.controller.admin;

import com.mxd.service.UpdateBlogStatusService;
import com.mxd.service.impl.UpdateBlogStatusServiceImpl;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/updateBlogStatus")
public class UpdateBlogStatusController extends HttpServlet {
    private UpdateBlogStatusService updateBlogStatusService = new UpdateBlogStatusServiceImpl();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/json;charset=utf-8");
        HttpSession session = request.getSession();
        PrintWriter out = response.getWriter();
        JSONObject json = new JSONObject();

        String type = request.getParameter("type");
        int blogId = Integer.valueOf(request.getParameter("blogId").toString());
        Integer status = Integer.valueOf(request.getParameter("status").toString());
        int i = updateBlogStatusService.UpdateBlogStatus(type, blogId, status);
        json.put("status" , i);
        out.println(json);
    }

}
