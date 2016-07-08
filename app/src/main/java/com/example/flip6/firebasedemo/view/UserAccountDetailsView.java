package com.example.flip6.firebasedemo.view;

/**
 * Created by flip6 on 8.7.2016..
 */
public interface UserAccountDetailsView {
    void showProgressBar();

    void hideProgressBar();

    void showInvalidRegisterMessage();

    void showSuccessfulRegisterMessage();

    void showAllFieldsMustBeFilledMessage();
}