package com.example.cardrecycletest;

import android.content.Intent;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.squareup.picasso.Picasso;

import static com.example.cardrecycletest.MainActivity.*;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

       Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String descr = intent.getStringExtra("descr");
        Integer img = intent.getIntExtra("img", 0);
        ImageView detImg = findViewById(R.id.detImg);
        TextView detName = findViewById(R.id.detName);
        TextView detDescr = findViewById(R.id.detDescr);
        Picasso.get().load(img).into(detImg);
        detName.setText(name);
        detDescr.setText(descr);

    }
}
