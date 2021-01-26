package com.example.cardrecycletest;

import android.content.Intent;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class CartActivity extends AppCompatActivity {

    static ArrayList<Food> cartAr;
    RecyclerView cRv;
    CartAdapter cAdapter;
    Intent cartIntent;
   static TextView total;
   static int sum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        total = findViewById(R.id.total);

        cartIntent = getIntent();
        cartAr = new ArrayList<>();
        for (int i = 0; i < MainActivity.cart.size(); i++) {
            cartAr.add(MainActivity.cart.get(i));
        }
        calcPrice();



        cRv = findViewById(R.id.cartRv);
        cRv.setLayoutManager(new LinearLayoutManager(this));
        cAdapter = new CartAdapter(this, cartAr);
        cRv.setAdapter(cAdapter);
        cAdapter.notifyDataSetChanged();
    }

    public static void calcPrice() {
        sum = 0;
                for (int i = 0; i < cartAr.size(); i++) {
                sum = sum + Integer.parseInt(cartAr.get(i).getPrice());
                total.setText("Total: " + sum + "$");
            }

    }


}
