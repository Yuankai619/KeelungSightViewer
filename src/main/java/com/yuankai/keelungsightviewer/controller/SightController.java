package com.yuankai.keelungsightviewer.controller;

import com.yuankai.keelungsightviewer.entity.Sight;
import com.yuankai.keelungsightviewer.service.SightService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
        var sights = sightService.getSightByZone(zone);
        for(var sight : sights) {
            log.info(sight.toString());
        }
        if(sights.isEmpty())
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(sights);
    }
}
