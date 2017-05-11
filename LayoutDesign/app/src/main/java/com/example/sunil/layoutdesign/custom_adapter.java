package com.example.sunil.layoutdesign;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.zip.Inflater;

import static android.R.attr.resource;
import static java.security.AccessController.getContext;

/**
 * Created by sunil on 05/05/17.
 */

class CustomAdapter extends BaseAdapter {

    private int[] images;
    private String[] imageNames;

   public CustomAdapter(int[] images, String[] imageNames) {
       this.images = images;
       this.imageNames = imageNames;
   }

    @Override
    public int getCount() {
        return imageNames.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @NonNull
    @Override
    public View getView(int position,  View convertView,  ViewGroup parent) {

        Drawable image = null;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        View customView = inflater.inflate(R.layout.custom_row,parent,false);

        String animal = imageNames[position];
        if(position < imageNames.length - 1)
          image = parent.getContext().getResources().getDrawable(images[position]);


        TextView textView = (TextView) customView.findViewById(R.id.textView);

        ImageView imageView = (ImageView) customView.findViewById(R.id.imageView);

        textView.setText(animal);
//        imageView.setImageResource(R.drawable.lion_logo);
        imageView.setImageDrawable(image);

        return customView;
    }
}
