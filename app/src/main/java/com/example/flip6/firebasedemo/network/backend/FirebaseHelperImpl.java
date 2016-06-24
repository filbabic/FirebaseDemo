package com.example.flip6.firebasedemo.network.backend;

import android.support.annotation.NonNull;

import com.example.flip6.firebasedemo.constants.FirebaseConstants;
import com.example.flip6.firebasedemo.constants.Constants;
import com.example.flip6.firebasedemo.pojo.MessageModel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.crash.FirebaseCrash;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

/**
 * Created by flip6 on 16.6.2016..
 */
public class FirebaseHelperImpl implements FirebaseHelper {
    private final FirebaseAuth firebaseAuth;
    private final FirebaseDatabase firebaseDatabase;

    public FirebaseHelperImpl(FirebaseAuth firebaseAuth, FirebaseDatabase firebaseDatabase) {
        this.firebaseAuth = firebaseAuth;
        this.firebaseDatabase = firebaseDatabase;
    }

    @Override
    public void requestFromValidLink(final RequestListener<MessageModel> listener) {
        firebaseDatabase.getReference(FirebaseConstants.MESSAGE_REFERENCE).child(FirebaseConstants.TEST_MESSAGE_LOCATION).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                MessageModel model = dataSnapshot.getValue(MessageModel.class);
                listener.onSuccessfulRequest(model);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                FirebaseCrash.report(databaseError.toException());
                listener.onFailedRequest();
            }
        });
    }

    @Override
    public void requestFromInvalidLink(final RequestListener<MessageModel> listener) {
        firebaseDatabase.getReference(FirebaseConstants.USER_REFERENCE).child(FirebaseConstants.TEST_MESSAGE_LOCATION).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                MessageModel model = dataSnapshot.getValue(MessageModel.class);
                listener.onSuccessfulRequest(model);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                FirebaseCrash.report(databaseError.toException());
                listener.onFailedRequest();
            }
        });
    }

    @Override
    public void logTheUserIn(final String email, String password, final ResponseListener listener) {
        firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    FirebaseUser user = firebaseAuth.getCurrentUser();
                    if (user != null) {
                        if (user.getDisplayName() == null && email.equals(Constants.TEST_USER_EMAIL)) {
                            UserProfileChangeRequest request = new UserProfileChangeRequest.Builder().setDisplayName("test").build();
                            user.updateProfile(request);
                        }
                        listener.onSuccessfulAuthentication();
                    }
                } else {
                    listener.onFailedAuthentication(Constants.OPERATION_LOG_IN);
                }
            }
        });
    }

    @Override
    public void attemptToCreateNewUser(String email, String password, final ResponseListener listener) {
        firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    FirebaseUser user = firebaseAuth.getCurrentUser();
                    if (user != null) {
                        listener.onSuccessfulAuthentication();
                    }
                } else {
                    listener.onFailedAuthentication(Constants.OPERATION_REGISTER);
                }
            }
        });
    }

    @Override
    public String getCurrentUserDisplayName() {
        FirebaseUser user = firebaseAuth.getCurrentUser();
        if (user != null) {
            String userDisplayName = user.getDisplayName();
            if (userDisplayName != null) {
                return userDisplayName;
            }
        }
        return "N/A";
    }

    @Override
    public boolean checkIfUserIsOnline() {
        return firebaseAuth.getCurrentUser() != null;
    }

    @Override
    public void logTheTestUserOut() {
        firebaseAuth.signOut();
    }

    @Override
    public void changeUsernameForCurrentUser() {
        FirebaseUser user = firebaseAuth.getCurrentUser();
        if (user != null) {
            UserProfileChangeRequest request = new UserProfileChangeRequest.Builder().setDisplayName(Constants.TEST_USER).build();
            user.updateProfile(request);
        }
    }

    @Override
    public void sendMessageToFirebase(String messageToSend, ResponseListener responseListener) {
        FirebaseUser user = firebaseAuth.getCurrentUser();
        if (user != null && user.getDisplayName() != null) {
            MessageModel messageModel = new MessageModel(messageToSend, user.getDisplayName());
            firebaseDatabase.getReference(FirebaseConstants.MESSAGE_REFERENCE).push().setValue(messageModel);
            responseListener.onSuccessfulAuthentication();
        } else {
            responseListener.onFailedAuthentication(Constants.OPERATION_SEND_MESSAGE);
        }
    }
}