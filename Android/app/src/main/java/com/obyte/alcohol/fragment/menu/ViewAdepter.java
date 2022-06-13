package com.obyte.alcohol.fragment.menu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.obyte.alcohol.R;
import com.obyte.alcohol.Rest.DrinkData;

import java.util.ArrayList;

public class ViewAdepter extends RecyclerView.Adapter<ViewAdepter.ListItemHolder> {
    private static ViewAdepter viewAdepter;
    private static ArrayList<DrinkData> drinkDataArrayList;
    private Context context;


    private ViewAdepter(Context context) {
        this.drinkDataArrayList = new ArrayList<>();
        this.context = context;
    }

    public static ViewAdepter getViewAdepter(Context context){
        if(viewAdepter == null){
            viewAdepter = new ViewAdepter(context);
        }

        return viewAdepter;
    }

    public static ArrayList<DrinkData> getAdepterList(){
        return drinkDataArrayList;
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

        holder.Item_Name.setText(modal.getName());
        holder.Item_Level.setText("도수 : " + modal.getLevel()+"%");
        holder.Item_Volume.setText("규격 :" +modal.getVolume());
        holder.Item_ingredient.setText("재료 : \n"+modal.getIngredients());
        holder.Item_Maker.setText(modal.getManufacturer());

        String urltest = "https://thesool.com/common/imageView.do?targetId=PR00000706&targetNm=PRODUCT";
        Glide.with(context).load(urltest).into(holder.Item_Image);
        //Glide.with(context).load(modal.getImageLink()).into(holder.Item_Image);
    }

    @Override
    public int getItemCount() {
        return drinkDataArrayList.size();
    }

    protected class ListItemHolder extends RecyclerView.ViewHolder {
        ImageView Item_Image;
        TextView Item_Name, Item_Level, Item_Volume, Item_ingredient, Item_Maker;

        public ListItemHolder(@NonNull View view) {
            super(view);
            Item_Image = view.findViewById(R.id.Item_Image);
            Item_Name = view.findViewById(R.id.Item_Name);
            Item_Level = view.findViewById(R.id.Item_Level);
            Item_Volume = view.findViewById(R.id.Item_Volume);
            Item_ingredient = view.findViewById(R.id.Item_ingredient);
            Item_Maker = view.findViewById(R.id.Item_Maker);
        }
    }
}
