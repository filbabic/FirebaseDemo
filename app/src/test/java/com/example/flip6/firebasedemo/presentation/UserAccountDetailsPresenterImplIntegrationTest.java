package com.example.flip6.firebasedemo.presentation;

import com.example.flip6.firebasedemo.common.ResponseListener;
import com.example.flip6.firebasedemo.interaction.FirebaseAuthenticationInteractor;
import com.example.flip6.firebasedemo.view.UserAccountDetailsView;

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
public class UserAccountDetailsPresenterImplIntegrationTest {
    private UserAccountDetailsPresenterImpl presenter;
    @Mock
    private UserAccountDetailsView userAccountDetailsView;

    @Mock
    private FirebaseAuthenticationInteractor authenticationInteractor;

    @Before
    public void setUp() throws Exception {
        presenter = new UserAccountDetailsPresenterImpl(authenticationInteractor);
        presenter.setView(userAccountDetailsView);
        presenter.setUsername("username");
        presenter.setImageURL("imageUrl");
    }

    @Test
    public void testHandleRegisterButtonClickDataIsNull() throws Exception {
        presenter.handleRegisterButtonClick(null, null);
        verify(userAccountDetailsView).showAllFieldsMustBeFilledMessage();
    }

    @Test
    public void testHandleRegisterButtonClickDataIsEmpty() throws Exception {
        presenter.handleRegisterButtonClick("  ", "  ");
        verify(userAccountDetailsView).showAllFieldsMustBeFilledMessage();
    }

    @Test
    public void testHandleRegisterButtonClickDataIsValid() throws Exception {
        presenter.handleRegisterButtonClick("email", "password");
        verify(userAccountDetailsView).showProgressBar();
        verify(authenticationInteractor).registerUser(anyString(), anyString(), any(ResponseListener.class));
    }

    @Test
    public void testLogCurrentUserOut() throws Exception {
        presenter.logCurrentUserOut();
        verify(authenticationInteractor).logTheUserOut();
    }

    @Test
    public void testBindUserRegisterListenerOnSuccess() throws Exception {
        presenter.bindUserRegisterListener().onSuccessfulAuthentication();
        verify(userAccountDetailsView).hideProgressBar();
        verify(userAccountDetailsView).showSuccessfulRegisterMessage();
        verify(authenticationInteractor).changeUserProfileData(anyString(), anyString());
    }

    @Test
    public void testBindUserRegisterListenerOnSuccessDataIsValid() throws Exception {
        presenter.bindUserRegisterListener().onFailedAuthentication();
        verify(userAccountDetailsView).hideProgressBar();
        verify(userAccountDetailsView).showInvalidRegisterMessage();
    }
}