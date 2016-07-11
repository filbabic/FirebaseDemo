package com.example.flip6.firebasedemo.common.model;

import com.example.flip6.firebasedemo.common.utils.StringUtils;

/**
 * Created by flip6 on 16.6.2016..
 */
public class MessageModel extends BaseModel {
    private String message;
    private String author;
    private String authorImageURL;

    public MessageModel(String message, String author, String authorImageURL) {
        this.message = message;
        this.author = author;
        this.authorImageURL = authorImageURL;
    }

    public MessageModel() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthorImageURL() {
        return authorImageURL;
    }

    public void setAuthorImageURL(String authorImageURL) {
        this.authorImageURL = authorImageURL;
    }

    @Override
    protected boolean validateModel() {
        return !StringUtils.stringEmptyOrNull(message, author, authorImageURL);
    }
}