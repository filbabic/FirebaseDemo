package com.example.flip6.firebasedemo.auth.view;

/**
 * Created by flip6 on 17.6.2016..
 */
public interface AuthenticationView {
    void onSuccessfulOperation(String successMessage);

    void onFailedOperation(String whichOperation);

    void showThereIsNoUserLoggedInToast();

    void setUsernameText(String currentUserDisplayName);
}