package com.example.sunil.layoutdesign;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.L;

public class Containers extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_containers);

        final String animals [] = {"Lion","Tiger","Elephant","Horse","Fox"};
        int images [] = {R.drawable.lion_logo,R.drawable.lion_logo1,R.drawable.lion_logo2,R.drawable.lion_logo3};

        ListAdapter listAdapter = new CustomAdapter(images,animals);
        ListView listView = (ListView) findViewById(R.id.custom_list);
        listView.setAdapter(listAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String item = animals[position];
                Toast.makeText(Containers.this,item,Toast.LENGTH_LONG).show();
            }
        });

    }
}
