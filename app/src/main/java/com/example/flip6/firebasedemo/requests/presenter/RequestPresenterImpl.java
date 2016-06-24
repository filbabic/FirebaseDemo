package com.example.flip6.firebasedemo.requests.presenter;

import com.example.flip6.firebasedemo.network.backend.RequestListener;
import com.example.flip6.firebasedemo.network.backend.FirebaseHelper;
import com.example.flip6.firebasedemo.pojo.MessageModel;
import com.example.flip6.firebasedemo.requests.view.RequestView;

/**
 * Created by flip6 on 16.6.2016..
 */
public class RequestPresenterImpl implements RequestPresenter, RequestListener<MessageModel> {
    private final FirebaseHelper firebaseHelper;
    private final RequestView requestView;

    public RequestPresenterImpl(FirebaseHelper firebaseHelper, RequestView requestView) {
        this.firebaseHelper = firebaseHelper;
        this.requestView = requestView;
    }

    @Override
    public void requestFromValidLink() {
        firebaseHelper.requestFromValidLink(this);
    }

    @Override
    public void requestFromInvalidLink() {
        firebaseHelper.requestFromInvalidLink(this);
    }

    @Override
    public void onSuccessfulRequest(MessageModel callback) {
        if (callback != null) {
            requestView.setReceivedMessage(callback.getMessage());
            requestView.setMessageAuthor(callback.getAuthor());
        } else {
            requestView.showOnWrongReferenceErrorMessage();
        }
    }

    @Override
    public void onFailedRequest() {
        requestView.showOnFailedToRequest();
    }
}