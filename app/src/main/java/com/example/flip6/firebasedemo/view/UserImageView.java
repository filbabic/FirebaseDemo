package com.example.flip6.firebasedemo.view;

/**
 * Created by flip6 on 20.6.2016..
 */
public interface UserImageView {
    void showUploadingProgressBar();

    void hideUploadingProgressBar();

    void startTakeAPhotoActivity();

    void loadImageFromResources();

    void showOnSuccessfulUploadToast();

    void showFailedUploadToast();
}