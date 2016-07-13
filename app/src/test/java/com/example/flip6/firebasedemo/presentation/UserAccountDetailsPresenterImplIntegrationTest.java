package com.example.flip6.firebasedemo.presentation;

import com.example.flip6.firebasedemo.common.ResponseListener;
import com.example.flip6.firebasedemo.interaction.FirebaseAuthenticationInteractor;
import com.example.flip6.firebasedemo.view.UserAccountDetailsView;

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
public class UserAccountDetailsPresenterImplIntegrationTest {
    private UserAccountDetailsPresenterImpl presenter;
    @Mock
    private UserAccountDetailsView userAccountDetailsView;

    @Mock
    private FirebaseAuthenticationInteractor authenticationInteractor;

    private final String VALID_USERNAME = "username";
    private final String VALID_EMAIL = "email@net.com";
    private final String VALID_PASSWORD = "password";

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        presenter = new UserAccountDetailsPresenterImpl(authenticationInteractor);
        presenter.setView(userAccountDetailsView);
        presenter.setUsername(VALID_USERNAME);
    }

    @Test
    public void testHandleRegisterButtonClickDataIsNull() throws Exception {
        presenter.handleRegisterButtonClick(null, null);
        verify(userAccountDetailsView).showAllFieldsMustBeFilledMessage();
        verifyNoMoreInteractions(userAccountDetailsView, authenticationInteractor);
    }

    @Test
    public void testHandleRegisterButtonClickDataIsEmpty() throws Exception {
        presenter.handleRegisterButtonClick("  ", "  ");
        verify(userAccountDetailsView).showAllFieldsMustBeFilledMessage();
        verifyNoMoreInteractions(userAccountDetailsView, authenticationInteractor);
    }

    @Test
    public void testHandleRegisterButtonClickDataIsValid() throws Exception {
        presenter.handleRegisterButtonClick(VALID_EMAIL, VALID_PASSWORD);
        verify(userAccountDetailsView).showProgressBar();
        verify(authenticationInteractor).registerUser(anyString(), anyString(), any(ResponseListener.class));
        verifyNoMoreInteractions(userAccountDetailsView, authenticationInteractor);
    }

    @Test
    public void testLogCurrentUserOut() throws Exception {
        presenter.logCurrentUserOut();
        verify(authenticationInteractor).logTheUserOut();
        verifyNoMoreInteractions(userAccountDetailsView, authenticationInteractor);
    }

    @Test
    public void testBindUserRegisterListenerOnSuccess() throws Exception {
        presenter.bindUserRegisterListener().onSuccessfulAuthentication();
        verify(userAccountDetailsView).hideProgressBar();
        verify(userAccountDetailsView).showSuccessfulRegisterMessage();
        verify(authenticationInteractor).changeUserDisplayName(anyString());
        verify(userAccountDetailsView).moveUserToChooseImageFragment();
        verifyNoMoreInteractions(userAccountDetailsView, authenticationInteractor);
    }

    @Test
    public void testBindUserRegisterListenerOnSuccessDataIsValid() throws Exception {
        presenter.bindUserRegisterListener().onFailedAuthentication();
        verify(userAccountDetailsView).hideProgressBar();
        verify(userAccountDetailsView).showInvalidRegisterMessage();
        verifyNoMoreInteractions(userAccountDetailsView, authenticationInteractor);
    }
}