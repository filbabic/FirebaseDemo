package com.example.flip6.firebasedemo.interaction;

import com.example.flip6.firebasedemo.common.RequestListener;
import com.google.firebase.storage.FirebaseStorage;

/**
 * Created by flip6 on 20.6.2016..
 */

public class FirebaseStorageInteractorImpl implements FirebaseStorageInteractor {
    private final FirebaseStorage firebaseStorage;

    public FirebaseStorageInteractorImpl(FirebaseStorage firebaseStorage) {
        this.firebaseStorage = firebaseStorage;
    }

    @Override
    public void uploadImageToStorage(byte[] imageBytes, RequestListener<String> listener) {

    }
}