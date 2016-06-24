package com.example.flip6.firebasedemo.network.remote;

import android.support.annotation.NonNull;
import android.util.Log;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

/**
 * Created by flip6 on 19.6.2016..
 */

public class RemoteConfigHelperImpl implements RemoteConfigHelper {
    private final FirebaseRemoteConfig remoteConfig;

    public RemoteConfigHelperImpl(FirebaseRemoteConfig remoteConfig) {
        this.remoteConfig = remoteConfig;
    }

    @Override
    public boolean isItemOnDiscount() {
        return remoteConfig.getBoolean("is_on_discount");
    }

    @Override
    public long getItemDiscount() {
        return remoteConfig.getLong("discount_amount");
    }

    @Override
    public void syncWithBackend() {
        remoteConfig.fetch(0).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()) {
                    remoteConfig.activateFetched();
                } else {
                    Log.d("fetching", "didnt fetch");
                }
            }
        });
    }
}