package com.example.flip6.firebasedemo.presentation;

import com.example.flip6.firebasedemo.common.ResponseListener;
import com.example.flip6.firebasedemo.interaction.FirebaseAuthenticationInteractor;
import com.example.flip6.firebasedemo.view.RequestAuthView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.*;

/**
 * Created by cobe on 13/07/16.
 */
@RunWith(MockitoJUnitRunner.class)
public class RequestAuthPresenterImplTest {
    private final String VALID_EMAIL = "email";
    private final String VALID_PASSWORD = "password";
    private RequestAuthPresenterImpl presenter;
    @Mock
    private FirebaseAuthenticationInteractor authenticationInteractor;
    @Mock
    private RequestAuthView requestAuthView;

    @Before
    public void setUp() throws Exception {
        presenter = new RequestAuthPresenterImpl(authenticationInteractor);
        presenter.setView(requestAuthView);
    }

    @Test
    public void testLogTheUserInEmptyData() throws Exception {
        presenter.logTheUserIn("  ", "  ");
        verify(requestAuthView).showFieldsAreEmptyMessage();
        verifyNoMoreInteractions(authenticationInteractor, requestAuthView);
    }

    @Test
    public void testLogTheUserInNullData() throws Exception {
        presenter.logTheUserIn(null, null);
        verify(requestAuthView).showFieldsAreEmptyMessage();
        verifyNoMoreInteractions(authenticationInteractor, requestAuthView);
    }

    @Test
    public void testLogTheUserInValidData() throws Exception {
        presenter.logTheUserIn(VALID_EMAIL, VALID_PASSWORD);
        verify(authenticationInteractor).logTheUserIn(anyString(), anyString(), any(ResponseListener.class));
    }

    @Test
    public void testBindListenerOnSuccessfulRequest() throws Exception {
        presenter.bindLoginListener().onSuccessfulAuthentication();
        verify(requestAuthView).moveUserToRequestFragment();
    }

    @Test
    public void testBindListenerOnFailedRequest() throws Exception {
        presenter.bindLoginListener().onFailedAuthentication();
        verify(requestAuthView).showInvalidDataMessage();
    }
}