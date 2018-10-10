package com.example.a503_25.a1010listview;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;
import android.widget.ImageView;

public class GridViewPrec extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view_prec);

        GridView gridView = (GridView)findViewById(R.id.gridView);
        ImageAdapter adapter = new ImageAdapter(this);
        gridView.setAdapter(adapter);
    }
}

