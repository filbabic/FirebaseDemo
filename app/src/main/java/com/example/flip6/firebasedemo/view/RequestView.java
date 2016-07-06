package com.example.flip6.firebasedemo.view;

/**
 * Created by flip6 on 16.6.2016..
 */
public interface RequestView {
    void setReceivedMessage(String receivedMessage);

    void setMessageAuthor(String messageAuthor);

    void showOnWrongReferenceErrorMessage();

    void showOnFailedToRequest();
}