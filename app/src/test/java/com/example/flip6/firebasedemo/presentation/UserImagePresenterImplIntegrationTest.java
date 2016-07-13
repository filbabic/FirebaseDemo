package com.example.flip6.firebasedemo.presentation;

import com.example.flip6.firebasedemo.common.RequestListener;
import com.example.flip6.firebasedemo.interaction.FirebaseAuthenticationInteractor;
import com.example.flip6.firebasedemo.interaction.FirebaseStorageInteractor;
import com.example.flip6.firebasedemo.view.UserImageView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.verifyZeroInteractions;

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
    @Mock
    private FirebaseAuthenticationInteractor authenticationInteractor;

    private final String VALID_IMAGE_URL = "imageURL";
    private final byte[] imageBytes = new byte[50];

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        presenter = new UserImagePresenterImpl(storageInteractor, authenticationInteractor);
        presenter.setView(userImageView);
    }

    @Test
    public void testHandleUserClickedTakeAPhotoButton() throws Exception {
        presenter.handleOnUserClickedTakeAPhotoButton();
        verify(userImageView).startTakeAPhotoActivity();
        verifyNoMoreInteractions(userImageView, storageInteractor);
    }

    @Test
    public void testUploadImageToStorageArrayIsNull() throws Exception {
        presenter.uploadImageToStorage(null);
        verifyZeroInteractions(userImageView, storageInteractor);
    }

    @Test
    public void testUploadImageToStorageArrayIsValid() throws Exception {
        presenter.uploadImageToStorage(imageBytes);
        verify(userImageView).showUploadingProgressBar();
        verify(storageInteractor).uploadImageToStorage(any(byte[].class), any(RequestListener.class));
        verifyNoMoreInteractions(userImageView, storageInteractor);
    }

    @Test
    public void testBindImageUploadResponseListenerOnSuccessfulRequest() throws Exception {
        presenter.bindImageUploadResponseListener().onSuccessfulRequest(VALID_IMAGE_URL);
        verify(authenticationInteractor).changeUserImageUrl(anyString());
        verify(userImageView).hideUploadingProgressBar();
        verify(userImageView).showOnSuccessfulUploadToast();
        verifyNoMoreInteractions(userImageView, storageInteractor);
    }

    @Test
    public void testBindImageUploadResponseListenerOnFailedRequest() throws Exception {
        presenter.bindImageUploadResponseListener().onFailedRequest();
        verify(userImageView).hideUploadingProgressBar();
        verify(userImageView).showFailedUploadToast();
        verifyNoMoreInteractions(userImageView, storageInteractor);
    }
}