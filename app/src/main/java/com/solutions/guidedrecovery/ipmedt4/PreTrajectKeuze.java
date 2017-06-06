package com.solutions.guidedrecovery.ipmedt4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class PreTrajectKeuze extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pre_traject_keuze);
    }

    public void toMain(View v) {
        switch (v.getId()) {
            case R.id.card_view_pre_traject:
                Intent intent = new Intent(PreTrajectKeuze.this, MainActivity.class);
                startActivity(intent);
                break;
        }
    }

}
