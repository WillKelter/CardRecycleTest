package com.example.cardrecycletest;

import android.annotation.SuppressLint;
import android.app.ActivityOptions;
import android.content.Intent;

import android.os.Build;
import android.os.Parcelable;
import android.util.Pair;
import android.view.View;

import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;



public class MainActivity extends AppCompatActivity implements RecyclerOnItemClickInterface {

    TextView title;
    TextView descr;
    ImageView img;
    RecyclerView rv;
    Adapter adapter;
    ArrayList<Food> items;
    static ArrayList<Food> cart;
   // TextView cnt;
    FloatingActionButton fab;
    NestedScrollView nv;
   // int count;



    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        items = new ArrayList<>();
        cart = new ArrayList<>();
        items.add(new Food("Ajs", "Ees", "300", R.drawable.r1));
        items.add(new Food("As", "ess", "150", R.drawable.r2));
        items.add(new Food("s", "Eees", "35", R.drawable.r3));
        items.add(new Food("Ss", "Eess", "367", R.drawable.r4));
        items.add(new Food("Sjjs", "Eess", "36", R.drawable.r1));
        items.add(new Food("Sggs", "Eess", "35", R.drawable.r3));
        items.add(new Food("Ss2", "Eess", "35", R.drawable.r4));

       // count = 0;

        title = findViewById(R.id.cardtitle);
        descr = findViewById(R.id.carddescr);
        img = findViewById(R.id.card_img);
      //  cnt = findViewById(R.id.count);
        fab = findViewById(R.id.fab);



        rv = findViewById(R.id.rv);
        rv.setLayoutManager(new LinearLayoutManager(this));
        adapter = new Adapter(this, items, this);
        rv.setAdapter(adapter);


        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cartIntent = new Intent(v.getContext(), CartActivity.class);

                v.getContext().startActivity(cartIntent);

            }
        });
    }



    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void OnItemClick(int position, TextView title, TextView descr, ImageView img) {

        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra("name", items.get(position).getName());
        intent.putExtra("descr", items.get(position).getDescr());
        intent.putExtra("img", items.get(position).getImg());

      Pair pairs[] = new Pair[3];
       pairs[0] = new Pair<View, String>(title, "nameTransition");
       pairs[1] = new Pair<View, String>(descr, "descrTransition");
       pairs[2] = new Pair<View, String>(img, "imageTransition");

        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this, pairs);

       this.startActivity(intent, options.toBundle());

    }

    @Override
    public void OnAddClick(int position) {
        cart.add(items.get(position));
      //  count++;
      //  cnt.setText(String.valueOf(count));
    }


}
