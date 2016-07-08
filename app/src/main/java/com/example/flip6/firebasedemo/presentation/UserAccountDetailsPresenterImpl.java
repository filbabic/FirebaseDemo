package com.example.flip6.firebasedemo.presentation;

import com.example.flip6.firebasedemo.common.ResponseListener;
import com.example.flip6.firebasedemo.common.utils.StringUtils;
import com.example.flip6.firebasedemo.interaction.FirebaseAuthenticationInteractor;
import com.example.flip6.firebasedemo.view.UserAccountDetailsView;

/**
 * Created by flip6 on 8.7.2016..
 */

public class UserAccountDetailsPresenterImpl implements UserAccountDetailsPresenter {
    private String username;
    private String imageURL;

    private UserAccountDetailsView userAccountDetailsView;
    private final FirebaseAuthenticationInteractor firebaseAuthenticationInteractor;

    public UserAccountDetailsPresenterImpl(FirebaseAuthenticationInteractor firebaseAuthenticationInteractor) {
        this.firebaseAuthenticationInteractor = firebaseAuthenticationInteractor;
    }

    @Override
    public void handleRegisterButtonClick(String email, String password) {
        if (!StringUtils.StringEmptyOrNull(email, password)) {
            userAccountDetailsView.showProgressBar();
            firebaseAuthenticationInteractor.registerUser(email, password, bindUserRegisterListener());
        } else {
            userAccountDetailsView.showAllFieldsMustBeFilledMessage();
        }
    }

    @Override
    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    @Override
    public void logCurrentUserOut() {
        firebaseAuthenticationInteractor.logTheUserOut();
    }

    @Override
    public void setView(UserAccountDetailsView view) {
        this.userAccountDetailsView = view;
    }

    protected ResponseListener bindUserRegisterListener() {
        return new ResponseListener() {
            @Override
            public void onSuccessfulAuthentication() {
                userAccountDetailsView.hideProgressBar();
                userAccountDetailsView.showSuccessfulRegisterMessage();
                firebaseAuthenticationInteractor.changeUserProfileData(username, imageURL);
            }

            @Override
            public void onFailedAuthentication() {
                userAccountDetailsView.hideProgressBar();
                userAccountDetailsView.showInvalidRegisterMessage();
            }
        };
    }
}