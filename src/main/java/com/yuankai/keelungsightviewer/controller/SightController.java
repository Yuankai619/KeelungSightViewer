package com.yuankai.keelungsightviewer.controller;

import com.yuankai.keelungsightviewer.entity.Sight;
import com.yuankai.keelungsightviewer.service.SightService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class SightController {
    private final SightService sightService;

    @Autowired
    public SightController(SightService sightService) {
        this.sightService = sightService;
    }

    @GetMapping("/SightAPI")
    public ResponseEntity<List<Sight>> getSights(
            @RequestParam(value = "zone", required = true) String zone
    )throws Exception{
        if(zone.charAt(zone.length()-1)!='區'){
            zone+="區";
        }

        List<Sight> sights = null;
        try {
            sights = sightService.getSightByZone(zone);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new RuntimeException(e);
        }
        for(var sight : sights) {
            log.info(sight.toString());
        }
        if(sights.isEmpty())
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(sights);
    }

    @GetMapping("/SightCategoryAPI")
    public ResponseEntity<List<Sight>> getSightByCategory(
            @RequestParam(value = "category", required = true) String category
    )throws Exception{
        List<Sight> sights = null;
        try {
            sights = sightService.getSightByCategory(category);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new RuntimeException(e);
        }
        for(var sight : sights) {
            log.info(sight.toString());
        }
        if(sights.isEmpty())
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(sights);
    }

    @PostMapping("/InsertTestSight")
    public ResponseEntity<Void> InsertTestSight(){
        sightService.insertNullSight();
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("ClearTestSight")
    public ResponseEntity<Void> ClearTestSight(){
        sightService.deleteBySightName("Null");
        return ResponseEntity.noContent().build();
    }
}
