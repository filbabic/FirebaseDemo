package com.example.flip6.firebasedemo.presentation;

import com.example.flip6.firebasedemo.common.model.MessageModel;
import com.example.flip6.firebasedemo.interaction.FirebaseAuthenticationInteractor;
import com.example.flip6.firebasedemo.interaction.FirebaseDatabaseInteractor;
import com.example.flip6.firebasedemo.view.ChatLobbyView;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;

/**
 * Created by flip6 on 7.7.2016..
 */

public class ChatLobbyPresenterImpl implements ChatLobbyPresenter {
    private final FirebaseAuthenticationInteractor authenticationInteractor;
    private final FirebaseDatabaseInteractor databaseInteractor;

    private ChatLobbyView chatLobbyView;

    public ChatLobbyPresenterImpl(FirebaseAuthenticationInteractor authenticationInteractor, FirebaseDatabaseInteractor databaseInteractor) {
        this.authenticationInteractor = authenticationInteractor;
        this.databaseInteractor = databaseInteractor;
    }

    @Override
    public void setView(ChatLobbyView view) {
        this.chatLobbyView = view;
    }

    @Override
    public void getChatMessages() {
        databaseInteractor.getChatMessages(bindChatMessageListener());
    }

    @Override
    public void sendChatMessage(String message) {
        if (message != null) {
            databaseInteractor.sendMessage(message, authenticationInteractor.getLoggedInUserDisplayName(), authenticationInteractor.getLoggedInUserImageURL());
        }
    }


    protected ChildEventListener bindChatMessageListener() {
        return new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {//new message appears on firebase
                if (dataSnapshot != null) {
                    MessageModel model = dataSnapshot.getValue(MessageModel.class);
                    if (model != null) {
                        chatLobbyView.addMessageToAdapter(model);
                    }
                }
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {
            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        };
    }
}