package com.example.flip6.firebasedemo;

import android.app.Application;

import com.example.flip6.firebasedemo.network.backend.FirebaseHelper;
import com.example.flip6.firebasedemo.network.backend.FirebaseHelperImpl;
import com.example.flip6.firebasedemo.network.backend.FirebaseStorageHelper;
import com.example.flip6.firebasedemo.network.backend.FirebaseStorageHelperImpl;
import com.example.flip6.firebasedemo.network.remote.RemoteConfigHelper;
import com.example.flip6.firebasedemo.network.remote.RemoteConfigHelperImpl;
import com.example.flip6.firebasedemo.utils.RemoteConfigUtils;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings;
import com.google.firebase.storage.FirebaseStorage;

/**
 * Created by flip6 on 16.6.2016..
 */
public class App extends Application {
    private static App sInstance;

    private FirebaseHelper firebaseHelper;
    private RemoteConfigHelper remoteConfigHelper;
    private FirebaseStorageHelper firebaseStorageHelper;

    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;
        if (!FirebaseApp.getApps(this).isEmpty()) {
            FirebaseDatabase.getInstance().setPersistenceEnabled(true);
            FirebaseAuth auth = FirebaseAuth.getInstance();
            FirebaseDatabase database = FirebaseDatabase.getInstance();
            firebaseHelper = new FirebaseHelperImpl(auth, database);
            FirebaseRemoteConfig mRemoteConfig = FirebaseRemoteConfig.getInstance();
            FirebaseRemoteConfigSettings configSettings =
                    new FirebaseRemoteConfigSettings.Builder()
                            .setDeveloperModeEnabled(BuildConfig.DEBUG)
                            .build();
            mRemoteConfig.setConfigSettings(configSettings);
            mRemoteConfig.setDefaults(RemoteConfigUtils.getDefaultValues());
            remoteConfigHelper = new RemoteConfigHelperImpl(mRemoteConfig);
            FirebaseStorage firebaseStorage = FirebaseStorage.getInstance();
            firebaseStorageHelper = new FirebaseStorageHelperImpl(firebaseStorage);
        }
    }

    public static App get() {
        return sInstance;
    }

    public FirebaseHelper getFirebaseHelper() {
        return firebaseHelper;
    }

    public RemoteConfigHelper getRemoteConfig() {
        return remoteConfigHelper;
    }

    public FirebaseStorageHelper getFirebaseStorageHelper() {
        return firebaseStorageHelper;
    }
}