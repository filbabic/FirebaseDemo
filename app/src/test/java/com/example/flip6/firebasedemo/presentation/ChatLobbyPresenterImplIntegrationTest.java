package com.example.flip6.firebasedemo.presentation;

import com.example.flip6.firebasedemo.common.model.MessageModel;
import com.example.flip6.firebasedemo.interaction.FirebaseAuthenticationInteractor;
import com.example.flip6.firebasedemo.interaction.FirebaseDatabaseInteractor;
import com.example.flip6.firebasedemo.view.ChatLobbyView;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.*;

/**
 * Created by flip6 on 8.7.2016..
 */
@RunWith(MockitoJUnitRunner.class)
public class ChatLobbyPresenterImplIntegrationTest {
    private ChatLobbyPresenterImpl presenter;

    @Mock
    private FirebaseDatabaseInteractor databaseInteractor;

    @Mock
    private FirebaseAuthenticationInteractor authenticationInteractor;

    @Mock
    private ChatLobbyView chatLobbyView;

    @Mock
    private DataSnapshot dataSnapshot;

    @Before
    public void setUp() throws Exception {
        presenter = new ChatLobbyPresenterImpl(authenticationInteractor, databaseInteractor);
        presenter.setView(chatLobbyView);
    }

    @Test
    public void testGetChatMessages() throws Exception {
        presenter.getChatMessages();
        verify(databaseInteractor).getChatMessages(any(ChildEventListener.class));
    }

    @Test
    public void testSendChatMessageStringIsNull() throws Exception {
        presenter.sendChatMessage(null);
        verifyZeroInteractions(authenticationInteractor, chatLobbyView, databaseInteractor);
    }

    @Test
    public void testSendChatMessageStringIsValid() throws Exception {
        presenter.sendChatMessage("message");
        verify(authenticationInteractor).getLoggedInUserDisplayName();
        verify(authenticationInteractor).getLoggedInUserImageURL();
        verify(databaseInteractor).sendMessage(anyString(), anyString(), anyString());
    }

    @Test
    public void testBindChatMessageListenerOnChildAddedSnapshotIsNull() throws Exception {
        presenter.bindChatMessageListener().onChildAdded(null, null);
        verifyZeroInteractions(chatLobbyView, databaseInteractor, authenticationInteractor);
    }

    @Test
    public void testBindChatMessageListenerOnChildAddedMessageIsNull() throws Exception {
        when(dataSnapshot.getValue(MessageModel.class)).thenReturn(null);
        presenter.bindChatMessageListener().onChildAdded(dataSnapshot, null);
        verifyZeroInteractions(chatLobbyView, databaseInteractor, authenticationInteractor);
    }

    @Test
    public void testBindChatMessageListenerOnChildAddedMessageIsValid() throws Exception {
        when(dataSnapshot.getValue(MessageModel.class)).thenReturn(new MessageModel());
        presenter.bindChatMessageListener().onChildAdded(dataSnapshot, null);
        verify(chatLobbyView).addMessageToAdapter(any(MessageModel.class));
    }

    @Test
    public void testBindChatMessageListenerOnChildChanged() throws Exception {
        presenter.bindChatMessageListener().onChildChanged(null, null);
        verifyZeroInteractions(authenticationInteractor, databaseInteractor, chatLobbyView);
    }

    @Test
    public void testBindChatMessageListenerOnChildRemoved() throws Exception {
        presenter.bindChatMessageListener().onChildRemoved(null);
        verifyZeroInteractions(authenticationInteractor, databaseInteractor, chatLobbyView);
    }

    @Test
    public void testBindChatMessageListenerOnChildMoved() throws Exception {
        presenter.bindChatMessageListener().onChildMoved(null, null);
        verifyZeroInteractions(authenticationInteractor, databaseInteractor, chatLobbyView);
    }

    @Test
    public void testBindChatMessageListenerOnCancelled() throws Exception {
        presenter.bindChatMessageListener().onCancelled(null);
        verifyZeroInteractions(authenticationInteractor, databaseInteractor, chatLobbyView);
    }
}