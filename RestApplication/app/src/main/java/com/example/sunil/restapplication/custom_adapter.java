package com.example.sunil.restapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import static android.R.id.list;

/**
 * Created by sunil on 11/05/17.
 */

public class custom_adapter extends BaseAdapter{
    int userId,id;
    String title;
    int total_count;
    Person obj;

    List list = new ArrayList();


    public void add (Person obj){
            list.add(obj);
    }
    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View inflate = layoutInflater.inflate(R.layout.custom_layout, parent, false);
        Person obj = (Person) list.get(position);
        TextView textView = (TextView) inflate.findViewById(R.id.textView5);
        TextView textView1 = (TextView) inflate.findViewById(R.id.textView6);
        TextView textView2 = (TextView) inflate.findViewById(R.id.textView7);
        textView.setText(""+ obj.getId());
        textView1.setText("" + obj.getUserID());
        textView2.setText(obj.getTitle());
        return inflate;
    }
}
