package com.mxd.bean;


import java.util.ArrayList;

public class Blog {

    private Integer id;
    private Integer bloger;
    private String blogerName;
    private String blogerPhotoUrl;
    private String title;
    private String content;
    private String images;
    private Integer goodNum;
    private String subTime;
    private Integer isTop;
    private Integer isGood;

    private ArrayList<Discuss> discusses;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBloger() {
        return bloger;
    }

    public void setBloger(Integer bloger) {
        this.bloger = bloger;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public Integer getGoodNum() {
        return goodNum;
    }

    public void setGoodNum(Integer goodNum) {
        this.goodNum = goodNum;
    }

    public String getSubTime() {
        return subTime;
    }

    public void setSubTime(String subTime) {
        this.subTime = subTime;
    }

    public String getBlogerName() {
        return blogerName;
    }

    public void setBlogerName(String blogerName) {
        this.blogerName = blogerName;
    }

    public ArrayList<Discuss> getDiscusses() {
        return discusses;
    }

    public void setDiscusses(ArrayList<Discuss> discusses) {
        this.discusses = discusses;
    }

    public String getBlogerPhotoUrl() {
        return blogerPhotoUrl;
    }

    public void setBlogerPhotoUrl(String blogerPhotoUrl) {
        this.blogerPhotoUrl = blogerPhotoUrl;
    }

    public Integer getIsTop() {
        return isTop;
    }

    public void setIsTop(Integer isTop) {
        this.isTop = isTop;
    }

    public Integer getIsGood() {
        return isGood;
    }

    public void setIsGood(Integer isGood) {
        this.isGood = isGood;
    }
}
