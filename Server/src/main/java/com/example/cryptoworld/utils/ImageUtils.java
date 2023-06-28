package com.example.cryptoworld.utils;

import java.util.Base64;

public class ImageUtils {
    public static String convertByteToBase64(byte[] imageData) {
        return Base64.getEncoder().encodeToString(imageData);
    }
}
