package com.example.mathpuzzle;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class Level_Adpter extends BaseAdapter {

    int[] img;
    Activity context;
    TextView textView;
    SharedPreferences sharedPreferences;
    ImageView lock,arrow;

    public Level_Adpter(int[] img, Activity context)
    {
        this.img = img;
        this.context = context;
        sharedPreferences= context.getSharedPreferences("myPref",Context.MODE_PRIVATE);
    }
    @Override
    public int getCount()
    {
        return 20;
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup)
    {

        view= LayoutInflater.from(context).inflate(R.layout.level_item,viewGroup,false);
        textView=view.findViewById(R.id.number);
        lock=view.findViewById(R.id.lock);
        arrow=view.findViewById(R.id.arrowwnext);
        textView.setVisibility(View.INVISIBLE);
        String status = sharedPreferences.getString("LevelStatus"+i,"g");
        int lastlevel = sharedPreferences.getInt("LastLevel",0);
        textView.setText(String.valueOf(i+1));

        lock.setImageResource(R.drawable.lock);
        if (status.equals("win"))
        {
            textView.setVisibility(View.VISIBLE);
            lock.setImageResource(R.drawable.chack);
        }
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context,GameActivity.class);
                intent.putExtra("level",i);
                context.startActivity(intent);
                context.finish();
            }
        });
        if (status.equals("skip") || i==lastlevel+1)
        {
            lock.setVisibility(View.INVISIBLE);
           textView.setVisibility(View.VISIBLE);
        }






        return view;
    }
}
