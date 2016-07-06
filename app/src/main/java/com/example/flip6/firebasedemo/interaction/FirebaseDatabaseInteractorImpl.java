package com.example.flip6.firebasedemo.interaction;

import com.example.flip6.firebasedemo.common.RequestListener;
import com.example.flip6.firebasedemo.common.ResponseListener;
import com.example.flip6.firebasedemo.common.constants.FirebaseConstants;
import com.example.flip6.firebasedemo.common.model.MessageModel;
import com.google.firebase.crash.FirebaseCrash;
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
        firebaseDatabase.getReference(FirebaseConstants.MESSAGE_REFERENCE).child(FirebaseConstants.TEST_MESSAGE_LOCATION).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                MessageModel model = dataSnapshot.getValue(MessageModel.class);
                listener.onSuccessfulRequest(model);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                FirebaseCrash.report(databaseError.toException());
                listener.onFailedRequest();
            }
        });
    }

    @Override
    public void requestFromInvalidLink(final RequestListener<MessageModel> listener) {
        firebaseDatabase.getReference(FirebaseConstants.USER_REFERENCE).child(FirebaseConstants.TEST_MESSAGE_LOCATION).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                MessageModel model = dataSnapshot.getValue(MessageModel.class);
                listener.onSuccessfulRequest(model);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                FirebaseCrash.report(databaseError.toException());
                listener.onFailedRequest();
            }
        });
    }
}