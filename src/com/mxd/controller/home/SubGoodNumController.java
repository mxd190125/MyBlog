package com.mxd.controller.home;


import com.mxd.service.SubGoodNumService;
import com.mxd.service.impl.SubGoodNumServiceImpl;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/subGoodNum")
public class SubGoodNumController extends HttpServlet {

    private SubGoodNumService subGoodNumService = new SubGoodNumServiceImpl();
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/json;charset=utf-8");
        PrintWriter out = response.getWriter();
        JSONObject json = new JSONObject();

        int blogId = Integer.valueOf(request.getParameter("blogId").toString());
        int i = subGoodNumService.SubGoodNum(blogId);
        json.put("status" , i);
        out.println(json);
    }

}
