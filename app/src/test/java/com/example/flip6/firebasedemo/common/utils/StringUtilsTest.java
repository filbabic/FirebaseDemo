package com.example.flip6.firebasedemo.common.utils;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by flip6 on 11.7.2016..
 */
public class StringUtilsTest {
    private final String VALID_STRING = "valid";

    @Test
    public void testStringUtilsNotNull() throws Exception {
        assertNotNull(new StringUtils());
    }

    @Test
    public void testStringEmptyReturnsTrue() throws Exception {
        assertTrue(StringUtils.stringEmptyOrNull(""));
    }

    @Test
    public void testStringNullReturnsTrue() throws Exception {
        assertTrue(StringUtils.stringEmptyOrNull("  "));
    }

    @Test
    public void testStringEmptyAfterTrimReturnsTrue() throws Exception {
        assertTrue(StringUtils.stringEmptyOrNull("  "));
    }

    @Test
    public void testStringEmptyOrNullReturnsFalse() throws Exception {
        assertFalse(StringUtils.stringEmptyOrNull(VALID_STRING));
    }
}