package com.example.flip6.firebasedemo.interaction;

import com.example.flip6.firebasedemo.common.ResponseListener;
import com.google.firebase.auth.FirebaseAuth;

/**
 * Created by flip6 on 6.7.2016..
 */

public class FirebaseAuthenticationInteractorImpl implements FirebaseAuthenticationInteractor {
    private final FirebaseAuth firebaseAuth;

    public FirebaseAuthenticationInteractorImpl(FirebaseAuth firebaseAuth) {
        this.firebaseAuth = firebaseAuth;
    }

    @Override
    public void logTheUserIn(String email, String password, final ResponseListener listener) {

    }

    @Override
    public void registerUser(String email, String password, final ResponseListener listener) {

    }

    @Override
    public void logTheUserOut() {
        firebaseAuth.signOut();
    }

    @Override
    public boolean isUserOnline() {
        return false;
    }

    @Override
    public String getLoggedInUserDisplayName() {
        return null;
    }

    @Override
    public void changeUserProfileData(String usernameToSet, String userImageURL) {
    }

    @Override
    public String getLoggedInUserImageURL() {
        return null;
    }
}