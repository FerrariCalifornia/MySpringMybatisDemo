package com.cc.bean;

/**
 * Created by cc on 2017/2/16.
 */
public class Answer {
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Answer(int id, String answer) {
        this.id = id;
        this.answer = answer;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    private String answer;
}
