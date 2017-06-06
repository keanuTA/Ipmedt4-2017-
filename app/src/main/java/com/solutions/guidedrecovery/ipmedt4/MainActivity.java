package com.solutions.guidedrecovery.ipmedt4;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.support.v7.app.AppCompatActivity;

import static android.R.attr.onClick;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

        public void toTraject (View v){
        Intent intent = new Intent(MainActivity.this, TrajectKeuze.class);
        startActivity(intent);
    }
    public void toPreTraject(View v){
                Intent intent3 = new Intent(MainActivity.this, PreTrajectKeuze.class);
                startActivity(intent3);
        }
    }
