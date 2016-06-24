package com.example.flip6.firebasedemo.pojo;

/**
 * Created by flip6 on 16.6.2016..
 */
public class UserModel {
    private final String userDisplayName;
    private final String userImageUrl;

    public UserModel(String userDisplayName, String userImageUrl) {
        this.userDisplayName = userDisplayName;
        this.userImageUrl = userImageUrl;
    }

    public String getUserDisplayName() {
        return userDisplayName;
    }

    public String getUserImageUrl() {
        return userImageUrl;
    }
}
