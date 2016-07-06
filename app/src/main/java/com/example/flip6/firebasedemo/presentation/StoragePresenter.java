package com.example.flip6.firebasedemo.presentation;

import android.graphics.Bitmap;

import com.example.flip6.firebasedemo.view.StorageView;

/**
 * Created by flip6 on 20.6.2016..
 */
public interface StoragePresenter extends Presenter<StorageView> {
    void handleOnUserClickedTakeAPhotoButton();

    void handleOnUserClickedUploadAPhotoButton();

    void setBitmap(Bitmap bitmap);

    void setImageViewPhoto();
}