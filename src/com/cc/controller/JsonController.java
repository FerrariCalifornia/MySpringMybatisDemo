package com.cc.controller;

import com.cc.bean.BookList;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by cc on 2017/2/15.
 */
@RestController
public class JsonController {
    private static final String template = "BookName: %s!";
    private static final String template2 = "Publisher: %s!";
    private static final String template3 = "Author: %s!";
    private static final String template4 = "Summary: %s!";
    private final AtomicLong counter = new AtomicLong();

    @CrossOrigin(origins = "http://localhost:8080")
    @RequestMapping("/json")
    @ResponseBody
    public BookList greeting(@RequestParam(required = false, defaultValue = "World") String bookname,
                             @RequestParam(required = false, defaultValue = "??") String publisher,
                             @RequestParam(required = false, defaultValue = "??") String author,
                             @RequestParam(required = false, defaultValue = "??") String summary
    ) {
        System.out.println("==== in booklist ====");
        return new BookList(counter.incrementAndGet(), String.format(template, bookname),
                String.format(template2,publisher),String.format(template3,author),String.format(template4,summary));
    }
}
