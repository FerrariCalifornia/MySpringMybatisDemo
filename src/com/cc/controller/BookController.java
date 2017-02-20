package com.cc.controller;

import com.cc.bean.Answer;
import com.cc.bean.BookList;
import com.cc.bean.Greeting;
import com.cc.service.Service;
import com.google.gson.Gson;
import com.sun.xml.internal.ws.encoding.ContentType;
import org.apache.ibatis.session.SqlSession;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.cc.utiltiy.MybatisConn;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * Created by cc on 2017/2/15.
 */
@Controller
public class BookController {

    @RequestMapping(value = "/book",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public String test(){

        MybatisConn mybatisConn = new MybatisConn();
        String json = mybatisConn.process(1);
        return "this is BookController!!!!!!"+json;
    }
    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "/book2",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody()
    public String test2(){
        Service s = new Service();
        String hehe=s.test();
        return hehe;
    }
    @RequestMapping(value = "/book3",method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody()
    public String test3(@ModelAttribute("Booklist") BookList bookList){
        Gson gson = new Gson();
        String json = gson.toJson(bookList);

        return json;
    }
    @RequestMapping(value = "/book4",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody()
    public void test4(HttpServletRequest request, HttpServletResponse response)throws Exception{
        response.setContentType("application/json;charset=utf-8");
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "x-requested-with");
        PrintWriter pw = response.getWriter();
        MybatisConn mybatisConn = new MybatisConn();
        String json = mybatisConn.process(1);
        pw.print(json.toString());
        pw.close();
    }


    @RequestMapping(value = "/book5",method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody()
    public void test5(@ModelAttribute("BookList") BookList book, HttpServletRequest request, HttpServletResponse response)throws Exception{
        response.setContentType("application/json;charset=utf-8");
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "x-requested-with");
        MybatisConn mybatisConn = new MybatisConn();
        Answer answer=mybatisConn.addBook(book);

        PrintWriter pw = response.getWriter();
        Gson gson = new Gson();
        String json = gson.toJson(answer);
        pw.print(json.toString());
        pw.close();
    }

}
