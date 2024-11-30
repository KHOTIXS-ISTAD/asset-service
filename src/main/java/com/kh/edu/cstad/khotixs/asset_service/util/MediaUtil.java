package com.kh.edu.cstad.khotixs.asset_service.util;

public class MediaUtil {

    public static String extractExtension(String mediaName) {
        int lastDotIndex = mediaName.lastIndexOf(".");
        return mediaName.substring(lastDotIndex + 1);
    }

}
