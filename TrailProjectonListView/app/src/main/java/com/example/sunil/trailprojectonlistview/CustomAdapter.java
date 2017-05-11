package com.example.sunil.trailprojectonlistview;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.Toast;

import java.util.zip.Inflater;

import static android.os.Build.VERSION_CODES.M;

/**
 * Created by sunil on 10/05/17.
 */

 public class CustomAdapter extends BaseAdapter{
     private String animals[];
     private ButtonClick mButtonClick;

    public CustomAdapter(ButtonClick buttonClick, String [] animals) {
        mButtonClick = buttonClick;
        this.animals = animals;

    }


    @Override
    public int getCount() {
        return animals.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {



        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        final View view = layoutInflater.inflate(R.layout.custom_layout,parent,false);

        Button button = (Button) view.findViewById(R.id.button4);
        Button button1 = (Button) view.findViewById(R.id.button7);
        ImageView imageView = (ImageView) view.findViewById(R.id.imageView3);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mButtonClick.onClickButton();
            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { mButtonClick.initiatePop();



            }
        });
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mButtonClick.imageClick();
            }
        });
        return view;
    }
}
