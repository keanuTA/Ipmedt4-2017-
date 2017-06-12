package com.solutions.guidedrecovery.ipmedt4;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.CardView;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import static com.solutions.guidedrecovery.ipmedt4.TrajectKeuze.PREFS_NAME;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }





    public void toTraject(View v) {
        switch (v.getId()) {
            case R.id.card_view_dwars:
                Intent intent = new Intent(this, TrajectKeuze.class);
                startActivity(intent);
                break;
            case R.id.card_view_meervoudig:
                Intent intent2 = new Intent(this, TrajectKeuze.class);
                startActivity(intent2);
                break;
        }
    }
}
