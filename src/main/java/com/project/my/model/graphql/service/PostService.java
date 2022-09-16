package com.project.my.model.graphql.service;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.project.my.model.graphql.Post;
import com.project.my.model.graphql.User;
import org.springframework.stereotype.Service;

/**
 * @author mawei
 * @version 1.0
 * @name PostService
 * @description TODO
 * @menu TODO
 * @date 2022/6/12 4:26 下午
 */
@Service
public class PostService implements GraphQLQueryResolver {
    /**
     * 为了测试，只查询id为1的结果
     */
    public Post getPostById(int id) {
        if (id == 1) {
            User user = new User(1, "javadaily", "JAVA日知录", "zhangsan@qq.com");
            Post post = new Post(1, "Hello,Graphql", "Graphql初体验", "日记");
            post.setUser(user);
            return post;
        } else {
            return null;
        }
    }
}
