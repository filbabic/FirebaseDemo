package com.example.flip6.firebasedemo.database.presenter;

import com.example.flip6.firebasedemo.network.backend.FirebaseHelper;

/**
 * Created by Filip on 04/07/2016.
 */

public class DatabaseActivityPresenterImpl implements DatabaseActivityPresenter {
    private final FirebaseHelper firebaseHelper;

    public DatabaseActivityPresenterImpl(FirebaseHelper firebaseHelper) {
        this.firebaseHelper = firebaseHelper;
    }

    @Override
    public void logTheUserOut() {
        firebaseHelper.logTheUserOut();
    }
}
