package com.cc.utiltiy;

import com.cc.bean.Answer;
import com.cc.bean.BookList;
import com.google.gson.Gson;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.Reader;

/**
 * Created by cc on 2017/2/16.
 */
public class MybatisConn {

    private static SqlSessionFactory sqlSessionFactory;
    private static Reader reader;

    static {
        try {

            reader = Resources.getResourceAsReader("com/cc/config/mybatis-config.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static SqlSessionFactory getSession() {
        return sqlSessionFactory;
    }
    public static String process(Integer id) {

        SqlSession session = sqlSessionFactory.openSession();
        try {
            BookList user = (BookList) session.selectOne(
                    "com.cc.bean.bookMapper.GetBookListByID", 1);
            if(user!=null){
//                String userInfo = "名字："+user.getAuthor()+", 所属部门："+user.getSummary()+", 主页："+user.getPublisher();
                Gson gson = new Gson();
                String json= gson.toJson(user);
                System.out.println(json);
                return json;
            }else {
                return "Error!!!!!!!";
            }
        } finally {
            session.close();
        }
    }
    public static Answer addBook(BookList book) {

        SqlSession session = sqlSessionFactory.openSession();
        try {
            if(book!=null){
                session.insert(
                        "com.cc.bean.bookMapper.insertBook",book);
                Gson gson = new Gson();
                String json= gson.toJson(book);
                System.out.println("insert:---------"+json);
                Answer ans = new Answer(1,"name");
                session.commit();
                return ans;
            }else {
                Answer ans2 = new Answer(1,"error");
                return ans2;
            }
        } finally {
            session.close();
        }
    }
}
