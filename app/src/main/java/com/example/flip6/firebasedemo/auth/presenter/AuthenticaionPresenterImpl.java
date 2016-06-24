package com.example.flip6.firebasedemo.auth.presenter;

import com.example.flip6.firebasedemo.auth.view.AuthenticationView;
import com.example.flip6.firebasedemo.constants.Constants;
import com.example.flip6.firebasedemo.network.backend.ResponseListener;
import com.example.flip6.firebasedemo.network.backend.FirebaseHelper;

/**
 * Created by flip6 on 17.6.2016..
 */
public class AuthenticaionPresenterImpl implements AuthenticationPresenter, ResponseListener {
    private final AuthenticationView authenticationView;
    private final FirebaseHelper firebaseHelper;
    private int operationCode;

    public AuthenticaionPresenterImpl(AuthenticationView authenticationView, FirebaseHelper firebaseHelper) {
        this.authenticationView = authenticationView;
        this.firebaseHelper = firebaseHelper;
    }

    @Override
    public void sendUserLoginRequest(String email, String password) {
        firebaseHelper.logTheUserIn(email, password, this);
    }

    @Override
    public void sendUserRegisterRequest(String email, String password) {
        firebaseHelper.attemptToCreateNewUser(email, password, this);
    }

    @Override
    public void changeUsernameForCurrentUser() {
        if (firebaseHelper.checkIfUserIsOnline()) {
            firebaseHelper.changeUsernameForCurrentUser();
            authenticationView.setUsernameText(firebaseHelper.getCurrentUserDisplayName());
        } else {
            authenticationView.showThereIsNoUserLoggedInToast();
        }
    }

    @Override
    public void setOperationCode(int code) {
        this.operationCode = code;
    }

    @Override
    public void logOutTheUser() {
        firebaseHelper.logTheTestUserOut();
    }

    @Override
    public void onSuccessfulAuthentication() {
        if (operationCode == 1) {
            authenticationView.onSuccessfulOperation(Constants.LOGGED_IN_MESSAGE);
        } else if (operationCode == 2) {
            authenticationView.onSuccessfulOperation(Constants.REGISTERED_MESSAGE);
        }
    }

    @Override
    public void onFailedAuthentication(String attemptedOperation) {
        authenticationView.onFailedOperation(attemptedOperation);
    }
}