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
    Context context;

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
            AlertDialog.Builder builder = new AlertDialog.Builder(
                    context
            );
            //builder.setTitle("Resultat Escanejat");
            @Override
            public void onClick(View v) {
                //builder.setMessage("Vols bescanviar " + bescanviarDataList.getBescanviar);
                builder.setMessage("Hello");
                builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
                        dialogInterface.dismiss();
                    }
                });
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
