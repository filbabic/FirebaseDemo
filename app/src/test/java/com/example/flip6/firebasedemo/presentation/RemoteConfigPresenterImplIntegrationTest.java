package com.example.flip6.firebasedemo.presentation;

import com.example.flip6.firebasedemo.interaction.FirebaseRemoteConfigInteractor;
import com.example.flip6.firebasedemo.view.RemoteConfigView;

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
public class RemoteConfigPresenterImplIntegrationTest {
    private RemoteConfigPresenterImpl presenter;

    @Mock
    private FirebaseRemoteConfigInteractor remoteConfigInteractor;

    @Mock
    private RemoteConfigView remoteConfigView;

    @Before
    public void setUp() throws Exception {
        presenter = new RemoteConfigPresenterImpl(remoteConfigInteractor);
        presenter.setView(remoteConfigView);
    }

    @Test
    public void testSyncDataWithBackend() throws Exception {
        presenter.syncDataWithBackend();
        verify(remoteConfigInteractor).syncWithBackend();
        verifyNoMoreInteractions(remoteConfigView, remoteConfigInteractor);
    }

    @Test
    public void testFetchRemoteConfigValuesNotOnDiscount() throws Exception {
        when(remoteConfigInteractor.isItemOnDiscount()).thenReturn(false);
        presenter.fetchRemoteConfigValues();
        verify(remoteConfigInteractor).isItemOnDiscount();
        verify(remoteConfigView).setItemIsNotOnDiscount();
    }

    @Test
    public void testFetchRemoteConfigValuesOnDiscount() throws Exception {
        when(remoteConfigInteractor.isItemOnDiscount()).thenReturn(true);
        presenter.fetchRemoteConfigValues();
        verify(remoteConfigInteractor).getItemDiscount();
        verify(remoteConfigInteractor).isItemOnDiscount();
        verify(remoteConfigView).setItemIsOnDiscount(anyBoolean());
        verify(remoteConfigView).setItemDiscount(anyFloat());
    }
}