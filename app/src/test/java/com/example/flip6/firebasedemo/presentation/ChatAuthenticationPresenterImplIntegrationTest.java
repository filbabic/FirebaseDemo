package com.example.flip6.firebasedemo.presentation;

import com.example.flip6.firebasedemo.common.ResponseListener;
import com.example.flip6.firebasedemo.interaction.FirebaseAuthenticationInteractor;
import com.example.flip6.firebasedemo.view.ChatAuthView;

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
public class ChatAuthenticationPresenterImplIntegrationTest {
    private ChatAuthenticationPresenterImpl presenter;

    @Mock
    private FirebaseAuthenticationInteractor interactor;
    @Mock
    private ChatAuthView chatAuthView;

    @Before
    public void setUp() throws Exception {
        presenter = new ChatAuthenticationPresenterImpl(interactor);
        presenter.setView(chatAuthView);
    }

    @Test
    public void testLogTheUserInNullData() throws Exception {
        presenter.logTheUserIn(null, null);
        verify(chatAuthView).showFillInAllFieldsMessage();
        verifyNoMoreInteractions(chatAuthView, interactor);
    }

    @Test
    public void testLogTheUserInEmptyData() throws Exception {
        presenter.logTheUserIn("  ", "  ");
        verify(chatAuthView).showFillInAllFieldsMessage();
        verifyNoMoreInteractions(chatAuthView, interactor);
    }

    @Test
    public void testLogTheUserInValidData() throws Exception {
        presenter.logTheUserIn("email", "password");
        verify(chatAuthView).showProgressBar();
        verify(interactor).logTheUserIn(anyString(), anyString(), any(ResponseListener.class));
    }

    @Test
    public void testBindLoginListenerOnSuccessfulAuthentication() throws Exception {
        presenter.bindLoginListener().onSuccessfulAuthentication();
        verify(chatAuthView).hideProgressBar();
        verify(chatAuthView).showSuccessfulLoginMessage();
        verify(chatAuthView).moveUserToChatLobby();
        verifyNoMoreInteractions(chatAuthView, interactor);
    }

    @Test
    public void testBindLoginListenerOnFailedAuthentication() throws Exception {
        presenter.bindLoginListener().onFailedAuthentication();
        verify(chatAuthView).hideProgressBar();
        verify(chatAuthView).showInvalidLoginDataMessage();
        verifyNoMoreInteractions(chatAuthView, interactor);
    }
}