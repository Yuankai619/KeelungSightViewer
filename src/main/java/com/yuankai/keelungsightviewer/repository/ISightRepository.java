package com.yuankai.keelungsightviewer.repository;

import com.yuankai.keelungsightviewer.entity.Sight;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ISightRepository extends MongoRepository<Sight, String> {
    List<Sight> findByZone(String zone);
    List<Sight> findByCategory(String category);
    void deleteBySightName(String sightName);
}
