package com.example.flip6.firebasedemo.database.view;

/**
 * Created by flip6 on 19.6.2016..
 */
public interface DatabaseView {
    void showOnSuccessfullySentAMessageToFirebaseToast();

    void showOnFailedToSendAMessageToFirebase(String errorMessage);

    void showSuccessfullyLoggedInToast();
}