package com.example.flip6.firebasedemo.presentation;

import com.example.flip6.firebasedemo.view.UserImageView;

/**
 * Created by flip6 on 20.6.2016..
 */
public interface UserImagePresenter extends Presenter<UserImageView> {
    void handleOnUserClickedTakeAPhotoButton();

    void uploadImageToStorage(byte[] imageByteArray);

    void setUsername(String username);
}