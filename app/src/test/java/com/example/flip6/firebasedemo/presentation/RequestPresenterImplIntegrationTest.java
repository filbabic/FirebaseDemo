package com.example.flip6.firebasedemo.presentation;

import com.example.flip6.firebasedemo.common.RequestListener;
import com.example.flip6.firebasedemo.common.model.MessageModel;
import com.example.flip6.firebasedemo.interaction.FirebaseDatabaseInteractor;
import com.example.flip6.firebasedemo.view.RequestView;

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
public class RequestPresenterImplIntegrationTest {
    private RequestPresenterImpl presenter;
    @Mock
    private FirebaseDatabaseInteractor databaseInteractor;

    @Mock
    private RequestView requestView;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        presenter = new RequestPresenterImpl(databaseInteractor);
        presenter.setView(requestView);
    }

    @Test
    public void testRequestFromValidLink() throws Exception {
        presenter.requestFromValidLink();
        verify(databaseInteractor).requestFromValidLink(any(RequestListener.class));
        verifyNoMoreInteractions(requestView, databaseInteractor);
    }

    @Test
    public void testRequestFromInvalidLink() throws Exception {
        presenter.requestFromInvalidLink();
        verify(databaseInteractor).requestFromInvalidLink(any(RequestListener.class));
        verifyNoMoreInteractions(requestView, databaseInteractor);
    }

    @Test
    public void testBindMessageRequestListenerOnSuccessfulRequestMessageIsNull() throws Exception {
        presenter.bindMessageRequestListener().onSuccessfulRequest(null);
        verify(requestView).showOnWrongReferenceErrorMessage();
        verifyNoMoreInteractions(requestView, databaseInteractor);
    }

    @Test
    public void testBindMessageRequestListenerOnSuccessfulRequestMessageIsValid() throws Exception {
        presenter.bindMessageRequestListener().onSuccessfulRequest(new MessageModel());
        verify(requestView).setMessageAuthor(anyString());
        verify(requestView).setReceivedMessage(anyString());
        verifyNoMoreInteractions(requestView, databaseInteractor);
    }

    @Test
    public void testBindMessageRequestListenerOnFailedRequest() throws Exception {
        presenter.bindMessageRequestListener().onFailedRequest();
        verify(requestView).showOnFailedToRequest();
        verifyNoMoreInteractions(requestView, databaseInteractor);
    }
}