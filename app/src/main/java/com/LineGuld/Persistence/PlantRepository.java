package com.LineGuld.Persistence;

import android.app.Application;
import android.content.Context;

import androidx.lifecycle.LiveData;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PlantRepository {

    private static PlantRepository instance;
    private final PlantDao plantDao;
    private final LiveData<List<Plant>> allPlants;
    private final ExecutorService executorService;


    private PlantRepository(Application application){
        PlantDatabase database = PlantDatabase.getInstance(application);
        plantDao = database.plantDao();
        allPlants = plantDao.getAllPlants();
        executorService = Executors.newFixedThreadPool(2);
    }

    public static synchronized PlantRepository getInstance(Application application){
        if(instance == null)
            instance = new PlantRepository(application);

        return instance;
    }

    public LiveData<List<Plant>> getAllPlants(){
        return allPlants;
    }

    public void insert(Plant plant) {
        executorService.execute(() -> plantDao.addPlant(plant));
    }

    public void deleteAllPlants(){
        executorService.execute(this::deleteAllPlants);
    }
}
