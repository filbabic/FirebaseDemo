package com.example.flip6.firebasedemo.network.backend;

import android.graphics.Bitmap;

/**
 * Created by flip6 on 20.6.2016..
 */
public interface FirebaseStorageHelper {
    void uploadImageToStorage(Bitmap imageToSend, ResponseListener listener);
}