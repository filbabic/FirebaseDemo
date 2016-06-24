package com.example.flip6.firebasedemo.pojo;

/**
 * Created by flip6 on 16.6.2016..
 */
public class MessageModel {
    private String message;
    private String author;

    public MessageModel(String message, String author) {
        this.message = message;
        this.author = author;
    }

    public MessageModel() {
    }

    public String getMessage() {
        return message;
    }

    public String getAuthor() {
        return author;
    }
}