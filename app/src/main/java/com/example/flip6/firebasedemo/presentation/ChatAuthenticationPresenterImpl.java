package com.example.flip6.firebasedemo.presentation;

import com.example.flip6.firebasedemo.common.ResponseListener;
import com.example.flip6.firebasedemo.common.utils.StringUtils;
import com.example.flip6.firebasedemo.interaction.FirebaseAuthenticationInteractor;
import com.example.flip6.firebasedemo.view.ChatAuthView;

/**
 * Created by flip6 on 7.7.2016..
 */

public class ChatAuthenticationPresenterImpl implements ChatAuthenticationPresenter {
    private final FirebaseAuthenticationInteractor firebaseAuthenticationInteractor;

    private ChatAuthView chatAuthView;

    public ChatAuthenticationPresenterImpl(FirebaseAuthenticationInteractor firebaseAuthenticationInteractor) {
        this.firebaseAuthenticationInteractor = firebaseAuthenticationInteractor;
    }

    @Override
    public void setView(ChatAuthView view) {
        this.chatAuthView = view;
    }

    @Override
    public void logTheUserIn(String email, String password) {
        if (!StringUtils.stringEmptyOrNull(email, password)) {
            chatAuthView.showProgressBar();
            firebaseAuthenticationInteractor.logTheUserIn(email, password, bindLoginListener());
        } else {
            chatAuthView.showFillInAllFieldsMessage();
        }
    }

    protected ResponseListener bindLoginListener() {
        return new ResponseListener() {
            @Override
            public void onSuccessfulAuthentication() {
                chatAuthView.hideProgressBar();
                chatAuthView.showSuccessfulLoginMessage();
                chatAuthView.moveUserToChatLobby();
            }

            @Override
            public void onFailedAuthentication() {
                chatAuthView.hideProgressBar();
                chatAuthView.showInvalidLoginDataMessage();
            }
        };
    }

}