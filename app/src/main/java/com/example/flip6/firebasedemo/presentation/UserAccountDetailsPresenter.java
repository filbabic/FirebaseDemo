package com.example.flip6.firebasedemo.presentation;

import com.example.flip6.firebasedemo.view.UserAccountDetailsView;

/**
 * Created by flip6 on 8.7.2016..
 */
public interface UserAccountDetailsPresenter extends Presenter<UserAccountDetailsView> {
    void handleRegisterButtonClick(String email, String password);

    void setUsername(String username);

    void logCurrentUserOut();
}