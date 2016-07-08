package com.example.flip6.firebasedemo.interaction;

import com.example.flip6.firebasedemo.common.RequestListener;

/**
 * Created by flip6 on 20.6.2016..
 */
public interface FirebaseStorageInteractor {
    void uploadImageToStorage(byte[] imageBytes, RequestListener<String> listener);
}