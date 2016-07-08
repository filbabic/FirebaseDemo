package com.example.flip6.firebasedemo.interaction;

import com.example.flip6.firebasedemo.common.RequestListener;
import com.example.flip6.firebasedemo.common.model.MessageModel;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by flip6 on 6.7.2016..
 */

public class FirebaseDatabaseInteractorImpl implements FirebaseDatabaseInteractor {
    public final FirebaseDatabase firebaseDatabase;

    public FirebaseDatabaseInteractorImpl(FirebaseDatabase firebaseDatabase) {
        this.firebaseDatabase = firebaseDatabase;
    }

    @Override
    public void requestFromValidLink(final RequestListener<MessageModel> listener) {

    }

    @Override
    public void requestFromInvalidLink(final RequestListener<MessageModel> listener) {

    }

    @Override
    public void sendMessage(String message, String username, String usernameImageURL) {

    }

    @Override
    public void getChatMessages(ChildEventListener listener) {

    }
}