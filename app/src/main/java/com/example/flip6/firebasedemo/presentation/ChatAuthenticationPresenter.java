package com.example.flip6.firebasedemo.presentation;

import com.example.flip6.firebasedemo.view.ChatAuthView;

/**
 * Created by flip6 on 7.7.2016..
 */

public interface ChatAuthenticationPresenter extends Presenter<ChatAuthView> {
    void logTheUserIn(String email, String password);
}