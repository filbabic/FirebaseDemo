package com.example.flip6.firebasedemo.presentation;


import com.example.flip6.firebasedemo.common.RequestListener;
import com.example.flip6.firebasedemo.interaction.FirebaseAuthenticationInteractor;
import com.example.flip6.firebasedemo.interaction.FirebaseStorageInteractor;
import com.example.flip6.firebasedemo.view.UserImageView;

/**
 * Created by flip6 on 20.6.2016..
 */

public class UserImagePresenterImpl implements UserImagePresenter {
    private final FirebaseStorageInteractor storageInteractor;
    private final FirebaseAuthenticationInteractor interactor;
    private UserImageView userImageView;

    public UserImagePresenterImpl(FirebaseStorageInteractor storageInteractor, FirebaseAuthenticationInteractor interactor) {
        this.storageInteractor = storageInteractor;
        this.interactor = interactor;
    }

    @Override
    public void setView(UserImageView view) {
        this.userImageView = view;
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

    protected RequestListener<String> bindImageUploadResponseListener() {
        return new RequestListener<String>() {
            @Override
            public void onSuccessfulRequest(String callback) {
                interactor.changeUserImageUrl(callback);
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
}