package com.example.publicblog.entities;

import javax.validation.constraints.NotNull;

public class Blog {

    private Integer id;
    @NotNull(message = "Title of the blog is required!")
    private String title;
    @NotNull(message = "Content of the blog is required!")
    private String content;

    private String date;

    private Integer userId;

    public Blog(){
    }

    public Blog(Integer userId, String title, String content) {
        this();
        this.userId = userId;
        this.title = title;
        this.content = content;
        this.date = "";
    }

    public Blog(Integer id, String title, String content, String date, Integer userId){
        this(userId, title, content);
        this.id = id;
        this.date = date;
    }

    public void setAuthor(String author) {
        this.userId = userId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getUserId() {
        return userId;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public Integer getId() {
        return id;
    }

    public String getDate() {
        return date;
    }

}
