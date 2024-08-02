package com.yuankai.keelungsightviewer;

import java.io.IOException;

public class KeelungSightViewer {
    public static void main(String[] args) {
        try {
            KeelungSightsCrawler crawler = new KeelungSightsCrawler();
            Sight []sights = crawler.getItem("暖暖");
            for(Sight s: sights){
                System.out.println(s);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }catch (NullPointerException e){
            System.out.println("can't find the area");
            e.getMessage();
        }
    }
}
