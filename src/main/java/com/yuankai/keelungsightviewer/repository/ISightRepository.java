package com.yuankai.keelungsightviewer.repository;

import com.yuankai.keelungsightviewer.entity.Sight;

import java.util.List;

public interface ISightRepository {
    List<Sight> getAllSights();
    void insertSight(Sight sight);
    void deleteAllSight();
}
