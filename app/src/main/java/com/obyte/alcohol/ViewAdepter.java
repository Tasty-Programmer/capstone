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
import java.util.List;

public class ViewAdepter extends RecyclerView.Adapter {
    private ArrayList<DrinkData> messageModalArrayList;
    private Context context;

    public ViewAdepter(ArrayList<DrinkData> messageModalArrayList, Context context) {
        super();
        this.messageModalArrayList = messageModalArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.listitem, parent, false);
        return new ListItemHolder(view);

    }

    //modal에 저장된 입력자를 판단하여 알맞은 메세지 박스에 표시
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        DrinkData modal = messageModalArrayList.get(position);

        ((ListItemHolder) holder).tvName.setText(modal.getName());
        ((ListItemHolder) holder).tvLevel.setText(modal.getLevel());
        ((ListItemHolder) holder).tvVolume.setText(modal.getVolume());

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    private class ListItemHolder extends RecyclerView.ViewHolder {
        TextView tvName, tvLevel, tvVolume;

        public ListItemHolder(@NonNull View view) {
            super(view);
            tvName = view.findViewById(R.id.tvName);
            tvLevel = view.findViewById(R.id.tvLevel);
            tvVolume = view.findViewById(R.id.tvVolume);
        }
    }
}
