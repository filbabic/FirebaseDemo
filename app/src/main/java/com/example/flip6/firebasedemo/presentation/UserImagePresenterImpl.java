package com.example.flip6.firebasedemo.presentation;


import com.example.flip6.firebasedemo.common.RequestListener;
import com.example.flip6.firebasedemo.interaction.FirebaseStorageInteractor;
import com.example.flip6.firebasedemo.view.UserImageView;

/**
 * Created by flip6 on 20.6.2016..
 */

public class UserImagePresenterImpl implements UserImagePresenter {
    private final FirebaseStorageInteractor storageInteractor;
    private UserImageView userImageView;

    private String username;

    public UserImagePresenterImpl(FirebaseStorageInteractor storageInteractor) {
        this.storageInteractor = storageInteractor;
    }

    @Override
    public void handleOnUserClickedTakeAPhotoButton() {
        userImageView.startTakeAPhotoActivity();
    }

    @Override
    public void uploadImageToStorage(byte[] imageByteArray) {
        if (imageByteArray != null) {
            userImageView.showUploadingProgressBar();
            storageInteractor.uploadImageToStorage(imageByteArray, bindImageUploadResponseListener());
        }
    }

    @Override
    public void setUsername(String username) {
        this.username = username;
    }

    protected RequestListener<String> bindImageUploadResponseListener() {
        return new RequestListener<String>() {
            @Override
            public void onSuccessfulRequest(String callback) {
                userImageView.proceedWithUserRegistration(callback, username);
                userImageView.hideUploadingProgressBar();
                userImageView.showOnSuccessfulUploadToast();
            }

            @Override
            public void onFailedRequest() {
                userImageView.hideUploadingProgressBar();
                userImageView.showFailedUploadToast();
            }
        };
    }

    @Override
    public void setView(UserImageView view) {
        this.userImageView = view;
    }
}