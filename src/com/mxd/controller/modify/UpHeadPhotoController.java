package com.mxd.controller.modify;

import com.mxd.MyUtils.UploadUtils;
import com.mxd.bean.User;
import com.mxd.service.UpHeadPhotoService;
import com.mxd.service.impl.UpHeadPhotoServiceImpl;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

@WebServlet(urlPatterns = "/upHeadPhoto")
public class UpHeadPhotoController extends HttpServlet {

    private UpHeadPhotoService upHeadPhotoService = new UpHeadPhotoServiceImpl();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/json;charset=utf-8");
        PrintWriter out = response.getWriter();
        JSONObject json = new JSONObject();

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        int userId = user.getId();
        // 上传头像
        Map<String, String> photoMap = UploadUtils.uploadHeadPhoto(request);
        // 上传头像成功！
        if (photoMap != null){
            // 更改session域信息
            String photoUrl = photoMap.get("photo");
            user.setPhotoUrl(photoUrl);
            session.setAttribute("photoUrl" , photoUrl);
            session.setAttribute("user" , user);
            int i = upHeadPhotoService.uploadHeadPhoto(userId, photoUrl);
            if (i>0){
                json.put("status" , "1");
            }else {
                json.put("status" , "0");
            }
        }else {
            json.put("status" , "0");

        }
        // 返回浏览器
        out.println(json);

    }
}
