package com.yuankai.keelungsightviewer.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "sight")
public class Sight implements Serializable {
    public static final String defaultSightName = "Null";
    public static final String defaultZone = "Null";
    public static final String defaultCategory = "Null";
    public static final String defaultPhotoUrl = "https://images.pexels.com/photos/1107717/pexels-photo-1107717.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1";
    public static final String defaultDescription = "Null";
    public static final String defaultAddress = "Null";

    @Id
    private String id;
    private String sightName;
    private String zone;
    private String category;
    private String photoUrl;
    private String description;
    private String address;

    public static Sight getDefaultSight() {
        return new Sight(null,defaultSightName,defaultZone,defaultCategory,defaultPhotoUrl,defaultDescription,defaultAddress);
    }
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Sight sight = (Sight) o;
//        return sightName.equals(sight.sightName);
//    }

//    @Override
//    public String toString() {
//        return "SightName: " + sightName +
//                "\nZone: " + zone +
//                "\nCategory: " + category +
//                "\nPhotoURL:\n" + photoUrl +
//                "\nDescription: " + description + "\n";
//    }
}