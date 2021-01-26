package com.example.cardrecycletest;



import android.content.Context;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.squareup.picasso.Picasso;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    private LayoutInflater layoutInflater;
    private List<Food> data;
    private RecyclerOnItemClickInterface recyclerOnItemClickInterface;



    Adapter(Context context, List<Food> data) {

        this.layoutInflater = LayoutInflater.from(context);
        this.data = data;


    }



    Adapter(Context context, List<Food> data, RecyclerOnItemClickInterface recyclerOnItemClickInterface) {

        this.layoutInflater = LayoutInflater.from(context);
        this.data = data;
        this.recyclerOnItemClickInterface = recyclerOnItemClickInterface;

    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = layoutInflater.inflate(R.layout.card2, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int i) {

        holder.title.setText(data.get(i).getName());
        holder.descr.setText(data.get(i).getDescr());
        holder.price.setText(data.get(i).getPrice());
        Picasso.get().load(data.get(i).getImg()).into(holder.img);
        holder.bt_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast toast = Toast.makeText(v.getContext(), holder.getAdapterPosition() + "Is clicked", Toast.LENGTH_SHORT);
//                toast.show();
                recyclerOnItemClickInterface.OnAddClick(holder.getAdapterPosition());
            }
        });


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                recyclerOnItemClickInterface.OnItemClick(holder.getAdapterPosition(), holder.title, holder.descr, holder.img);

              }
        });

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView title, descr, price;
        ImageView img;
        Button bt_add;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.cardtitle);
            descr = itemView.findViewById(R.id.carddescr);
            img = itemView.findViewById(R.id.card_img);
            price = itemView.findViewById(R.id.price);
            bt_add = itemView.findViewById(R.id.bt_add);

        }


    }
}
