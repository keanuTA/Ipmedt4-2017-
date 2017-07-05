package com.solutions.guidedrecovery.ipmedt4;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.support.v7.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Typeface iconFont = FontManager.getTypeface(getApplicationContext(), FontManager.FONTAWESOME);
        FontManager.markAsIconContainer(findViewById(R.id.icons_container), iconFont);
    }


    public void toTraject(View v) {
        switch (v.getId()) {
            case R.id.card_view_dwars:
                Intent intent = new Intent(this, TrajectKeuzeActivity.class);
                startActivity(intent);
                break;
        }
    }
}
