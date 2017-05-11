package com.example.sunil.trailprojectonlistview;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.PopupMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.Toast;

import java.util.zip.Inflater;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.L;

public class MainActivity extends AppCompatActivity implements ButtonClick {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listView = (ListView) findViewById(R.id.list_view);
        final String animals[] = {"R","T","S"};
        ListAdapter listAdapter = new CustomAdapter(this,animals);
        listView.setAdapter(listAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String name = animals[position];
                Toast.makeText(MainActivity.this,name,Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public void onClickButton() {
        Intent intent = new Intent(this,TrailActivity.class);
        startActivity(intent);
    }

    @Override
    public void initiatePop() {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setIcon(R.drawable.lion_logo);
        builder.setTitle("New Popup");
        builder.setMessage("It is a new Popup created by Me :)");
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();

    }

    @Override
    public void imageClick() {
        Intent intent = new Intent(this,TrailActivity.class);
        startActivity(intent);
    }


}
