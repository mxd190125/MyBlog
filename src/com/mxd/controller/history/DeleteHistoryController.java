package com.mxd.controller.history;

import com.mxd.service.DeleteHistoryService;
import com.mxd.service.impl.DeleteHistoryServiceImpl;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/deleteHistory")
public class DeleteHistoryController extends HttpServlet {

    private DeleteHistoryService deleteHistoryService = new DeleteHistoryServiceImpl();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/json;charset=utf-8");
        HttpSession session = request.getSession();
        PrintWriter out = response.getWriter();
        JSONObject json = new JSONObject();

        int blogId = Integer.valueOf(request.getParameter("blogId"));
        int i = deleteHistoryService.deleteHistory(blogId);
        json.put("status" , i);
        out.println(json);
    }

}
