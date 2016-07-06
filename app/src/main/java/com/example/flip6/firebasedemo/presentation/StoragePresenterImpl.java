package com.example.flip6.firebasedemo.presentation;

import android.graphics.Bitmap;

import com.example.flip6.firebasedemo.interaction.FirebaseStorageInteractor;
import com.example.flip6.firebasedemo.common.ResponseListener;
import com.example.flip6.firebasedemo.view.StorageView;

/**
 * Created by flip6 on 20.6.2016..
 */

public class StoragePresenterImpl implements StoragePresenter {
    private final FirebaseStorageInteractor storageInteractor;
    private Bitmap mPhoto;
    private StorageView storageView;

    public StoragePresenterImpl(FirebaseStorageInteractor storageInteractor) {
        this.storageInteractor = storageInteractor;
    }

    @Override
    public void handleOnUserClickedTakeAPhotoButton() {
        storageView.startTakeAPhotoActivity();
    }

    @Override
    public void handleOnUserClickedUploadAPhotoButton() {
        if (mPhoto != null) {
            storageView.showUploadingProgressBar();
            storageInteractor.uploadImageToStorage(mPhoto, new ResponseListener() {
                @Override
                public void onSuccessfulAuthentication() {
                    storageView.hideUploadingProgressBar();
                    storageView.showOnSuccessfulUploadToast();
                }

                @Override
                public void onFailedAuthentication(String attemptedOperation) {

                }
            });
        } else {
            storageView.showThereIsNoPhotoToUploadToast();
        }
    }

    @Override
    public void setBitmap(Bitmap bitmap) {
        this.mPhoto = bitmap;
    }

    @Override
    public void setImageViewPhoto() {
        if (mPhoto != null) {
            storageView.setImageBitmap(mPhoto);
        }
    }

    @Override
    public void setView(StorageView view) {
        this.storageView = view;
    }
}