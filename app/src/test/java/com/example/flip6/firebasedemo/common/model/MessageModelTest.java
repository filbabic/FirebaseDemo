package com.example.flip6.firebasedemo.common.model;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by flip6 on 11.7.2016..
 */
public class MessageModelTest {
    private final String MESSAGE = "message";
    private final String AUTHOR = "author";
    private final String IMAGE_URL = "imageURL";


    @Test
    public void testObjectNotNull() throws Exception {
        assertNotNull(new MessageModel());
    }

    @Test
    public void testValidateReturnsTrue() throws Exception {
        MessageModel model = new MessageModel();
        model.setAuthor(AUTHOR);
        model.setAuthorImageURL(IMAGE_URL);
        model.setMessage(MESSAGE);
        assertTrue(model.validateModel());
    }

    @Test
    public void testValidateReturnsFalseDataIsEmpty() throws Exception {
        MessageModel model = new MessageModel();
        model.setMessage("  ");
        model.setAuthorImageURL("  ");
        model.setAuthor("  ");
        assertFalse(model.validateModel());
    }

    @Test
    public void testGetMessageNotNull() throws Exception {
        MessageModel model = new MessageModel(MESSAGE, null, null);
        assertNotNull(model.getMessage());
    }

    @Test
    public void testGetAuthorNotNull() throws Exception {
        MessageModel model = new MessageModel(null, AUTHOR, null);
        assertNotNull(model.getAuthor());
    }

    @Test
    public void testGetImageUrlNotNull() throws Exception {
        MessageModel model = new MessageModel(null, null, IMAGE_URL);
        assertNotNull(model.getAuthorImageURL());
    }
}