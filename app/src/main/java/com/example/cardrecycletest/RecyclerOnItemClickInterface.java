package com.example.cardrecycletest;

import android.widget.ImageView;
import android.widget.TextView;

public interface RecyclerOnItemClickInterface {
    void OnItemClick(int position, TextView name, TextView descr, ImageView img);

    void OnAddClick(int position);
}
