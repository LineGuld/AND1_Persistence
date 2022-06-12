package com.LineGuld.Persistence;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "plant_table")
public class Plant {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String scientificName;
    private String commonName;

    public Plant(String scientificName, String commonName) {
        this.scientificName = scientificName;
        this.commonName = commonName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getScientificName() {
        return scientificName;
    }

    public void setScientificName(String scientificName) {
        this.scientificName = scientificName;
    }

    public String getCommonName() {
        return commonName;
    }

    public void setCommonName(String commonName) {
        this.commonName = commonName;
    }

}
