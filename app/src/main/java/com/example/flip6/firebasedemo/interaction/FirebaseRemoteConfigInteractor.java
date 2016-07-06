package com.example.flip6.firebasedemo.interaction;

/**
 * Created by flip6 on 19.6.2016..
 */
public interface FirebaseRemoteConfigInteractor {
    boolean isItemOnDiscount();

    long getItemDiscount();

    void syncWithBackend();
}