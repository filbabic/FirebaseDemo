package com.example.flip6.firebasedemo.ui.registration;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.flip6.firebasedemo.App;
import com.example.flip6.firebasedemo.R;
import com.example.flip6.firebasedemo.common.constants.Constants;
import com.example.flip6.firebasedemo.presentation.UserImagePresenter;
import com.example.flip6.firebasedemo.ui.base.BaseFragment;
import com.example.flip6.firebasedemo.ui.common.image.ImageHelper;
import com.example.flip6.firebasedemo.view.UserImageView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

import static android.app.Activity.RESULT_OK;

/**
 * Created by flip6 on 20.6.2016..
 */

public class UserImageFragment extends BaseFragment implements View.OnClickListener, UserImageView {
    @BindView(R.id.take_a_photo_button)
    Button mTakeAPhotoButton;

    @BindView(R.id.progress_bar)
    ProgressBar mUploadingProgressBar;

    @Inject
    UserImagePresenter presenter;

    public static UserImageFragment newInstance(Bundle data) {
        UserImageFragment f = new UserImageFragment();
        f.setArguments(data);
        return f;
    }

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
            Bitmap bitmap = (Bitmap) data.getExtras().get(Constants.IMAGE_KEY);
            presenter.uploadImageToStorage(ImageHelper.getImageByteArray(bitmap));
        }
    }

    @Override
    public void onClick(View view) {
        if (view == mTakeAPhotoButton) {
            presenter.handleOnUserClickedTakeAPhotoButton();
        }
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

    @Override
    public void showFailedUploadToast() {
        Toast.makeText(App.get(), R.string.failed_to_upload_image_toast, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void proceedWithUserRegistration(String imageURL, String username) {
        getActivity()
                .getSupportFragmentManager()
                .beginTransaction()
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .replace(R.id.register_activity_frame_layout, UserAccountDetailsFragment.newInstance(createDataBundle(imageURL, username)))
                .commit();
    }

    protected Bundle createDataBundle(String imageURL, String username) {
        Bundle data = new Bundle();
        data.putString(Constants.USER_IMAGE_BUNDLE_KEY, imageURL);
        data.putString(Constants.USERNAME_BUNDLE_KEY, username);
        return data;
    }

    @Override
    protected void receiveBundleArguments() {
        Bundle data = this.getArguments();
        if (data != null && data.containsKey(Constants.USERNAME_BUNDLE_KEY)) {
            presenter.setUsername(data.getString(Constants.USERNAME_BUNDLE_KEY));
        }
    }
}