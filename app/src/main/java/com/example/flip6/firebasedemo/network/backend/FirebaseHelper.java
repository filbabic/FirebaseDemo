package com.example.flip6.firebasedemo.network.backend;

import com.example.flip6.firebasedemo.pojo.MessageModel;

/**
 * Created by flip6 on 16.6.2016..
 */
public interface FirebaseHelper {
    void requestFromValidLink(RequestListener<MessageModel> listener);

    void requestFromInvalidLink(RequestListener<MessageModel> listener);

    void logTheUserIn(String email, String password, ResponseListener listener);

    void attemptToCreateNewUser(String email, String password, ResponseListener listener);

    String getCurrentUserDisplayName();

    boolean checkIfUserIsOnline();

    void logTheTestUserOut();

    void changeUsernameForCurrentUser();

    void sendMessageToFirebase(String messageToSend, ResponseListener responseListener);
}