package com.yuankai.keelungsightviewer.service;

import com.yuankai.keelungsightviewer.entity.Sight;
import com.yuankai.keelungsightviewer.model.KeelungSightsCrawler;
import com.yuankai.keelungsightviewer.repository.ListSightRepository;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class SightService  {

    private final ListSightRepository listSightRepository;
    @Autowired
    public SightService(
            @Qualifier("listSightRepository")ListSightRepository listSightRepository
    ) {
        this.listSightRepository = listSightRepository;
    }

    @PostConstruct
    public void init() throws IOException {
        listSightRepository.deleteAllSight();
        KeelungSightsCrawler crawler = new KeelungSightsCrawler();
        for(Sight sight: crawler.getAllSights()){
            sight.setPhotoUrl("https://images.pexels.com/photos/1107717/pexels-photo-1107717.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1");
            listSightRepository.insertSight(sight);
        }
    }

    public void checkSightValid(List<Sight> all){
        for(Sight s: all){
            if(s.getSightName().isEmpty()){
                s.setSightName(Sight.defaultSightName);
            }
            if(s.getZone().isEmpty()){
                s.setZone(Sight.defaultZone);
            }
            if(s.getCategory().isEmpty()){
                s.setCategory(Sight.defaultZone);
            }
            if(s.getPhotoUrl().isEmpty()){

            }

        }
    }

    public List<Sight> getSightByZone(String zone){
        List<Sight> sights = new ArrayList<>();
        for(Sight sight: listSightRepository.getAllSights()){
            if(sight.getZone().equals(zone)){
                sights.add(sight);
            }
        }
        return sights;
    }
}
