package com.example.flip6.firebasedemo.common.utils;

import com.example.flip6.firebasedemo.BuildConfig;

/**
 * Created by flip6 on 7.7.2016..
 */

public class StringUtils {
    public static boolean StringEmptyOrNull(String... strings) {
        for (String current : strings) {
            if (current == null || current.isEmpty() || current.trim().isEmpty()) {
                return true;
            }
        }
        return false;
    }

    public static void logError(Throwable throwable) {
        if (BuildConfig.DEBUG) {
            throwable.printStackTrace();
        }
    }
}