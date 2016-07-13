package com.example.flip6.firebasedemo.presentation;

import com.example.flip6.firebasedemo.common.ResponseListener;
import com.example.flip6.firebasedemo.common.utils.StringUtils;
import com.example.flip6.firebasedemo.interaction.FirebaseAuthenticationInteractor;
import com.example.flip6.firebasedemo.view.RequestAuthView;

/**
 * Created by cobe on 13/07/16.
 */

public class RequestAuthPresenterImpl implements RequestAuthPresenter {
    private final FirebaseAuthenticationInteractor authenticationInteractor;

    private RequestAuthView requestAuthView;

    public RequestAuthPresenterImpl(FirebaseAuthenticationInteractor authenticationInteractor) {
        this.authenticationInteractor = authenticationInteractor;
    }

    @Override
    public void setView(RequestAuthView view) {
        this.requestAuthView = view;
    }

    @Override
    public void logTheUserIn(String email, String password) {
        if (!StringUtils.stringEmptyOrNull(email, password)) {
            authenticationInteractor.logTheUserIn(email, password, bindLoginListener());
        } else {
            requestAuthView.showFieldsAreEmptyMessage();
        }
    }


    protected ResponseListener bindLoginListener() {
        return new ResponseListener() {
            @Override
            public void onSuccessfulAuthentication() {
                requestAuthView.moveUserToRequestFragment();
            }

            @Override
            public void onFailedAuthentication() {
                requestAuthView.showInvalidDataMessage();
            }
        };
    }
}