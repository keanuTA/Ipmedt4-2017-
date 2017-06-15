package com.solutions.guidedrecovery.ipmedt4;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.support.v7.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void toTraject(View v) {
        switch (v.getId()) {
            case R.id.card_view_dwars:
                Intent intent = new Intent(this, TrajectKeuzeActivity.class);
                startActivity(intent);
                break;
            case R.id.card_view_meervoudig:
                Intent intent2 = new Intent(this, TrajectKeuzeActivity.class);
                startActivity(intent2);
                break;
        }
    }
}
