package com.mxd.MyUtils;


import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.*;

public class UploadUtils {

//    private static String fileDirPath = "D:\\myblog\\img";  // Windows端图片存储文件夹
    private static String fileDirPath = "/usr/local/src/tomcat8/webapps/img"; // Linux端图片存储文件夹
    private static String photoFile = "photo";
    private static String imageFile = "image";

    public static Map<String , String> uploadHeadPhoto(HttpServletRequest request){
        return uploadFile(request , photoFile);
    }

    public static Map<String , String> uploadImages(HttpServletRequest request){
        return uploadFile(request, imageFile);
    }

    private static Map<String , String> uploadFile(HttpServletRequest request , String propName){
        HashMap<String, String> map = new HashMap<>();
        String username = (String) request.getSession().getAttribute("username");

        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        try {
            List<FileItem> items = upload.parseRequest(request);
            Iterator<FileItem> iterator = items.iterator();
            while (iterator.hasNext()) {
                FileItem item = iterator.next();
                // 不是普通字段，是文件流
                String fieldName = item.getFieldName();
                if (fieldName.startsWith(propName) || fieldName.equals(propName)){
                    if (item != null){
                        String fileUrlTail = Calendar.getInstance().getTimeInMillis() + ".png";
                        String fileName = username + "-"+propName+"-" + fileUrlTail;
//                        File file = new File(fileDirPath + "\\" + fileName); // Windows
                        File file = new File(fileDirPath + "/" + fileName); // Linux
                        try {
                            item.write(file);
                            //返回图片的请求路径
                            map.put(fieldName , "img/" + fileName);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }else {
                    // 处理普通字段
                    String s = new String(item.getString().getBytes("iso-8859-1"), "utf-8");
                    map.put(fieldName , s);
                    System.out.println(fieldName + " " + s);
                }
            }
        } catch (FileUploadException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return map;
    }


}
