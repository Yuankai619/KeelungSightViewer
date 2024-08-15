package com.yuankai.keelungsightviewer.service;

import com.yuankai.keelungsightviewer.entity.Sight;
import com.yuankai.keelungsightviewer.model.KeelungSightsCrawler;
import com.yuankai.keelungsightviewer.repository.ISightRepository;
import com.yuankai.keelungsightviewer.utility.ImageValidator;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class SightService  {

    private final ISightRepository sightRepository;

    @Autowired
    public SightService(
            ISightRepository sightRepository
    ) {
        this.sightRepository = sightRepository;
    }

    @PostConstruct
    public void init() throws IOException {
        sightRepository.deleteAll();
        KeelungSightsCrawler crawler = new KeelungSightsCrawler();
        for(Sight sight: crawler.getAllSights()){
            if(!ImageValidator.isImageUrlValid(sight.getPhotoUrl())){
                sight.setPhotoUrl("https://images.pexels.com/photos/1107717/pexels-photo-1107717.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1");
            }
            sightRepository.insert(sight);
        }
    }

    public List<Sight> getSightByZone(String zone){
        return sightRepository.findByZone(zone);
    }

    public List<Sight> getSightByCategory(String category){
        return sightRepository.findByCategory(category);
    }

    public void deleteBySightName(String sightName){
        sightRepository.deleteBySightName(sightName);
    }

    public void insertNullSight(){
        sightRepository.insert(Sight.getDefaultSight());
    }
}
