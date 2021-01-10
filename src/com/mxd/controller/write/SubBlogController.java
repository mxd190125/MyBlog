package com.mxd.controller.write;

import com.mxd.MyUtils.UploadUtils;
import com.mxd.bean.Blog;
import com.mxd.bean.User;
import com.mxd.service.SubBlogService;
import com.mxd.service.impl.SubBlogServiceImpl;
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

@WebServlet(urlPatterns = "/subBlog")
public class SubBlogController extends HttpServlet {

    private SubBlogService subBlogService = new SubBlogServiceImpl();
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/json;charset=utf-8");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        JSONObject json = new JSONObject();
        User user = (User) session.getAttribute("user");
        Integer userId = user.getId();

        // 先上传图片
        String imagesUrl = "";
        Map<String, String> map = UploadUtils.uploadImages(request);
        String title = "";
        String content = "";
        if (map != null){
            title = map.get("title");
            content = map.get("content");
            for (String url : map.values()) {
                if (url.startsWith("img")){
                    imagesUrl += (url + "#");
                }
            }
            //去掉最后一个 ‘#’
           imagesUrl = (imagesUrl.length()!=0 ? imagesUrl.substring(0 , imagesUrl.length()-1) : imagesUrl);
        }

        Blog blog = new Blog();
        blog.setBloger(userId);
        blog.setTitle(title);
        blog.setContent(content);
        blog.setImages(imagesUrl);
        blog.setGoodNum(0);
        // 写入博客
        int i = subBlogService.insertBlog(blog);
        // 返回响应
        json.put("status" , i);
        response.getWriter().println(json);
    }
}
