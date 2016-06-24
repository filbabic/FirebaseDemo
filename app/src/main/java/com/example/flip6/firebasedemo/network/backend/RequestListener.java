package com.example.flip6.firebasedemo.network.backend;

/**
 * Created by flip6 on 16.6.2016..
 */
public interface RequestListener<T> {
    void onSuccessfulRequest(T callback);

    void onFailedRequest();
}