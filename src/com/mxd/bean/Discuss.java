package com.mxd.bean;


public class Discuss {
    private Integer id;
    private String content;
    private String subTime;
    private Integer blogId;
    private Integer discusser;
    private String discusserName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDiscusser() {
        return discusser;
    }

    public void setDiscusser(Integer discusser) {
        this.discusser = discusser;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSubTime() {
        return subTime;
    }

    public void setSubTime(String subTime) {
        this.subTime = subTime;
    }

    public Integer getBlogId() {
        return blogId;
    }

    public void setBlogId(Integer blogId) {
        this.blogId = blogId;
    }

    public String getDiscusserName() {
        return discusserName;
    }

    public void setDiscusserName(String discusserName) {
        this.discusserName = discusserName;
    }
}
