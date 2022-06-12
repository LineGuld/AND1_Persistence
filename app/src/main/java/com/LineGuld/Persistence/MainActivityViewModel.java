package com.LineGuld.Persistence;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

public class MainActivityViewModel extends AndroidViewModel {
    private final PlantRepository repository;

    public MainActivityViewModel(Application app) {
        super(app);
        repository = PlantRepository.getInstance(app);
    }

    public void addPlant(Plant plant)
    {
        repository.insert(plant);
    }

    public LiveData<List<Plant>> getPlants()
    {
        return repository.getAllPlants();
    }

    public void deleteAllPlants()
    {
        repository.deleteAllPlants();
    }

}
