package com.obyte.alcohol;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.obyte.alcohol.Rest.DrinkData;

import java.util.ArrayList;

public class ViewAdepter extends RecyclerView.Adapter<ViewAdepter.ListItemHolder> {
    private ArrayList<DrinkData> drinkDataArrayList;
    private Context context;


    public ViewAdepter(ArrayList<DrinkData> drinkDataArrayList, Context context) {
        this.drinkDataArrayList = drinkDataArrayList;
        this.context = context;
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

        String urlMin = "https://www.thesool.com/common/imageView.do?targetId=PR00000412&targetNm=PRODUCT";
        String urlMax = "https://www.thesool.com/common/imageView.do?targetId=PR00000434&targetNm=PRODUCT";
        Glide.with(context).load(urlMax).into(holder.ivImage);
    }

    @Override
    public int getItemCount() {
        return drinkDataArrayList.size();
    }

    protected class ListItemHolder extends RecyclerView.ViewHolder {
        ImageView ivImage;
        TextView tvName, tvLevel, tvVolume;

        public ListItemHolder(@NonNull View view) {
            super(view);
            ivImage = view.findViewById(R.id.ivImage);
            tvName = view.findViewById(R.id.tvName);
            tvLevel = view.findViewById(R.id.tvLevel);
            tvVolume = view.findViewById(R.id.tvVolume);
        }
    }
}
