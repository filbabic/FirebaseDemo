package com.example.flip6.firebasedemo.interaction;

import android.support.annotation.NonNull;

import com.example.flip6.firebasedemo.common.constants.Constants;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

/**
 * Created by flip6 on 19.6.2016..
 */

public class FirebaseRemoteConfigInteractorImpl implements FirebaseRemoteConfigInteractor {
    private final FirebaseRemoteConfig remoteConfig;

    public FirebaseRemoteConfigInteractorImpl(FirebaseRemoteConfig remoteConfig) {
        this.remoteConfig = remoteConfig;
    }

    @Override
    public boolean isItemOnDiscount() {
        return remoteConfig.getBoolean(Constants.IS_ON_DISCOUNT);
    }

    @Override
    public long getItemDiscount() {
        return remoteConfig.getLong(Constants.DISCOUNT_AMOUNT);
    }

    @Override
    public void syncWithBackend() {
        remoteConfig.fetch(0).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) { // 0 for cache expiry
                if (task.isSuccessful()) {
                    remoteConfig.activateFetched();
                }
            }
        });
    }
}