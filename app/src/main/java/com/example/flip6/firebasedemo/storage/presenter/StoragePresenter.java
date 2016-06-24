package com.example.flip6.firebasedemo.storage.presenter;

import android.graphics.Bitmap;

/**
 * Created by flip6 on 20.6.2016..
 */
public interface StoragePresenter {
    void handleOnUserClickedTakeAPhotoButton();

    void handleOnUserClickedUploadAPhotoButton();

    void setBitmap(Bitmap bitmap);

    void setImageViewPhoto();

    void logTheTestUserIn(String userEmail, String userPassword);

    void logTheTestUserOut();
}