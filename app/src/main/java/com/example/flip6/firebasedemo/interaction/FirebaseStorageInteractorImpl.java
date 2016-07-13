package com.example.flip6.firebasedemo.interaction;

import com.example.flip6.firebasedemo.common.RequestListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.UploadTask;

/**
 * Created by flip6 on 20.6.2016..
 */

public class FirebaseStorageInteractorImpl implements FirebaseStorageInteractor {
    private final FirebaseStorage firebaseStorage;

    public FirebaseStorageInteractorImpl(FirebaseStorage firebaseStorage) {
        this.firebaseStorage = firebaseStorage;
    }

    @Override
    public void uploadImageToStorage(byte[] imageBytes, final RequestListener<String> listener) {
        UploadTask uploadTask = firebaseStorage.getReference("test").putBytes(imageBytes); //reference should be unique each time so the file isn't overwritten
        uploadTask.addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                if(taskSnapshot.getDownloadUrl()!=null){
                    listener.onSuccessfulRequest(taskSnapshot.getDownloadUrl().toString());
                }
            }
        });
    }
}