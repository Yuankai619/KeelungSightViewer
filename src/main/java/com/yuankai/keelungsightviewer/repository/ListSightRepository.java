package com.yuankai.keelungsightviewer.repository;

import com.yuankai.keelungsightviewer.entity.Sight;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ListSightRepository implements ISightRepository {
    private static final List<Sight> sights = new ArrayList<>();

    @Override
    public List<Sight> getAllSights() {
        return sights;
    }

    @Override
    public void insertSight(Sight sight) {
        if(!sights.contains(sight)) {
            sights.add(sight);
        }
    }

    @Override
    public void deleteAllSight(){
        sights.clear();
    }

}
