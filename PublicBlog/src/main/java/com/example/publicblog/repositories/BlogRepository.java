package com.example.publicblog.repositories;

import com.example.publicblog.entities.Blog;
import com.example.publicblog.entities.Comment;

import java.util.ArrayList;
import java.util.List;

public interface BlogRepository {

    Blog addBlog(Blog blog);

    List<Blog> allBlogs();

    Blog findBlog(Integer id);
}
