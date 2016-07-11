package com.example.flip6.firebasedemo.presentation;

import com.example.flip6.firebasedemo.interaction.FirebaseAuthenticationInteractor;
import com.example.flip6.firebasedemo.interaction.FirebaseDatabaseInteractor;
import com.example.flip6.firebasedemo.interaction.FirebaseRemoteConfigInteractor;
import com.example.flip6.firebasedemo.interaction.FirebaseStorageInteractor;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.*;

/**
 * Created by flip6 on 8.7.2016..
 */
public class PresentationModuleTest {
    private PresentationModule presentationModule;

    @Mock
    private FirebaseAuthenticationInteractor authenticationInteractor;
    @Mock
    private FirebaseDatabaseInteractor databaseInteractor;

    @Mock
    private FirebaseStorageInteractor storageInteractor;

    @Mock
    private FirebaseRemoteConfigInteractor remoteConfigInteractor;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        presentationModule = new PresentationModule();
    }

    @Test
    public void testProvideRequestPresenterNotNull() throws Exception {
        assertNotNull(presentationModule.provideRequestPresenter(databaseInteractor));
    }

    @Test
    public void testProvideRemoteConfigPresenterNotNull() throws Exception {
        assertNotNull(presentationModule.provideRemoteConfigPresenter(remoteConfigInteractor));
    }

    @Test
    public void testProvideUserImagePresenterNotNull() throws Exception {
        assertNotNull(presentationModule.provideUserImagePresenter(storageInteractor));
    }

    @Test
    public void testProvideMainPresenterNotNull() throws Exception {
        assertNotNull(presentationModule.provideMainPresenter());
    }

    @Test
    public void testProvideChatPresenterNotNull() throws Exception {
        assertNotNull(presentationModule.provideChatPresenter(authenticationInteractor));
    }

    @Test
    public void testProvideChatAuthenticationPresenterNotNull() throws Exception {
        assertNotNull(presentationModule.provideChatAuthenticationPresenter(authenticationInteractor));
    }

    @Test
    public void testProvideChatLobbyPresenterNotNull() throws Exception {
        assertNotNull(presentationModule.provideChatLobbyPresenter(databaseInteractor, authenticationInteractor));
    }

    @Test
    public void testProvideCrashPresenterNotNull() throws Exception {
        assertNotNull(presentationModule.provideCrashPresenter());
    }

    @Test
    public void testProvideChooseUsernamePresenterNotNull() throws Exception {
        assertNotNull(presentationModule.provideChooseUsernamePresenter());
    }

    @Test
    public void testProvideUserAccountDetailsPresenterNotNull() throws Exception {
        assertNotNull(presentationModule.provideUserAccountDetailsPresenter(authenticationInteractor));
    }
}