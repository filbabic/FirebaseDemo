package com.example.flip6.firebasedemo.storage.presenter;

import android.graphics.Bitmap;

import com.example.flip6.firebasedemo.network.backend.FirebaseHelper;
import com.example.flip6.firebasedemo.network.backend.FirebaseStorageHelper;
import com.example.flip6.firebasedemo.network.backend.ResponseListener;
import com.example.flip6.firebasedemo.storage.view.StorageView;

/**
 * Created by flip6 on 20.6.2016..
 */

public class StoragePresenterImpl implements StoragePresenter {
    private final FirebaseHelper firebaseHelper;
    private final FirebaseStorageHelper storageHelper;
    private final StorageView storageView;
    private Bitmap mPhoto;

    public StoragePresenterImpl(FirebaseHelper firebaseHelper, FirebaseStorageHelper storageHelper, StorageView storageView) {
        this.firebaseHelper = firebaseHelper;
        this.storageHelper = storageHelper;
        this.storageView = storageView;
    }

    @Override
    public void handleOnUserClickedTakeAPhotoButton() {
        storageView.startTakeAPhotoActivity();
    }

    @Override
    public void handleOnUserClickedUploadAPhotoButton() {
        if (mPhoto != null) {
            storageView.showUploadingProgressBar();
            storageHelper.uploadImageToStorage(mPhoto, new ResponseListener() {
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
    public void logTheTestUserIn(String userEmail, String userPassword) {
        firebaseHelper.logTheUserIn(userEmail, userPassword, new ResponseListener() {
            @Override
            public void onSuccessfulAuthentication() {
                storageView.hideUploadingProgressBar();
            }

            @Override
            public void onFailedAuthentication(String attemptedOperation) {
                storageView.hideUploadingProgressBar();
            }
        });
    }

    @Override
    public void logTheTestUserOut() {
        firebaseHelper.logTheUserOut();
    }
}