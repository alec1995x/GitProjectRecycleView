package com.example.java_recycleview_tutorial;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {



    ArrayList<carModel> carmodels = new ArrayList<>();
    int[] carImages = {R.drawable.ic_baseline_electric_car_24, R.drawable.ic_baseline_electric_car_25, R.drawable.ic_baseline_electric_car_26, R.drawable.ic_baseline_electric_car_27};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText et_carbrand = findViewById(R.id.ET_CarBrand);
        EditText et_carhp = findViewById(R.id.ET_CarHP);
        Button btn_add = findViewById(R.id.btn_add);

        transferCarInfoToArray();
        RecyclerView recyclerView = findViewById(R.id.mRecyclerView);
        recyclerViewAdapter adapter = new recyclerViewAdapter(this, carmodels);

        btn_add.setOnClickListener(view -> {
            carmodels.add(new carModel(et_carbrand.getText().toString(), Integer.parseInt(et_carhp.getText().toString()), R.drawable.ic_launcher_background));
            adapter.notifyDataSetChanged();
        });


        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    public void transferCarInfoToArray() {
        String [] carBrand = getResources().getStringArray(R.array.carBrands);
        int[] carHP = getResources().getIntArray(R.array.carHorsePower);


        for (int i = 0; i < carBrand.length; i++)
        {
            carmodels.add(new carModel(carBrand[i], carHP[i], carImages[i]));
        }

    }

}