package com.example.mathpuzzle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Win_Activity extends AppCompatActivity {

    TextView wincontinue,label,main;
    int level;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_win);

        level=getIntent().getIntExtra("level", 0);
        wincontinue=findViewById(R.id.wincontinue);
        main=findViewById(R.id.main);
        label=findViewById(R.id.label);
        label.setText("level " + (level+1) + " completed");
        wincontinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Win_Activity.this,GameActivity.class);
                intent.putExtra("level",level+1);

                startActivity(intent);
                finish();
            }
        });
        main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                finish();
            }
        });



    }
}