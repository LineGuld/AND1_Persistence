package com.LineGuld.Persistence;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    MainActivityViewModel viewModel;
    EditText commonName, scienceName;
    TextView list;
    Button submit, delete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        commonName = findViewById(R.id.editTextCommonName);
        scienceName = findViewById(R.id.editTextTextScienceName);
        list = findViewById(R.id.textView);
        submit = findViewById(R.id.Submit);
        delete = findViewById(R.id.DeleteAll);

        viewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);

        viewModel.getPlants().observe(this, plants -> {
            if (!plants.isEmpty()) {
                list.setText("");
                for (Plant p : plants) {
                    list.append(p.getCommonName() + " | " + p.getScientificName() +"\n");
                }
            } else {
                list.setText("Empty");
            }
        });

        submit.setOnClickListener(v -> {
            addPlant(list);
        });

        delete.setOnClickListener(v -> {
            deleteAll(list);
        });

    }

    public void addPlant(View v) {
        viewModel.addPlant(new Plant(scienceName.getText().toString(),commonName.getText().toString()));

    }

    public void deleteAll(View v) {
        viewModel.deleteAllPlants();

    }
}