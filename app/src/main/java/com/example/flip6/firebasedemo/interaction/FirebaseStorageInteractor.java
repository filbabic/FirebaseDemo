package com.example.flip6.firebasedemo.interaction;

import android.graphics.Bitmap;

import com.example.flip6.firebasedemo.common.ResponseListener;

/**
 * Created by flip6 on 20.6.2016..
 */
public interface FirebaseStorageInteractor {
    void uploadImageToStorage(Bitmap imageToSend, ResponseListener listener);
}