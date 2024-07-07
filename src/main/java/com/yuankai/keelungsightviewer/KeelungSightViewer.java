package com.yuankai.keelungsightviewer;

import java.io.IOException;

public class KeelungSightViewer {
    public static void main(String[] args) {
        try {
            KeelungSightsCrawler keelungSightsCrawler = new KeelungSightsCrawler();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
