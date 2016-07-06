package com.example.flip6.firebasedemo.common.model;

/**
 * Created by flip6 on 16.6.2016..
 */
public class UserModel {
    private final String userDisplayName;

    public UserModel(String userDisplayName) {
        this.userDisplayName = userDisplayName;
    }

    public String getUserDisplayName() {
        return userDisplayName;
    }
}