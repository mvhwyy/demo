package com.project.my.model.graphql;

import lombok.Data;

import java.util.List;

/**
 * @author mawei
 * @version 1.0
 * @name User
 * @description TODO
 * @menu TODO
 * @date 2022/6/12 4:21 下午
 */

@Data
public class User {
    private int userId;
    private String userName;
    private String realName;
    private String email;
    private List<Post> posts;

    public User() {
    }

    public User(int userId, String userName, String realName, String email) {
        this.userId = userId;
        this.userName = userName;
        this.realName = realName;
        this.email = email;
    }
}
