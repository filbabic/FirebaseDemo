package com.example.flip6.firebasedemo.interaction;

import com.example.flip6.firebasedemo.common.RequestListener;
import com.example.flip6.firebasedemo.common.model.MessageModel;

/**
 * Created by flip6 on 6.7.2016..
 */
public interface FirebaseDatabaseInteractor {
    void requestFromValidLink(RequestListener<MessageModel> listener);

    void requestFromInvalidLink(RequestListener<MessageModel> listener);
}