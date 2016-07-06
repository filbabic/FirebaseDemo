package com.example.flip6.firebasedemo.interaction;

import android.support.annotation.NonNull;

import com.example.flip6.firebasedemo.common.ResponseListener;
import com.example.flip6.firebasedemo.common.constants.Constants;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;

/**
 * Created by flip6 on 6.7.2016..
 */

public class FirebaseAuthenticationInteractorImpl implements FirebaseAuthenticationInteractor {
    private final FirebaseAuth firebaseAuth;

    public FirebaseAuthenticationInteractorImpl(FirebaseAuth firebaseAuth) {
        this.firebaseAuth = firebaseAuth;
    }

    @Override
    public void logTheUserIn(String email, String password, final ResponseListener listener) {
        firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    if (firebaseAuth.getCurrentUser() != null) {
                        listener.onSuccessfulAuthentication();
                    }
                } else {
                    listener.onFailedAuthentication(Constants.OPERATION_LOG_IN);
                }
            }
        });
    }

    @Override
    public void registerUser(String email, String password, final ResponseListener listener) {
        firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    if (firebaseAuth.getCurrentUser() != null) {
                        listener.onSuccessfulAuthentication();
                    }
                } else {
                    listener.onFailedAuthentication(Constants.OPERATION_REGISTER);
                }
            }
        });
    }

    @Override
    public void logTheUserOut() {
        firebaseAuth.signOut();
    }

    @Override
    public boolean isUserOnline() {
        return firebaseAuth.getCurrentUser() != null;
    }

    @Override
    public String getLoggedInUserDisplayName() {
        if (firebaseAuth.getCurrentUser() != null) {
            return firebaseAuth.getCurrentUser().getDisplayName();
        }
        return "N/A"; //not yet set
    }

    @Override
    public void changeCurrentUserDisplayName(String usernameToSet) {
        FirebaseUser user = firebaseAuth.getCurrentUser();
        if (user != null) {
            UserProfileChangeRequest request = new UserProfileChangeRequest.Builder().setDisplayName(usernameToSet).build();
            user.updateProfile(request);
        }
    }
}