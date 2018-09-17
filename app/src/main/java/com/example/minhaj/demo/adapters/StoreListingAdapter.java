package com.example.minhaj.demo.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.minhaj.demo.R;
import com.example.minhaj.demo.interfaces.StoreListingClickInterface;
import com.example.minhaj.demo.models.StoreListingModel;
import com.example.minhaj.demo.utils.GlideApp;

import java.util.ArrayList;

/**
 * Created by Minhaj on 15/09/2018.
 */
public class StoreListingAdapter extends RecyclerView.Adapter<StoreListingAdapter.MyViewHolder> {

    private ArrayList<StoreListingModel> storeListingModelArrayList;
    private StoreListingClickInterface clickInterface;
    private Context context;

    public StoreListingAdapter(Context context,ArrayList<StoreListingModel> storeListingModelArrayList,StoreListingClickInterface clickInterface){
        this.context = context;
        this.storeListingModelArrayList = storeListingModelArrayList;
        this.clickInterface = clickInterface;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.row_layout_store_listing,viewGroup,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        StoreListingModel model = storeListingModelArrayList.get(i);

        GlideApp.with(context)
                .load(context.getResources().getDrawable(model.getResDrawableImg()))
                .into(myViewHolder.ivItem);

        myViewHolder.tvUnitPrice.setText(String.format(context.getString(R.string.stringUnitPrice),model.getUnitPrice()));
        myViewHolder.tvHalfDozenPrice.setText(String.format(context.getString(R.string.stringHalfDozenPrice),model.getDozenPrice()));
        myViewHolder.tvDozenPrice.setText(String.format(context.getString(R.string.stringDozenPrice),model.getHalfDozenPrice()));
    }

    @Override
    public int getItemCount() {
        return storeListingModelArrayList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView ivItem;
        TextView tvUnitPrice,tvHalfDozenPrice,tvDozenPrice;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            ivItem = itemView.findViewById(R.id.ivItem);
            tvUnitPrice = itemView.findViewById(R.id.tvUnitPrice);
            tvHalfDozenPrice = itemView.findViewById(R.id.tvHalfDozenPrice);
            tvDozenPrice = itemView.findViewById(R.id.tvDozenPrice);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            StoreListingModel model = storeListingModelArrayList.get(getAdapterPosition());
            clickInterface.onClickItem(model);
        }
    }
}
