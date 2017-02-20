package com.cc.bean;

/**
 * Created by cc on 2017/2/14.
 */
public class BookList {
    private long id;
    private String bookName;
    private String publisher;
    private String author;
    private String Summary;

    public BookList(){
        this.id=-1;
    }
    public BookList(long id, String bookName, String publisher, String author, String summary) {
        this.id = id;
        this.bookName = bookName;
        this.publisher = publisher;
        this.author = author;
        Summary = summary;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getSummary() {
        return Summary;
    }

    public void setSummary(String summary) {
        Summary = summary;
    }
}
