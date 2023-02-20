package com.example.mathpuzzle;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class GameActivity extends AppCompatActivity {

    TextView[] txt = new TextView[10];
    TextView textView, levelName;
    ImageView dbtn, board;
    String n = "";
    int level = 0;
    int ansArr[] = {10, 25, 6, 14, 128, 7, 50, 1025, 100, 3, 1, 1, 1, 1, 1, 1, 1, 1};
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    public static int[] img = {R.drawable.p1, R.drawable.p2, R.drawable.p3, R.drawable.p4, R.drawable.p5,
            R.drawable.p6, R.drawable.p7, R.drawable.p8, R.drawable.p9, R.drawable.p10, R.drawable.p11,
            R.drawable.p22, R.drawable.p23, R.drawable.p24, R.drawable.p25, R.drawable.p26,
            R.drawable.p27, R.drawable.p28, R.drawable.p29, R.drawable.p30, R.drawable.p31, R.drawable.p32,
            R.drawable.p33,R.drawable.p34,R.drawable.p35,R.drawable.p36,R.drawable.p37,R.drawable.p38,R.drawable.p39};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        levelName = findViewById(R.id.levelname);

        level = getIntent().getIntExtra("level", 0);
        levelName.setText("Level # " + (level + 1));
        textView = findViewById(R.id.entertxt);
        dbtn = findViewById(R.id.dbtn);
        board = findViewById(R.id.board);
        board.setImageResource(img[level]);
        sharedPreferences = getSharedPreferences("myPref", MODE_PRIVATE);
        editor = sharedPreferences.edit();

        for (int i = 0; i <= 9; i++) {
            int id = getResources().getIdentifier("txt" + i, "id", getPackageName());
            txt[i] = findViewById(id);
            int finalI = i;
            txt[i].setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {

                    n = n + txt[finalI].getText().toString();
                    textView.setText(n);

                }
            });
        }
        dbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (!textView.getText().toString().isEmpty()) {
                    n = n.substring(0, n.length() - 1);
                    textView.setText(n);
                }
            }
        });
        findViewById(R.id.submit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int ans = Integer.parseInt(textView.getText().toString());
                if (ans == ansArr[level]) {
                    editor.putInt("LastLevel", level);
                    editor.putString("LevelStatus" + level, "win");
                    editor.commit();

                    Intent intent = new Intent(GameActivity.this, Win_Activity.class);
                    intent.putExtra("level", level);
                    startActivity(intent);
                    finish();
                } else {
                    AlertDialog.Builder builder = new AlertDialog.Builder(GameActivity.this);
                    builder.setTitle("Alert...!");
                    builder.setMessage("Answer is Wrong..! level failed..   do you want to continue?");
                    builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    });
                    builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            finish();
                        }
                    });
                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();
                }

            }
        });
        findViewById(R.id.skip).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editor.putInt("LastLevel", level);
                editor.putString("LevelStatus" + level, "skip");
                editor.commit();
                Intent intent = new Intent(GameActivity.this, GameActivity.class);
                intent.putExtra("level", level + 1);
                startActivity(intent);

                finish();

            }
        });




    }
}
