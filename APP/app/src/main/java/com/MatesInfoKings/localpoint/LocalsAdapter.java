package com.MatesInfoKings.localpoint;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class LocalsAdapter extends RecyclerView.Adapter<LocalsAdapter.ViewHolder>{

    LocalsData[] localsData;
    Context context;

    public LocalsAdapter(LocalsData[] localsData, MainActivity activity) {
        this.localsData = localsData;
        this.context = activity;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_layout,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);


        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final LocalsData localsDataList = localsData[position];
        holder.LocalsName.setText(localsDataList.getBescanviarName());
        holder.LocalsSubName.setText(localsDataList.getBescanviarSubname());
        holder.LocalsImage.setImageResource(localsDataList.getBescanviarImage());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,localsDataList.getBescanviarName(), Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return localsData.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView LocalsImage;
        TextView LocalsName;
        TextView LocalsSubName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            LocalsImage = itemView.findViewById(R.id.iv_image);
            LocalsName = itemView.findViewById(R.id.tv_title);
            LocalsSubName = itemView.findViewById(R.id.tv_description);
        }
    }
}
