package com.example.flip6.firebasedemo.database.presenter;

/**
 * Created by flip6 on 19.6.2016..
 */
public interface DatabasePresenter {
    void sendMessageToFirebase(String messageToSend);

    void logTheTestUserIn();

    void logTheUserOut();
}