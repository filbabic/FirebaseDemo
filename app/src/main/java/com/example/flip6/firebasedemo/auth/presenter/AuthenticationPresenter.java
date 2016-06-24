package com.example.flip6.firebasedemo.auth.presenter;

/**
 * Created by flip6 on 17.6.2016..
 */
public interface AuthenticationPresenter {
    void sendUserLoginRequest(String email, String password);

    void sendUserRegisterRequest(String email, String password);

    void changeUsernameForCurrentUser();

    void setOperationCode(int code);

    void logOutTheUser();
}