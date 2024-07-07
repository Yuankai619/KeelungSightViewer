package com.yuankai.keelungsightviewer;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class KeelungSightsCrawler {
    static String docUrl = "https://www.travelking.com.tw/tourguide/taiwan/keelungcity/";
    static Document doc;
    static Elements zones;
    static Map<String,Sight[]> items = new HashMap<>();
    public KeelungSightsCrawler() throws IOException {
        System.out.println("開始爬取");
        doc = Jsoup.connect(docUrl).get();
//        System.out.println(doc);
        Element guidePoint = doc.select("div#guide-point.tourgudes.fold").first();
        if(guidePoint != null) {
            zones = guidePoint.select("h4");
            for (Element z : zones) {
                System.out.println(z.text());
                Elements sitghtHrefs = Objects.requireNonNull(z.nextElementSibling()).select("li a");
                Sight[] sightArray = new Sight[sitghtHrefs.size()];
                int i = 0;
                for (Element href : sitghtHrefs) {
                    String detailUrl = "https://www.travelking.com.tw" + href.attr("href");
                    Sight sight = getSightDetails(detailUrl);
                    sight.setZone(z.text());
                    sightArray[i++] = sight;
                }
                items.put(z.text(), sightArray);
            }
        }
        System.out.println(zones);
//        Element root = doc.
    }
    private Sight getSightDetails(String url) {
        Sight sight = new Sight();
        try {
            Document doc = Jsoup.connect(url).get();
            Element pointArea = doc.select("div#point_area").first();
            if (pointArea != null) {
                String sightName = pointArea.select("meta[itemprop=name]").attr("content");
                String category = doc.select("cite .point_type strong").text();
                String address = pointArea.select("meta[itemprop=address]").attr("content");
                String photoURL = pointArea.select("meta[itemprop=image]").attr("content");
                Elements descriptionElements = pointArea.getElementsByAttributeValue("property", "dc:description");

                String description;
                description = Objects.requireNonNull(descriptionElements.first()).text();
                int lastPeriodIndex = description.lastIndexOf('。');
                if (lastPeriodIndex != -1) {
                    description = description.substring(0, lastPeriodIndex + 1).trim();
                }
//                description = description.replaceAll("。", "。\n");

                System.out.println(sightName);
                System.out.println(category);
                System.out.println(address);
                System.out.println(photoURL);
                System.out.println(description);
                sight.setSightName(sightName);
                sight.setCategory(category);
                sight.setAddress(address);
                sight.setPhotoUrl(photoURL);
                sight.setDescription(description);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sight;
    }
    public static Sight[] getItem(String zoneName){
        return items.get(zoneName);
    }
}
