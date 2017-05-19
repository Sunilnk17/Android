package com.example.sunil.retrofitapi.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sunil.retrofitapi.R;
import com.example.sunil.retrofitapi.model.Flowers;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sunil on 19/05/17.
 */

public class FlowerAdapter extends RecyclerView.Adapter<FlowerAdapter.Holder> {


    private List<Flowers> flowerList;

    public FlowerAdapter() {
        this.flowerList = new ArrayList<>();
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_recycle_adapter, parent, false);

        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {

        Flowers flowers = flowerList.get(position);
        holder.textView1.setText(flowers.getName());
        holder.textView.setText("$" + Double.toString(flowers.getPrice()));


    }

    @Override
    public int getItemCount() {
        return flowerList.size();
    }

    public void refresh(List<Flowers> flowers) {
        flowerList = flowers;

    }

    public class Holder extends RecyclerView.ViewHolder {

        public Holder(View itemView) {

            super(itemView);

        }

        TextView textView = (TextView) itemView.findViewById(R.id.textView);
        TextView textView1 = (TextView) itemView.findViewById(R.id.textView2);
        ImageView imageView = (ImageView) itemView.findViewById(R.id.imageView);

    }

}
