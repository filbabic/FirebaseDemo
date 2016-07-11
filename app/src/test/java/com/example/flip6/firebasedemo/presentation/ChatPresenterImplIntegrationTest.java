package com.example.flip6.firebasedemo.presentation;

import com.example.flip6.firebasedemo.interaction.FirebaseAuthenticationInteractor;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.*;

/**
 * Created by flip6 on 8.7.2016..
 */
@RunWith(MockitoJUnitRunner.class)
public class ChatPresenterImplIntegrationTest {
    private ChatPresenterImpl presenter;
    @Mock
    private FirebaseAuthenticationInteractor authenticationInteractor;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        presenter = new ChatPresenterImpl(authenticationInteractor);
    }

    @Test
    public void testLogTheUserOut() throws Exception {
        presenter.logTheUserOut();
        verify(authenticationInteractor).logTheUserOut();
    }
}