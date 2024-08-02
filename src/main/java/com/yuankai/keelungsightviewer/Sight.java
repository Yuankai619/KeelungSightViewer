package com.yuankai.keelungsightviewer;

import java.io.Serializable;

public class Sight implements Serializable {
    private String sightName;
    private String zone;
    private String category;
    private String photoUrl;
    private String description;
    private String address;
    final private String defaultSightName = "Null";
    final private String defaultZone = "Null";
    final private String defaultCategory = "Null";
    final private String defaultPhotoUrl = "https://images.pexels.com/photos/1107717/pexels-photo-1107717.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1";
    final private String defaultDescription = "Null";
    public Sight() {
        sightName = defaultSightName;
        zone = defaultZone;
        category = defaultCategory;
        photoUrl = defaultPhotoUrl;
        description = defaultDescription;
    }

    public void setSightName(String sightName) {
        this.sightName = sightName;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSightName() {
        return sightName;
    }

    public String getZone() {
        return zone;
    }

    public String getCategory() {
        return category;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public String getDescription() {
        return description;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "SightName: " + sightName +
                "\nZone: " + zone +
                "\nCategory: " + category +
                "\nPhotoURL:\n" + photoUrl +
                "\nDescription: " + description + "\n";
    }
}
