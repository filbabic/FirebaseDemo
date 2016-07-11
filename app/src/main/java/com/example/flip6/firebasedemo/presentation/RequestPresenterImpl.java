package com.example.flip6.firebasedemo.presentation;

import com.example.flip6.firebasedemo.common.RequestListener;
import com.example.flip6.firebasedemo.common.model.MessageModel;
import com.example.flip6.firebasedemo.interaction.FirebaseDatabaseInteractor;
import com.example.flip6.firebasedemo.view.RequestView;

/**
 * Created by flip6 on 16.6.2016..
 */
public class RequestPresenterImpl implements RequestPresenter {
    private final FirebaseDatabaseInteractor databaseInteractor;

    private RequestView requestView;

    public RequestPresenterImpl(FirebaseDatabaseInteractor databaseInteractor) {
        this.databaseInteractor = databaseInteractor;
    }

    @Override
    public void requestFromValidLink() {
        databaseInteractor.requestFromValidLink(bindMessageRequestListener());
    }

    @Override
    public void requestFromInvalidLink() {
        databaseInteractor.requestFromInvalidLink(bindMessageRequestListener());
    }

    protected RequestListener<MessageModel> bindMessageRequestListener() {
        return new RequestListener<MessageModel>() {
            @Override
            public void onSuccessfulRequest(MessageModel callback) {
                if (callback != null) { //successful request and parse
                    requestView.setReceivedMessage(callback.getMessage());
                    requestView.setMessageAuthor(callback.getAuthor());
                } else { //parsed the wrong object
                    requestView.showOnWrongReferenceErrorMessage();
                }
            }

            @Override
            public void onFailedRequest() {
                requestView.showOnFailedToRequest(); //no net connection
            }
        };
    }

    @Override
    public void setView(RequestView view) {
        this.requestView = view;
    }
}