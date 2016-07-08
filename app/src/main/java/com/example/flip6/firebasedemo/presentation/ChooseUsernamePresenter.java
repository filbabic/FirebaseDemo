package com.example.flip6.firebasedemo.presentation;

import com.example.flip6.firebasedemo.view.ChooseUsernameView;

/**
 * Created by flip6 on 8.7.2016..
 */

public interface ChooseUsernamePresenter extends Presenter<ChooseUsernameView> {
    void handleUserClickedChooseUsernameButton(String username);
}