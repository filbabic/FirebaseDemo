package com.example.flip6.firebasedemo.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by flip6 on 19.6.2016..
 */

public class RemoteConfigUtils {
    public static Map<String, Object> getDefaultValues() {
        Map<String, Object> defaults = new HashMap<>();
        defaults.put("is_on_discount", false);
        defaults.put("discount_amount", 0);
        return defaults;
    }
}