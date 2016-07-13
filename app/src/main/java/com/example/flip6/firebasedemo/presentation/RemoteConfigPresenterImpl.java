package com.example.flip6.firebasedemo.presentation;

import com.example.flip6.firebasedemo.interaction.FirebaseRemoteConfigInteractor;
import com.example.flip6.firebasedemo.view.RemoteConfigView;

/**
 * Created by flip6 on 19.6.2016..
 */

public class RemoteConfigPresenterImpl implements RemoteConfigPresenter {
    private final FirebaseRemoteConfigInteractor firebaseRemoteConfigInteractor;

    private RemoteConfigView remoteConfigView;

    public RemoteConfigPresenterImpl(FirebaseRemoteConfigInteractor firebaseRemoteConfigInteractor) {
        this.firebaseRemoteConfigInteractor = firebaseRemoteConfigInteractor;
    }

    @Override
    public void setView(RemoteConfigView view) {
        this.remoteConfigView = view;
    }

    @Override
    public void fetchRemoteConfigValues() {
        if (firebaseRemoteConfigInteractor.isItemOnDiscount()) {
            remoteConfigView.setItemIsOnDiscount(true);
            remoteConfigView.setItemDiscount(firebaseRemoteConfigInteractor.getItemDiscount());
        } else {
            remoteConfigView.setItemIsNotOnDiscount();
        }
    }

    @Override
    public void syncDataWithBackend() {
        firebaseRemoteConfigInteractor.syncWithBackend();
    }
}