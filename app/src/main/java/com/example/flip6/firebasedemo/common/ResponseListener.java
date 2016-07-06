package com.example.flip6.firebasedemo.common;

/**
 * Created by flip6 on 16.6.2016..
 */
public interface ResponseListener {
    void onSuccessfulAuthentication();

    void onFailedAuthentication(String attemptedOperation);
}