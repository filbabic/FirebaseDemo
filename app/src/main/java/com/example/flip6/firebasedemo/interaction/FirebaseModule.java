package com.example.flip6.firebasedemo.interaction;

import com.example.flip6.firebasedemo.BuildConfig;
import com.example.flip6.firebasedemo.common.utils.RemoteConfigUtils;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings;
import com.google.firebase.storage.FirebaseStorage;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by flip6 on 6.7.2016..
 */
@Module
public class FirebaseModule {
    @Singleton
    @Provides
    public FirebaseDatabase provideFirebaseDatabase() {
        FirebaseDatabase.getInstance().setPersistenceEnabled(true);
        return FirebaseDatabase.getInstance();
    }

    @Singleton
    @Provides
    public FirebaseAuth provideFirebaseAuth() {
        return FirebaseAuth.getInstance();
    }

    @Singleton
    @Provides
    public FirebaseStorage provideFirebaseStorage() {
        return FirebaseStorage.getInstance();
    }

    @Singleton
    @Provides
    public FirebaseRemoteConfigSettings provideFirebaseRemoteConfigSettings() {
        return new FirebaseRemoteConfigSettings.Builder()
                .setDeveloperModeEnabled(BuildConfig.DEBUG)
                .build();
    }

    @Singleton
    @Provides
    public FirebaseRemoteConfig provideRemoteConfig(FirebaseRemoteConfigSettings firebaseRemoteConfigSettings) {
        FirebaseRemoteConfig config = FirebaseRemoteConfig.getInstance();
        config.setDefaults(RemoteConfigUtils.getDefaultValues());
        config.setConfigSettings(firebaseRemoteConfigSettings);
        return config;
    }

    @Provides
    public FirebaseStorageInteractor provideFirebaseStorageInteractor(FirebaseStorage firebaseStorage) {
        return new FirebaseStorageInteractorImpl(firebaseStorage);
    }

    @Provides
    public FirebaseDatabaseInteractor provideFirebaseDatabaseInteractor(FirebaseDatabase firebaseDatabase) {
        return new FirebaseDatabaseInteractorImpl(firebaseDatabase);
    }
}