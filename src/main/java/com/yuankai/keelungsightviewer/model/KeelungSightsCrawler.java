package com.yuankai.keelungsightviewer.model;

import com.yuankai.keelungsightviewer.entity.Sight;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.*;

@Slf4j
public class KeelungSightsCrawler {
    private final Map<String,Sight[]> items = new HashMap<>();
    private final List<Sight> sights = new ArrayList<>();
    public KeelungSightsCrawler() throws IOException {
        String docUrl = "https://www.travelking.com.tw/tourguide/taiwan/keelungcity/";
        Document doc = Jsoup.connect(docUrl).get();
        Element guidePoint = Objects.requireNonNull(doc.select("div#guide-point.tourgudes.fold").first());
        Elements zones = Objects.requireNonNull(guidePoint.select("h4"));

        for (Element z : zones) {
            log.info("已爬取 "+z.text());
            Elements sitghtHrefs = Objects.requireNonNull(z.nextElementSibling()).select("li a");
            Sight[] sightArray = new Sight[sitghtHrefs.size()];
            int i = 0;
            for (Element href : sitghtHrefs) {
                String detailUrl = "https://www.travelking.com.tw" + href.attr("href");
                Sight sight = getSightDetails(detailUrl,z.text());
                sightArray[i++] = sight;
                sights.add(sight);
            }
            items.put(z.text(), sightArray);
        }

    }
    private Sight getSightDetails(String url,String zone) throws IOException {
        Document doc = Jsoup.connect(url).get();
        Element pointArea = Objects.requireNonNull( doc.select("div#point_area").first());
        String sightName = pointArea.select("meta[itemprop=name]").attr("content");
        String category = doc.select("cite .point_type strong").text();
        String address = pointArea.select("meta[itemprop=address]").attr("content");
        String photoUrl = pointArea.select("meta[itemprop=image]").attr("content");
        Elements descriptionElements = pointArea.getElementsByAttributeValue("property", "dc:description");

        String description = Objects.requireNonNull(descriptionElements.first()).text();
        int lastPeriodIndex = description.lastIndexOf('。');
        if (lastPeriodIndex != -1) {
            description = description.substring(0, lastPeriodIndex + 1).trim();
        }
        return new Sight(sightName,zone,category,photoUrl,description,address);
    }
    public Sight[] getItemByZone(String zoneName){
        if(zoneName.charAt(zoneName.length()-1)!='區'){
            zoneName+="區";
        }
        return items.get(zoneName);
    }
    public List<Sight> getAllSights(){
        return sights;
    }
}