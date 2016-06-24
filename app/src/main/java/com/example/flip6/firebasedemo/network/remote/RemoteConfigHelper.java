package com.example.flip6.firebasedemo.network.remote;

/**
 * Created by flip6 on 19.6.2016..
 */
public interface RemoteConfigHelper {
    boolean isItemOnDiscount();

    long getItemDiscount();

    void syncWithBackend();
}