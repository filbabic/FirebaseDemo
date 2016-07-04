package com.example.flip6.firebasedemo.database.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.flip6.firebasedemo.App;
import com.example.flip6.firebasedemo.R;
import com.example.flip6.firebasedemo.database.presenter.DatabasePresenter;
import com.example.flip6.firebasedemo.database.presenter.DatabasePresenterImpl;

import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by flip6 on 19.6.2016..
 */

public class DatabaseMessageFragment extends Fragment implements DatabaseView, View.OnClickListener {
    @BindView(R.id.message_edit_text)
    EditText mMessageEditText;

    @BindView(R.id.send_message_button)
    Button mSendMessageButton;

    private DatabasePresenter presenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        initPresenter();
        initUI();
    }

    private void initPresenter() {
        presenter = new DatabasePresenterImpl(this, App.get().getFirebaseHelper());
    }

    private void initUI() {
        mSendMessageButton.setOnClickListener(this);
    }

    @Override
    public void showOnSuccessfullySentAMessageToFirebaseToast() {
        Toast.makeText(App.get(), R.string.success_message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showOnFailedToSendAMessageToFirebase(String errorMessage) {
        Toast.makeText(App.get(), String.format(Locale.getDefault(), getString(R.string.failed_operation_toast), errorMessage), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showSuccessfullyLoggedInToast() {
        Toast.makeText(App.get(), R.string.successfully_logged_in, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View view) {
        if (view == mSendMessageButton) {
            presenter.sendMessageToFirebase(mMessageEditText.getText().toString());
        }
    }
}