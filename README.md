# MyBlog
前端：Ajax+Jquery+Bootsrap+JSP 后台：Servlet 数据库：MySQL，实现的简易博客网站

# 运行前说明
## 1、上传图片的环境配置：
### Windows端：
    (1) 在Tomcat的conf文件夹下的server.xml中的<Host></Host>标签中最后面添加一段 
        <Context docBase="D:\myblog\img" path="/img" reloadable="true"/>
        并且要在D盘中创建myblog\img“两级”文件夹
    (2) IDEA：在Tomcat配置的Deployment选项中点击“+”号，选中D:\myblog\img文件夹，然后在下面的Application context处对应修改为“/img”
    
### Linux端：在Tomcat的conf文件夹下的server.xml中的<Host></Host>标签中最后面添加一段 
         <Context docBase="/usr/local/src/tomcat8/webapps/img" path="/img" reloadable="true"/>
        并且要在Tomcat的webapps下创建一个img文件夹（docBase=""的值根据你tomcat安装位置）
## 2、BaseDao.java中修改为你的数据源
## 3、项目的数据库myblog.sql文件在项目web下的sql文件夹下，将myblog.sql运行在你的Navicat（或其它数据库客户端）中

## 4、UploadUtils.java中简单对照上面第一点配置的图片路径
