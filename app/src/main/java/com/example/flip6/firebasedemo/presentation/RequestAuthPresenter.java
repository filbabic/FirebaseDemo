package com.example.flip6.firebasedemo.presentation;

import com.example.flip6.firebasedemo.view.RequestAuthView;

/**
 * Created by cobe on 13/07/16.
 */
public interface RequestAuthPresenter extends Presenter<RequestAuthView>{
    void logTheUserIn(String email, String password);
}