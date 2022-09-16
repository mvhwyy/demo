package com.project.my.model.graphql.response;

import org.mountcloud.graphql.GraphqlClient;
import org.mountcloud.graphql.request.query.DefaultGraphqlQuery;
import org.mountcloud.graphql.request.query.GraphqlQuery;
import org.mountcloud.graphql.response.GraphqlResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author mawei
 * @version 1.0
 * @name Call
 * @description TODO
 * @menu TODO
 * @date 2022/6/12 5:29 下午
 */
public class Call {
    public static void main(String[] args) {
        String serverUrl = "http://localhost:8080/graphql";
        GraphqlClient graphqlClient = GraphqlClient.buildGraphqlClient(serverUrl);
        String queryMethodName = "getPostById";
        GraphqlQuery query = new DefaultGraphqlQuery(queryMethodName);
        query.addParameter("id", 1);
//        //数组里面可以是具体的某个对象（比如User对象），也可是是Map，但是里面包含的key值，需要与接口方式里面能接收的参数对应,如下所示
//        List<Map<String, Object>> filterList = new ArrayList<>();
//        Map<String, Object> map1 = new HashMap<>();
//        map1.put("id", 1);//User.firstName = Jim
//        filterList.add(map1);
//        //此步骤要注意，如果入参非基本类型，建议使用addObjectParameter方式，
//        // 很奇怪，不能直接query.addObjectParameter(...),需要放在非第一个参数位置
//        // 疑问，要是没有其他参数，这个方法不就是不能使用了 ？？有时间了研究一下
//        query.addParameter("first", 3).addObjectParameter("filter", filterList);
        query.addResultAttributes("postId", "title");
        try {
            //执行query
            GraphqlResponse response = graphqlClient.doQuery(query);
            //获取数据，数据为map类型
            Map result = response.getData();
            Map m2 = (Map) result.get("data");
            List<Map> findAllAuthors = (List<Map>) m2.get(queryMethodName);
//            for (Map map : findAllAuthors) {
//                System.out.println(map.get("firstName").toString() + "----" + map.get("lastName").toString());
//            }

        } catch (Exception e) {
            System.out.println("exception:" + e);
        }
    }
}
