package com.example.java_recycleview_tutorial;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<carModel> carmodels = new ArrayList<>();
    int[] carImages = {R.drawable.ic_baseline_electric_car_24, R.drawable.ic_baseline_electric_car_25, R.drawable.ic_baseline_electric_car_26, R.drawable.ic_baseline_electric_car_27};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        transferCarInfoToArray();
        RecyclerView recyclerView = findViewById(R.id.mRecyclerView);

        recyclerViewAdapter adapter = new recyclerViewAdapter(this, carmodels);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    private void transferCarInfoToArray() {
        String[] carBrand = getResources().getStringArray(R.array.carBrands);
        int[] carHP = getResources().getIntArray(R.array.carHorsePower);


        for (int i = 0; i < carBrand.length; i++)
        {
            carmodels.add(new carModel(carBrand[i], carHP[i], carImages[i]));
        }

    }
}