package com.example.flip6.firebasedemo.common.model;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by flip6 on 11.7.2016..
 */
public class UserModelTest {
    private final String VALID_USERNAME = "username";

    @Test
    public void testObjectNotNull() throws Exception {
        assertNotNull(new UserModel());
    }

    @Test
    public void testValidateReturnsTrue() throws Exception {
        UserModel model = new UserModel(VALID_USERNAME);
        assertTrue(model.validateModel());
    }

    @Test
    public void testValidateReturnsFalse() throws Exception {
        UserModel model = new UserModel();
        model.setUserDisplayName("  ");
        assertFalse(model.validateModel());
    }

    @Test
    public void testGetUsernameNotNull() throws Exception {
        UserModel model = new UserModel(VALID_USERNAME);
        assertNotNull(model.getUserDisplayName());
    }
}