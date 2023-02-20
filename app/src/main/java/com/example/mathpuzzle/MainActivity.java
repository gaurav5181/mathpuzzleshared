package com.example.mathpuzzle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView continuee,puzzle;
    Intent intent;
    SharedPreferences sharedPreferences;
    int LastLevel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        continuee=findViewById(R.id.continuee);
        puzzle=findViewById(R.id.puzzle);
        sharedPreferences=getSharedPreferences("myPref",MODE_PRIVATE);
        LastLevel = sharedPreferences.getInt("LastLevel",-1);
        continuee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this,GameActivity.class);
                intent.putExtra("level",LastLevel+1);
                startActivity(intent);

            }
        });
        puzzle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent1 = new Intent(MainActivity.this,Leval_Activity.class);
                startActivity(intent1);

            }
        });
    }
}