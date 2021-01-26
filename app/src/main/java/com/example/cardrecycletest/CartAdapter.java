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
import androidx.recyclerview.widget.RecyclerView;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.ViewHolder>{
    private LayoutInflater layoutInflater;
    private List<Food> data;




    CartAdapter(Context context, List<Food> data) {

        this.layoutInflater = LayoutInflater.from(context);
        this.data = data;


    }






    @NonNull
    @Override
    public CartAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = layoutInflater.inflate(R.layout.card, parent, false);
        CartAdapter.ViewHolder viewHolder = new CartAdapter.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final CartAdapter.ViewHolder holder, final int i) {

        holder.title.setText(data.get(i).getName());
        holder.descr.setText(data.get(i).getDescr());

        Picasso.get().load(data.get(i).getImg()).into(holder.img);
        holder.btdel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data.remove(i);
                MainActivity.cart.remove(i);
                notifyDataSetChanged();
                CartActivity.calcPrice();
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
        Button btdel;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.cardtitle);
            descr = itemView.findViewById(R.id.carddescr);
            img = itemView.findViewById(R.id.card_img);

            btdel = itemView.findViewById(R.id.btdel);

        }


    }
}
