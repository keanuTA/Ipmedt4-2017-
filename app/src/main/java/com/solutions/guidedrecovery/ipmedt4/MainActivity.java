package com.solutions.guidedrecovery.ipmedt4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.support.v7.app.AppCompatActivity;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    ListView  lijst;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayAdapter<String> mAdapter = new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_list_item_1,
                getResources().getStringArray(R.array.traject));

        lijst = (ListView) findViewById(R.id.lijst);
        lijst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this,TrajectKeuzeActivity.class);
                intent.putExtra("Trajectpunt",lijst.getItemAtPosition(i).toString());
            }
        });
        lijst.setAdapter(mAdapter);


   }

    public void toTraject(View v) {
        switch (v.getId()) {
            case R.id.card_view_dwars:
                Intent intent = new Intent(this, TrajectKeuzeActivity.class);
                startActivity(intent);
                break;
            case R.id.card_view_meervoudig:
                break;
        }
    }
}
