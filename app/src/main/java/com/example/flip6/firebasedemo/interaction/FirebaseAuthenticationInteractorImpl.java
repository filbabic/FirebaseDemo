package com.example.flip6.firebasedemo.interaction;

import android.support.annotation.NonNull;

import com.example.flip6.firebasedemo.common.ResponseListener;
import com.example.flip6.firebasedemo.ui.common.image.ImageHelper;
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
                if (task.isSuccessful() && firebaseAuth.getCurrentUser() != null) {
                    listener.onSuccessfulAuthentication();
                } else {
                    listener.onFailedAuthentication();
                }
            }
        });
    }

    @Override
    public void registerUser(String email, String password, final ResponseListener listener) {
        firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful() && firebaseAuth.getCurrentUser() != null) {
                    listener.onSuccessfulAuthentication();
                } else {
                    listener.onFailedAuthentication();
                }
            }
        });
    }

    @Override
    public void logTheUserOut() {
        firebaseAuth.signOut();
    }

    @Override
    public String getLoggedInUserDisplayName() {
        FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
        if (firebaseUser != null && firebaseUser.getDisplayName() != null) {
            return firebaseUser.getDisplayName();
        }
        return null;
    }

    @Override
    public void changeUserDisplayName(String usernameToSet) {
        FirebaseUser user = firebaseAuth.getCurrentUser();
        if (user != null) {
            UserProfileChangeRequest request = new UserProfileChangeRequest.Builder().setDisplayName(usernameToSet).build();
            user.updateProfile(request).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    //handle logic when successfully changed username
                }
            });
        }
    }

    @Override
    public void changeUserImageUrl(String imageUrl) {
        FirebaseUser user = firebaseAuth.getCurrentUser();
        if (user != null) {
            UserProfileChangeRequest request = new UserProfileChangeRequest.Builder().setPhotoUri(ImageHelper.getImageURIFromString(imageUrl)).build();
            user.updateProfile(request).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    //handle logic when successfully changed profile image
                }
            });
        }
    }

    @Override
    public String getLoggedInUserImageURL() {
        FirebaseUser user = firebaseAuth.getCurrentUser();
        if (user != null && user.getPhotoUrl() != null) {
            return user.getPhotoUrl().toString();
        }
        return null;
    }
}