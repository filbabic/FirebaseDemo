package com.example.flip6.firebasedemo.interaction;

import com.example.flip6.firebasedemo.common.ResponseListener;

/**
 * Created by flip6 on 6.7.2016..
 */

public interface FirebaseAuthenticationInteractor {
    void logTheUserIn(String email, String password, ResponseListener listener);

    void registerUser(String email, String password, ResponseListener listener);

    void logTheUserOut();

    boolean isUserOnline();

    String getLoggedInUserDisplayName();

    void changeUserProfileData(String usernameToSet, String userImageURL);

    String getLoggedInUserImageURL();
}