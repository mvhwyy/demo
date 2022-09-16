package com.project.my.model.graphql;

import lombok.Data;

/**
 * @author mawei
 * @version 1.0
 * @name Post
 * @description TODO
 * @menu TODO
 * @date 2022/6/12 4:21 下午
 */
@Data
public class Post {
    private int postId;
    private String title;
    private String text;
    private String category;
    private User user;

    public Post() {

    }

    public Post(int postId, String title, String text, String category) {
        this.postId = postId;
        this.title = title;
        this.text = text;
        this.category = category;
    }
}
