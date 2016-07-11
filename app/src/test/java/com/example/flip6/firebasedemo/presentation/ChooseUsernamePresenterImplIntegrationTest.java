package com.example.flip6.firebasedemo.presentation;

import com.example.flip6.firebasedemo.view.ChooseUsernameView;

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
public class ChooseUsernamePresenterImplIntegrationTest {
    private ChooseUsernamePresenterImpl presenter;

    @Mock
    private ChooseUsernameView chooseUsernameView;

    private final String VALID_USERNAME = "username";

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        presenter = new ChooseUsernamePresenterImpl();
        presenter.setView(chooseUsernameView);
    }

    @Test
    public void testHandleUserClickedChooseUsernameButtonStringIsNull() throws Exception {
        presenter.handleUserClickedChooseUsernameButton(null);
        verify(chooseUsernameView).showUsernameCannotBeEmptyToast();
        verifyNoMoreInteractions(chooseUsernameView);
    }

    @Test
    public void testHandleUserClickedChooseUsernameButtonStringIsEmpty() throws Exception {
        presenter.handleUserClickedChooseUsernameButton("   ");
        verify(chooseUsernameView).showUsernameCannotBeEmptyToast();
        verifyNoMoreInteractions(chooseUsernameView);
    }

    @Test
    public void testHandleUserClickedChooseUsernameButtonStringIsValid() throws Exception {
        presenter.handleUserClickedChooseUsernameButton(VALID_USERNAME);
        verify(chooseUsernameView).proceedWithUserRegistration(anyString());
        verifyNoMoreInteractions(chooseUsernameView);
    }
}