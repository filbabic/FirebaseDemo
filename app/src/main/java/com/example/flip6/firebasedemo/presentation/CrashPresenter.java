package com.example.flip6.firebasedemo.presentation;

import com.example.flip6.firebasedemo.view.CrashView;

/**
 * Created by flip6 on 7.7.2016..
 */
public interface CrashPresenter extends Presenter<CrashView> {
    void handleUserClickedButton(int buttonID);
}