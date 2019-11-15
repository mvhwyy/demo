package tools;

/**
 * @ClassName Entrance
 * @Description 代码生成器入口
 * @Author mawei
 * @Date 2019/11/15 3:57 下午
 * @Version 1.0
 */
public class Entrance {

    public static void main(String[] args) {
        //生成文件所在项目路径
        String baseProjectPath = "/Users/mawei/Documents/project/demo";
        //基本包名
        String basePackage = "com.project.my";
        //作者
        String authorName = "mawei";
        //要生成的表名
        String[] tables = {"t_user_info"};
        //table前缀
        String prefix = "t_";
        //数据库配置四要素
        String driverName = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=UTF-8&allowMultiQueries=true&autoReconnect=true&zeroDateTimeBehavior=convertToNull";
        String username = "root";
        String password = "root";


        SqlGenerator.sql(driverName, url, username, password, baseProjectPath, authorName, prefix, tables, basePackage);
    }
}
