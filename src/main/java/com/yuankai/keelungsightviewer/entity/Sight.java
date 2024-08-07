package com.yuankai.keelungsightviewer.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Sight implements Serializable {
    private String sightName;
    private String zone;
    private String category;
    private String photoUrl;
    private String description;
    private String address;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sight sight = (Sight) o;
        return sightName.equals(sight.sightName);
    }

//    @Override
//    public String toString() {
//        return "SightName: " + sightName +
//                "\nZone: " + zone +
//                "\nCategory: " + category +
//                "\nPhotoURL:\n" + photoUrl +
//                "\nDescription: " + description + "\n";
//    }
}