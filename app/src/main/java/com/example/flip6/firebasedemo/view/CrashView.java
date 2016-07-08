package com.example.flip6.firebasedemo.view;

/**
 * Created by flip6 on 7.7.2016..
 */
public interface CrashView {
    void causeNullpointerCrash();

    void causeIndexOutOfBoundsCrash();

    void causeClassCastCrash();
}