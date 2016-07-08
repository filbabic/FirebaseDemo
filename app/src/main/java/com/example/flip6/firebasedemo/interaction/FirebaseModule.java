package com.example.flip6.firebasedemo.interaction;

import com.example.flip6.firebasedemo.BuildConfig;
import com.example.flip6.firebasedemo.common.constants.Constants;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings;
import com.google.firebase.storage.FirebaseStorage;

import java.util.HashMap;
import java.util.Map;

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

    @Provides
    public FirebaseRemoteConfigSettings provideFirebaseRemoteConfigSettings() {
        return new FirebaseRemoteConfigSettings.Builder()
                .setDeveloperModeEnabled(BuildConfig.DEBUG)
                .build();
    }

    @Provides
    public Map<String, Object> provideDefaultValues() {
        Map<String, Object> defaults = new HashMap<>();
        defaults.put(Constants.IS_ON_DISCOUNT, false);
        defaults.put(Constants.DISCOUNT_AMOUNT, 0);
        return defaults;
    }

    @Singleton
    @Provides
    public FirebaseRemoteConfig provideRemoteConfig(FirebaseRemoteConfigSettings firebaseRemoteConfigSettings, Map<String, Object> defaultValues) {
        FirebaseRemoteConfig config = FirebaseRemoteConfig.getInstance();
        config.setDefaults(defaultValues);
        config.setConfigSettings(firebaseRemoteConfigSettings);
        return config;
    }

    @Provides
    public FirebaseRemoteConfigInteractor provideFirebaseRemoteConfigInteractor(FirebaseRemoteConfig firebaseRemoteConfig) {
        return new FirebaseRemoteConfigInteractorImpl(firebaseRemoteConfig);
    }

    @Provides
    public FirebaseStorageInteractor provideFirebaseStorageInteractor(FirebaseStorage firebaseStorage) {
        return new FirebaseStorageInteractorImpl(firebaseStorage);
    }

    @Provides
    public FirebaseDatabaseInteractor provideFirebaseDatabaseInteractor(FirebaseDatabase firebaseDatabase) {
        return new FirebaseDatabaseInteractorImpl(firebaseDatabase);
    }

    @Provides
    public FirebaseAuthenticationInteractor provideFirebaseAuthenticationInteractor(FirebaseAuth firebaseAuth) {
        return new FirebaseAuthenticationInteractorImpl(firebaseAuth);
    }
}