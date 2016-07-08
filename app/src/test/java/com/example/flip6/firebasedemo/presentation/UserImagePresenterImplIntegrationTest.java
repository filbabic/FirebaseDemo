package com.example.flip6.firebasedemo.presentation;

import com.example.flip6.firebasedemo.common.RequestListener;
import com.example.flip6.firebasedemo.interaction.FirebaseStorageInteractor;
import com.example.flip6.firebasedemo.view.UserImageView;

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
public class UserImagePresenterImplIntegrationTest {
    private UserImagePresenterImpl presenter;
    @Mock
    private UserImageView userImageView;
    @Mock
    private FirebaseStorageInteractor storageInteractor;

    @Before
    public void setUp() throws Exception {
        presenter = new UserImagePresenterImpl(storageInteractor);
        presenter.setView(userImageView);
        presenter.setUsername("username");
    }

    @Test
    public void testHandleUserClickedTakeAPhotoButton() throws Exception {
        presenter.handleOnUserClickedTakeAPhotoButton();
        verify(userImageView).startTakeAPhotoActivity();
    }

    @Test
    public void testUploadImageToStorageArrayIsNull() throws Exception {
        presenter.uploadImageToStorage(null);
        verifyZeroInteractions(userImageView, storageInteractor);
    }

    @Test
    public void testUploadImageToStorageArrayIsValid() throws Exception {
        presenter.uploadImageToStorage(new byte[50]);
        verify(userImageView).showUploadingProgressBar();
        verify(storageInteractor).uploadImageToStorage(any(byte[].class), any(RequestListener.class));
    }

    @Test
    public void testBindImageUploadResponseListenerOnSuccessfulRequest() throws Exception {
        presenter.bindImageUploadResponseListener().onSuccessfulRequest("callback");
        verify(userImageView).proceedWithUserRegistration(anyString(), anyString());
        verify(userImageView).hideUploadingProgressBar();
        verify(userImageView).showOnSuccessfulUploadToast();
    }

    @Test
    public void testBindImageUploadResponseListenerOnFailedRequest() throws Exception {
        presenter.bindImageUploadResponseListener().onFailedRequest();
        verify(userImageView).hideUploadingProgressBar();
        verify(userImageView).showFailedUploadToast();
    }
}