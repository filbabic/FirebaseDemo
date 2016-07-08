package com.example.flip6.firebasedemo.presentation;

import com.example.flip6.firebasedemo.R;
import com.example.flip6.firebasedemo.view.MainView;

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
public class MainPresenterImplIntegrationTest {
    private MainPresenterImpl presenter;
    @Mock
    private MainView mainView;

    @Before
    public void setUp() throws Exception {
        presenter = new MainPresenterImpl();
        presenter.setView(mainView);
    }

    @Test
    public void testHandleMenuItemClickStartChatActivity() throws Exception {
        presenter.handleMenuItemClick(R.id.menu_chat_activity);
        verify(mainView).closeNavigationDrawer();
        verify(mainView).startChatActivity();
    }

    @Test
    public void testHandleMenuItemClickStartCrashActivity() throws Exception {
        presenter.handleMenuItemClick(R.id.menu_crash_activity);
        verify(mainView).closeNavigationDrawer();
        verify(mainView).startCrashActivity();
    }

    @Test
    public void testHandleMenuItemClickStartRegisterActivity() throws Exception {
        presenter.handleMenuItemClick(R.id.menu_register_activity);
        verify(mainView).closeNavigationDrawer();
        verify(mainView).startRegisterActivity();
    }

    @Test
    public void testHandleMenuItemClickStartRemoteActivity() throws Exception {
        presenter.handleMenuItemClick(R.id.menu_remote_activity);
        verify(mainView).closeNavigationDrawer();
        verify(mainView).startRemoteActivity();
    }

    @Test
    public void testHandleMenuItemClickStartRequestActivity() throws Exception {
        presenter.handleMenuItemClick(R.id.menu_request_activity);
        verify(mainView).closeNavigationDrawer();
        verify(mainView).startRequestActivity();
    }

    @Test
    public void testHandleMenuItemClickNoInteraction() throws Exception {
        presenter.handleMenuItemClick(5);
        verify(mainView).closeNavigationDrawer();
        verifyNoMoreInteractions(mainView);
    }

    @Test
    public void testHandleUserClickedHomeButton() throws Exception {
        presenter.handleUserClickedHomeButton();
        verify(mainView).openNavigationDrawer();
    }
}