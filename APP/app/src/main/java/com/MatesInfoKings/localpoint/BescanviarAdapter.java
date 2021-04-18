package com.MatesInfoKings.localpoint;

import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

public class BescanviarAdapter extends RecyclerView.Adapter<BescanviarAdapter.ViewHolder>{

    BescanviarData[] bescanviarData;
    MainActivity context;

    public BescanviarAdapter(BescanviarData[] bescanviarData, MainActivity activity) {
        this.bescanviarData = bescanviarData;
        this.context = activity;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_layout_num,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final BescanviarData bescanviarDataList = bescanviarData[position];
        holder.BescanviarName.setText(bescanviarDataList.getBescanviarName());
        holder.BescanviarSubName.setText(bescanviarDataList.getBescanviarSubname());
        holder.BescanviarImage.setImageResource(bescanviarDataList.getBescanviarImage());
        holder.BescanviarPreu.setText(bescanviarDataList.getBescanviarPreu() + "\nPUNTS");

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            @Override
            public void onClick(View v) {
                builder.setTitle("Alerta!!");
                builder.setMessage("Vols bescanviar " + bescanviarDataList.getBescanviarPreu() + " punts a canvi de " + bescanviarDataList.getBescanviarName() + "?");
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
                        dialogInterface.dismiss();
                    }
                });
                builder.setPositiveButton("Sí", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
                        if (context.getPoints() < Integer.parseInt(bescanviarDataList.getBescanviarPreu())){
                            Toast.makeText(context,"No tens suficients punts", Toast.LENGTH_SHORT).show();
                        }else{
                            context.subPoints(Integer.parseInt(bescanviarDataList.getBescanviarPreu()));
                        }
                        dialogInterface.dismiss();
                    }
                })
                .show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return bescanviarData.length;
    }


    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView BescanviarImage;
        TextView BescanviarName;
        TextView BescanviarSubName;
        TextView BescanviarPreu;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            BescanviarImage = itemView.findViewById(R.id.iv_image);
            BescanviarName = itemView.findViewById(R.id.tv_title);
            BescanviarSubName = itemView.findViewById(R.id.tv_description);
            BescanviarPreu = itemView.findViewById(R.id.tv_price);
        }
    }
}
