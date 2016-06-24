package com.example.flip6.firebasedemo.remote.presenter;

import com.example.flip6.firebasedemo.network.backend.FirebaseHelper;
import com.example.flip6.firebasedemo.network.remote.RemoteConfigHelper;
import com.example.flip6.firebasedemo.remote.view.RemoteConfigView;

/**
 * Created by flip6 on 19.6.2016..
 */

public class RemoteConfigPresenterImpl implements RemoteConfigPresenter {
    private final RemoteConfigHelper remoteConfigHelper;
    private final RemoteConfigView remoteConfigView;

    public RemoteConfigPresenterImpl(RemoteConfigHelper remoteConfigHelper, RemoteConfigView remoteConfigView) {
        this.remoteConfigHelper = remoteConfigHelper;
        this.remoteConfigView = remoteConfigView;
    }

    @Override
    public void fetchRemoteConfigValues() {
        remoteConfigHelper.syncWithBackend();
        if (remoteConfigHelper.isItemOnDiscount()) {
            remoteConfigView.setItemIsOnDiscount(true);
            remoteConfigView.setItemDiscount("Item is on " + remoteConfigHelper.getItemDiscount() + "% discount.");
        } else {
            remoteConfigView.setItemDiscount("Item isn't on discount.");
        }
    }
}