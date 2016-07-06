package com.example.flip6.firebasedemo.ui.registration;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.flip6.firebasedemo.App;
import com.example.flip6.firebasedemo.R;
import com.example.flip6.firebasedemo.common.constants.Constants;
import com.example.flip6.firebasedemo.view.StorageView;

import butterknife.BindView;
import butterknife.ButterKnife;

import static android.app.Activity.RESULT_OK;

/**
 * Created by flip6 on 20.6.2016..
 */

public class UserImageFragment extends Fragment implements View.OnClickListener, StorageView {
    @BindView(R.id.take_a_photo_button)
    Button mTakeAPhotoButton;

    @BindView(R.id.photo_image_view)
    ImageView mPhotoImageView;

    @BindView(R.id.uploading_progress_bar)
    ProgressBar mUploadingProgressBar;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_user_image, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        App.get().component().inject(this);
        ButterKnife.bind(this, view);
        initUI();
    }

    private void initUI() {
        mTakeAPhotoButton.setOnClickListener(this);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == Constants.IMAGE_CAPTURE_CODE && resultCode == RESULT_OK) {
            Bitmap bitmap = (Bitmap) data.getExtras().get("data");
        }
    }

    @Override
    public void onClick(View view) {
        if (view == mTakeAPhotoButton) {
        }
    }

    @Override
    public void showThereIsNoPhotoToUploadToast() {
        Toast.makeText(App.get(), R.string.no_photo_to_upload_toast, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showUploadingProgressBar() {
        mUploadingProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideUploadingProgressBar() {
        mUploadingProgressBar.setVisibility(View.INVISIBLE);
    }

    @Override
    public void setImageBitmap(Bitmap bitmap) {
        mPhotoImageView.setImageBitmap(bitmap);
    }

    @Override
    public void startTakeAPhotoActivity() {
        Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (i.resolveActivity(getActivity().getPackageManager()) != null) {
            startActivityForResult(i, Constants.IMAGE_CAPTURE_CODE);
        }
    }

    @Override
    public void showOnSuccessfulUploadToast() {
        Toast.makeText(App.get(), R.string.successful_upload_toast, Toast.LENGTH_SHORT).show();
    }
}