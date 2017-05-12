package com.example.sunil.restapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class custom_layout extends AppCompatActivity {

    ArrayList <Person> persons = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_layout);
        ListView listView = (ListView) findViewById(R.id.list_item);
        String json_data = getIntent().getExtras().getString("json_data");
        custom_adapter custom_adapter = new custom_adapter();
        try {
            JSONArray jsonArray = new JSONArray(json_data);
            int count = 0;
            while(count < jsonArray.length()){
                JSONObject itrObj = jsonArray.getJSONObject(count);
                int userId = Integer.parseInt(itrObj.getString("userId"));
                int id = Integer.parseInt(itrObj.getString("id"));
                String title = itrObj.getString("title");
                Person person = new Person(userId,id,title);
                custom_adapter.add(person);

                count++;
            }


            listView.setAdapter(custom_adapter);

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
