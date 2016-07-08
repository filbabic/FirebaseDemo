package com.example.flip6.firebasedemo.presentation;

import com.example.flip6.firebasedemo.common.utils.StringUtils;
import com.example.flip6.firebasedemo.view.ChooseUsernameView;

/**
 * Created by flip6 on 8.7.2016..
 */

public class ChooseUsernamePresenterImpl implements ChooseUsernamePresenter {
    private ChooseUsernameView chooseUsernameView;

    @Override
    public void setView(ChooseUsernameView view) {
        this.chooseUsernameView = view;
    }

    @Override
    public void handleUserClickedChooseUsernameButton(String username) {
        if (!StringUtils.StringEmptyOrNull(username)) {
            chooseUsernameView.proceedWithUserRegistration(username);
        }
    }
}