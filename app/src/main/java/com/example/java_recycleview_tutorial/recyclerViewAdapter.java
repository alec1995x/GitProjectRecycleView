package com.example.java_recycleview_tutorial;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class recyclerViewAdapter extends RecyclerView.Adapter<recyclerViewAdapter.myViewHolder> {
    Context context;
    ArrayList<carModel> carModels;

    public recyclerViewAdapter(Context context, ArrayList<carModel> carmodels) {
        this.context = context;
        this.carModels = carmodels;
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {
        holder.tv_carName.setText(carModels.get(position).getCar_name());
        holder.tv_carhp.setText(String.valueOf(carModels.get(position).getCar_hp()));
        holder.imageView.setImageResource(carModels.get(position).getCar_img());
    }

    @NonNull
    @Override
    //this is where I inflat the layout
    public recyclerViewAdapter.myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.main_recyclerview_row, parent, false);
        return new recyclerViewAdapter.myViewHolder(view);
    }



    @Override
    //how many rows to return to view
    public int getItemCount() {
        return carModels.size();
    }

    public static class myViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView tv_carName, tv_carhp;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageView);
            tv_carName = itemView.findViewById(R.id.tv_carbrand);
            tv_carhp = itemView.findViewById(R.id.tv_carhp);
        }
    }
}

