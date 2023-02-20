package com.example.mathpuzzle;

import static com.example.mathpuzzle.GameActivity.img;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.GridView;
import android.widget.ImageView;

public class Leval_Activity extends AppCompatActivity {

    Level_Adpter adapter;
    GridView gridView;
    ImageView arrow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leval);

        gridView=findViewById(R.id.grid);
        adapter = new Level_Adpter(img, Leval_Activity.this);
        gridView.setAdapter(adapter);
        arrow=findViewById(R.id.arrowwnext);
        arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Leval_Activity.this,MainActivity.class);
                startActivity(intent);


            }
        });





    }
}