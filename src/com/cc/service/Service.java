package com.cc.service;


import com.cc.bean.BookList;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by cc on 2017/2/15.
 */
public class Service {

     private String hehe;

    public String test(){
        Gson gson = new Gson();
        List<BookList> bookLists = new ArrayList<BookList>();
        BookList b = new BookList(1,"BeautyAndBeast","Shakspare","kobe","a love story");
        BookList b2 = new BookList(2,"BeautyAndBeast","Shakspare","kobe","a love story");
        BookList b3 = new BookList(3,"BeautyAndBeast","Shakspare","kobe","a love story");
        bookLists.add(b);
        bookLists.add(b2);
        bookLists.add(b3);

        hehe = gson.toJson(bookLists);
        return hehe;
    }
}
