package com.yuankai.keelungsightviewer.utility;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class ImageValidator {

    public static boolean isImageUrlValid(String imageUrl) {
        try {
            URL url = new URL(imageUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("HEAD");
            int responseCode = connection.getResponseCode();
            return (responseCode == HttpURLConnection.HTTP_OK);
        } catch (IOException e) {
            return false;
        }
    }
}