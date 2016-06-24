package com.example.flip6.firebasedemo.network.backend;


import android.graphics.Bitmap;
import android.support.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.UploadTask;

import java.io.ByteArrayOutputStream;

/**
 * Created by flip6 on 20.6.2016..
 */

public class FirebaseStorageHelperImpl implements FirebaseStorageHelper {
    private final FirebaseStorage firebaseStorage;

    public FirebaseStorageHelperImpl(FirebaseStorage firebaseStorage) {
        this.firebaseStorage = firebaseStorage;
    }

    @Override
    public void uploadImageToStorage(Bitmap imageToSend, final ResponseListener listener) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        imageToSend.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
        byte data[] = byteArrayOutputStream.toByteArray();
        UploadTask uploadTask = firebaseStorage.getReference("test").putBytes(data);
        uploadTask.addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                listener.onSuccessfulAuthentication();
            }
        });
    }
}