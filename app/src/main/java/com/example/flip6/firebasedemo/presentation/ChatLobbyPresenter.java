package com.example.flip6.firebasedemo.presentation;

import com.example.flip6.firebasedemo.view.ChatLobbyView;

/**
 * Created by flip6 on 7.7.2016..
 */
public interface ChatLobbyPresenter extends Presenter<ChatLobbyView> {
    void getChatMessages();

    void sendChatMessage(String message);
}