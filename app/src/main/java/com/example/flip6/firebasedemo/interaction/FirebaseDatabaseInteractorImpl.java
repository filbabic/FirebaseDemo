package com.example.flip6.firebasedemo.interaction;

import com.example.flip6.firebasedemo.common.RequestListener;
import com.example.flip6.firebasedemo.common.constants.FirebaseConstants;
import com.example.flip6.firebasedemo.common.model.MessageModel;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

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
        firebaseDatabase.getReference(FirebaseConstants.MESSAGE_REFERENCE).child(FirebaseConstants.TEST_LOCATION).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                MessageModel model = dataSnapshot.getValue(MessageModel.class);
                if (model != null) {
                    listener.onSuccessfulRequest(model); //successful parse
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    @Override
    public void requestFromInvalidLink(final RequestListener<MessageModel> listener) {
        firebaseDatabase.getReference(FirebaseConstants.USER_REFERENCE).child(FirebaseConstants.TEST_LOCATION).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                MessageModel model = dataSnapshot.getValue(MessageModel.class);
                listener.onSuccessfulRequest(model);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    @Override
    public void sendMessage(String message, String username, String usernameImageURL) {
        MessageModel model = new MessageModel(message, username, usernameImageURL);
        firebaseDatabase.getReference(FirebaseConstants.MESSAGE_REFERENCE).push().setValue(model);
    }

    @Override
    public void getChatMessages(ChildEventListener listener) {
        firebaseDatabase.getReference(FirebaseConstants.MESSAGE_REFERENCE).addChildEventListener(listener);
    }
}