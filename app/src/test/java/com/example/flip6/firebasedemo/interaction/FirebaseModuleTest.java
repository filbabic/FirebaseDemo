package com.example.flip6.firebasedemo.interaction;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings;
import com.google.firebase.storage.FirebaseStorage;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Map;

import static org.junit.Assert.*;

/**
 * Created by flip6 on 8.7.2016..
 */
public class FirebaseModuleTest {
    private FirebaseModule firebaseModule;

    @Mock
    private FirebaseRemoteConfigSettings firebaseRemoteConfigSettings;

    @Mock
    private Map<String, Object> defaultValues;

    @Mock
    private FirebaseRemoteConfig remoteConfig;

    @Mock
    private FirebaseStorage firebaseStorage;

    @Mock
    private FirebaseDatabase firebaseDatabase;

    @Mock
    private FirebaseAuth firebaseAuth;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        firebaseModule = new FirebaseModule();
    }
//
//    @Test
//    public void testProvideFirebaseDatabaseNotNull() throws Exception { // TODO: 8.7.2016. figure out how to mock firebaseApp
//        assertNotNull(firebaseModule.provideFirebaseDatabase());
//    }
//
//    @Test
//    public void testProvideFirebaseAuthNotNull() throws Exception {
//        assertNotNull(firebaseModule.provideFirebaseAuth());
//    }
//
//    @Test
//    public void testProvideFirebaseStorageNotNull() throws Exception {
//        assertNotNull(firebaseModule.provideFirebaseStorage());
//    }
//
//    @Test
//    public void testProvideFirebaseRemoteConfigNotNull() throws Exception {
//        assertNotNull(firebaseModule.provideRemoteConfig(firebaseRemoteConfigSettings, defaultValues));
//    }

    @Test
    public void testProvideFirebaseRemoteConfigSettingsNotNull() throws Exception {
        assertNotNull(firebaseModule.provideFirebaseRemoteConfigSettings());
    }

    @Test
    public void testProvideDefaultValuesNotNull() throws Exception {
        assertNotNull(firebaseModule.provideDefaultValues());
    }

    @Test
    public void testProvideFirebaseRemoteConfigInteractorNotNull() throws Exception {
        assertNotNull(firebaseModule.provideFirebaseRemoteConfigInteractor(remoteConfig));
    }

    @Test
    public void testProvideFirebaseStorageInteractorNotNull() throws Exception {
        assertNotNull(firebaseModule.provideFirebaseStorageInteractor(firebaseStorage));
    }

    @Test
    public void testProvideFirebaseDatabaseInteractorNotNull() throws Exception {
        assertNotNull(firebaseModule.provideFirebaseDatabaseInteractor(firebaseDatabase));
    }

    @Test
    public void testProvideFirebaseAuthenticationInteractorNotNull() throws Exception {
        assertNotNull(firebaseModule.provideFirebaseAuthenticationInteractor(firebaseAuth));
    }
}