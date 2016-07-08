package com.example.flip6.firebasedemo.view;

/**
 * Created by flip6 on 7.7.2016..
 */
public interface ChatAuthView {
    void showInvalidLoginDataMessage();

    void showSuccessfulLoginMessage();

    void moveUserToChatLobby();

    void showProgressBar();

    void hideProgressBar();

    void showFillInAllFieldsMessage();
}