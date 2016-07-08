package com.example.flip6.firebasedemo.ui.common.image;

import android.graphics.Bitmap;

import java.io.ByteArrayOutputStream;

/**
 * Created by flip6 on 7.7.2016..
 */

public class ImageHelper {
    public static byte[] getImageByteArray(Bitmap bitmap) {
        if (bitmap != null) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
            return byteArrayOutputStream.toByteArray();
        }
        return null;
    }
}