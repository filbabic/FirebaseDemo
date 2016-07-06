package com.example.flip6.firebasedemo.presentation;

import com.example.flip6.firebasedemo.interaction.FirebaseAuthenticationInteractor;

/**
 * Created by Filip on 04/07/2016.
 */

public class DatabaseActivityPresenterImpl implements DatabaseActivityPresenter {
    private final FirebaseAuthenticationInteractor authenticationInteractor;

    public DatabaseActivityPresenterImpl(FirebaseAuthenticationInteractor authenticationInteractor) {
        this.authenticationInteractor = authenticationInteractor;
    }

    @Override
    public void logTheUserOut() {
        authenticationInteractor.logTheUserOut();
    }
}