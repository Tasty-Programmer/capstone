package com.obyte.alcohol;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.obyte.alcohol.Rest.DrinkData;

import java.util.ArrayList;

public class ViewAdepter extends RecyclerView.Adapter<ViewAdepter.ListItemHolder> {
    private ArrayList<DrinkData> drinkDataArrayList;


    public ViewAdepter(ArrayList<DrinkData> drinkDataArrayList) {
        this.drinkDataArrayList = drinkDataArrayList;
    }

    @NonNull
    @Override
    public ListItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.listitem, parent, false);
        return new ListItemHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ListItemHolder holder, int position) {
        DrinkData modal = drinkDataArrayList.get(position);

        holder.tvName.setText(modal.getName());
        holder.tvLevel.setText("도수 : " + modal.getLevel());
        holder.tvVolume.setText("규격 :" +modal.getVolume());
    }

    @Override
    public int getItemCount() {
        return drinkDataArrayList.size();
    }

    protected class ListItemHolder extends RecyclerView.ViewHolder {
        TextView tvName, tvLevel, tvVolume;

        public ListItemHolder(@NonNull View view) {
            super(view);
            tvName = view.findViewById(R.id.tvName);
            tvLevel = view.findViewById(R.id.tvLevel);
            tvVolume = view.findViewById(R.id.tvVolume);
        }
    }
}
