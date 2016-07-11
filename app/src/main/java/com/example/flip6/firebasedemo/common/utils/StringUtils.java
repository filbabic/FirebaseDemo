package com.example.flip6.firebasedemo.common.utils;

/**
 * Created by flip6 on 7.7.2016..
 */

public class StringUtils {
    public static boolean stringEmptyOrNull(String... strings) {
        for (String current : strings) {
            if (current == null || current.isEmpty() || current.trim().isEmpty()) {
                return true;
            }
        }
        return false;
    }
}