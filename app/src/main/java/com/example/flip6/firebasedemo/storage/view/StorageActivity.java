package com.example.flip6.firebasedemo.storage.view;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.flip6.firebasedemo.App;
import com.example.flip6.firebasedemo.R;
import com.example.flip6.firebasedemo.constants.Constants;
import com.example.flip6.firebasedemo.storage.presenter.StoragePresenter;
import com.example.flip6.firebasedemo.storage.presenter.StoragePresenterImpl;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by flip6 on 20.6.2016..
 */

public class StorageActivity extends AppCompatActivity implements View.OnClickListener, StorageView {
    @BindView(R.id.take_a_photo_button)
    Button mTakeAPhotoButton;

    @BindView(R.id.photo_image_view)
    ImageView mPhotoImageView;

    @BindView(R.id.upload_a_photo_button)
    Button mUploadAPhotoButton;

    @BindView(R.id.uploading_progress_bar)
    ProgressBar mUploadingProgessBar;

    private StoragePresenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.storage_activity);
        ButterKnife.bind(this);
        initPresenter();
        initUI();
        presenter.logTheTestUserIn(Constants.TEST_USER_EMAIL, Constants.TEST_USER_PASSWORD);
    }

    private void initPresenter() {
        presenter = new StoragePresenterImpl(App.get().getFirebaseHelper(), App.get().getFirebaseStorageHelper(), this);
    }

    private void initUI() {
        mTakeAPhotoButton.setOnClickListener(this);
        mUploadAPhotoButton.setOnClickListener(this);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == Constants.IMAGE_CAPTURE_CODE && resultCode == RESULT_OK) {
            Bitmap bitmap = (Bitmap) data.getExtras().get("data");
            presenter.setBitmap(bitmap);
            presenter.setImageViewPhoto();
        }
    }

    @Override
    public void onClick(View view) {
        if (view == mTakeAPhotoButton) {
            presenter.handleOnUserClickedTakeAPhotoButton();
        } else if (view == mUploadAPhotoButton) {
            presenter.handleOnUserClickedUploadAPhotoButton();
        }
    }

    @Override
    public void onBackPressed() {
        presenter.logTheTestUserOut();
        super.onBackPressed();
    }

    @Override
    public void showThereIsNoPhotoToUploadToast() {
        Toast.makeText(App.get(), R.string.no_photo_to_upload_toast, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showUploadingProgressBar() {
        mUploadingProgessBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideUploadingProgressBar() {
        mUploadingProgessBar.setVisibility(View.INVISIBLE);
    }

    @Override
    public void setImageBitmap(Bitmap bitmap) {
        mPhotoImageView.setImageBitmap(bitmap);
        mUploadAPhotoButton.setVisibility(View.VISIBLE);
    }

    @Override
    public void startTakeAPhotoActivity() {
        Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (i.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(i, Constants.IMAGE_CAPTURE_CODE);
        }
    }

    @Override
    public void showOnSuccessfulUploadToast() {
        Toast.makeText(App.get(), R.string.successful_upload_toast, Toast.LENGTH_SHORT).show();
    }
}