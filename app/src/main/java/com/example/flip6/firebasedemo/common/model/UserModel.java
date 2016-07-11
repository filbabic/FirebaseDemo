package com.example.flip6.firebasedemo.common.model;

import com.example.flip6.firebasedemo.common.utils.StringUtils;

/**
 * Created by flip6 on 16.6.2016..
 */
public class UserModel extends BaseModel {
    private String userDisplayName;

    public UserModel() {
    }

    public UserModel(String userDisplayName) {
        this.userDisplayName = userDisplayName;
    }

    public String getUserDisplayName() {
        return userDisplayName;
    }

    public void setUserDisplayName(String userDisplayName) {
        this.userDisplayName = userDisplayName;
    }

    @Override
    protected boolean validateModel() {
        return !StringUtils.stringEmptyOrNull(userDisplayName);
    }
}