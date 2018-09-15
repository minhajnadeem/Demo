package com.example.minhaj.demo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.minhaj.demo.adapters.StoreListingAdapter;
import com.example.minhaj.demo.interfaces.StoreListingClickInterface;
import com.example.minhaj.demo.models.StoreListingModel;
import com.example.minhaj.demo.utils.Constants;
import com.example.minhaj.demo.utils.Prefs;
import com.example.minhaj.demo.utils.Utils;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements StoreListingClickInterface,View.OnClickListener{

    //variables
    private Prefs prefs;
    private ArrayList<StoreListingModel> storeListingModelArrayList;
    private StoreListingAdapter storeListingAdapter;

    //views
    private TextView tvTitle;
    private ImageView ivAppbarLeftIcon;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        setupListeners();
        setupData();
        setAdapter();
    }

    private void init() {
        storeListingModelArrayList = new ArrayList<>();
        prefs = new Prefs(this);

        tvTitle = findViewById(R.id.title);

        ivAppbarLeftIcon = findViewById(R.id.ivAppbarLeftIcon);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        storeListingAdapter = new StoreListingAdapter(this,storeListingModelArrayList,this);
        recyclerView.setAdapter(storeListingAdapter);

        tvTitle.setText(R.string.stringTitleHome);
    }

    private void setupListeners() {
        ivAppbarLeftIcon.setOnClickListener(this);
    }

    private void setupData() {
        storeListingModelArrayList.clear();

        ArrayList<Integer> arrayList1 = new ArrayList<>();
        ArrayList<Integer> arrayList2 = new ArrayList<>();
        arrayList1.add(R.drawable.img_16);
        arrayList1.add(R.drawable.img_17);
        arrayList1.add(R.drawable.img_18);
        arrayList1.add(R.drawable.img_19);
        arrayList1.add(R.drawable.img_20);

        arrayList2.add(R.drawable.img_21);
        arrayList2.add(R.drawable.img_22);
        arrayList2.add(R.drawable.img_23);
        arrayList2.add(R.drawable.img_24);
        arrayList2.add(R.drawable.img_25);

        storeListingModelArrayList.add(new StoreListingModel(R.drawable.img_1,300,1700,3400,arrayList1));
        storeListingModelArrayList.add(new StoreListingModel(R.drawable.img_2,300,1700,3400,arrayList1));
        storeListingModelArrayList.add(new StoreListingModel(R.drawable.img_3,300,1700,3400,arrayList1));
        storeListingModelArrayList.add(new StoreListingModel(R.drawable.img_4,300,1700,3400,arrayList1));
        storeListingModelArrayList.add(new StoreListingModel(R.drawable.img_5,300,1700,3400,arrayList1));
        storeListingModelArrayList.add(new StoreListingModel(R.drawable.img_6,300,1700,3400,arrayList1));
        storeListingModelArrayList.add(new StoreListingModel(R.drawable.img_7,300,1700,3400,arrayList1));
        storeListingModelArrayList.add(new StoreListingModel(R.drawable.img_8,300,1700,3400,arrayList1));
        storeListingModelArrayList.add(new StoreListingModel(R.drawable.img_9,300,1700,3400,arrayList2));
        storeListingModelArrayList.add(new StoreListingModel(R.drawable.img_10,300,1700,3400,arrayList2));
        storeListingModelArrayList.add(new StoreListingModel(R.drawable.img_11,300,1700,3400,arrayList2));
        storeListingModelArrayList.add(new StoreListingModel(R.drawable.img_12,300,1700,3400,arrayList2));
        storeListingModelArrayList.add(new StoreListingModel(R.drawable.img_13,300,1700,3400,arrayList2));
        storeListingModelArrayList.add(new StoreListingModel(R.drawable.img_14,300,1700,3400,arrayList2));
        storeListingModelArrayList.add(new StoreListingModel(R.drawable.img_15,300,1700,3400,arrayList2));
    }

    private void setAdapter() {
        storeListingAdapter.notifyDataSetChanged();
    }

    /*
        click call back of store listing adapter
     */
    @Override
    public void onClickItem(StoreListingModel model) {
        Intent intent = new Intent(this,ProductDetailActivity.class);
        intent.putExtra(Constants.EXTRA_STORE_LISTING_MODEL,model);
        startActivity(intent);
    }

    /*
        view onclick listener
     */
    @Override
    public void onClick(View view) {
        //app bar left icon
        if (view.getId() == R.id.ivAppbarLeftIcon){
            Utils.logout(this,prefs);
        }
    }
}
