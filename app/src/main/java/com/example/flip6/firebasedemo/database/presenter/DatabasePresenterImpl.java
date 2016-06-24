package com.example.flip6.firebasedemo.database.presenter;

import com.example.flip6.firebasedemo.constants.Constants;
import com.example.flip6.firebasedemo.database.view.DatabaseView;
import com.example.flip6.firebasedemo.network.backend.ResponseListener;
import com.example.flip6.firebasedemo.network.backend.FirebaseHelper;

/**
 * Created by flip6 on 19.6.2016..
 */
public class DatabasePresenterImpl implements DatabasePresenter {
    private final DatabaseView databaseView;
    private final FirebaseHelper firebaseHelper;

    public DatabasePresenterImpl(DatabaseView databaseView, FirebaseHelper firebaseHelper) {
        this.databaseView = databaseView;
        this.firebaseHelper = firebaseHelper;
    }

    @Override
    public void sendMessageToFirebase(String messageToSend) {
        firebaseHelper.sendMessageToFirebase(messageToSend, new ResponseListener() {
            @Override
            public void onSuccessfulAuthentication() {
                databaseView.showOnSuccessfullySentAMessageToFirebaseToast();
            }

            @Override
            public void onFailedAuthentication(String attemptedOperation) {
                databaseView.showOnFailedToSendAMessageToFirebase(attemptedOperation);
            }
        });
    }

    @Override
    public void logTheTestUserIn() {
        firebaseHelper.logTheUserIn(Constants.TEST_USER_EMAIL, Constants.TEST_USER_PASSWORD, new ResponseListener() {
            @Override
            public void onSuccessfulAuthentication() {
                databaseView.showSuccessfullyLoggedInToast();
            }

            @Override
            public void onFailedAuthentication(String attemptedOperation) {
                //ok nothing
            }
        });
    }

    @Override
    public void logTheUserOut() {
        firebaseHelper.logTheTestUserOut();
    }
}