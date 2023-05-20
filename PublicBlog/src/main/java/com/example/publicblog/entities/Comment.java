package com.example.publicblog.entities;

import javax.validation.constraints.NotNull;

public class Comment {


    private Integer id;

    @NotNull(message = "Comment can't be empty!")
    private String content;

    @NotNull(message = "Id of blog must be present!")
    private Integer blogId;

    @NotNull(message = "Id of user must be present!")
    private Integer userId;

    public Comment(){}

    public Comment(Integer id, String content, Integer blogId, Integer userId) {
        this();
        this.id = id;
        this.content = content;
        this.blogId = blogId;
        this.userId = userId;
    }

    public Integer getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public void setComment(String comment) {
        this.content = content;
    }

    public Integer getBlogId() {
        return blogId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
