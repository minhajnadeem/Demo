package com.example.minhaj.demo.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.minhaj.demo.R;

import java.util.ArrayList;

/**
 * Created by Minhaj on 15/09/2018.
 */
public class ProductDetailAdapter extends RecyclerView.Adapter<ProductDetailAdapter.MyViewHolder> {

    private Context context;
    private ArrayList<Integer> arrayListDetailImages;

    public ProductDetailAdapter(Context context, ArrayList<Integer> arrayListDetailImages) {
        this.context = context;
        this.arrayListDetailImages = arrayListDetailImages;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.row_layout_product_detail,viewGroup,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        myViewHolder.imageView.setImageResource(arrayListDetailImages.get(i));
    }

    @Override
    public int getItemCount() {
        return arrayListDetailImages.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
        }
    }
}
