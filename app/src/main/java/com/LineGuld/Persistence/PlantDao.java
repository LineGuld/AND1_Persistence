package com.LineGuld.Persistence;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface PlantDao {

    @Insert
    void addPlant(Plant plant);

    @Update
    void update(Plant plant);

    @Delete
    void delete(Plant plant);

    @Query("DELETE FROM plant_table")
    void deleteAllPlants();

    @Query("SELECT * FROM plant_table ORDER BY commonName")
    LiveData<List<Plant>> getAllPlants();
}
