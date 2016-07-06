package com.example.flip6.firebasedemo.view;

import android.graphics.Bitmap;

/**
 * Created by flip6 on 20.6.2016..
 */
public interface StorageView {
    void showThereIsNoPhotoToUploadToast();

    void showUploadingProgressBar();

    void hideUploadingProgressBar();

    void setImageBitmap(Bitmap bitmap);

    void startTakeAPhotoActivity();

    void showOnSuccessfulUploadToast();
}