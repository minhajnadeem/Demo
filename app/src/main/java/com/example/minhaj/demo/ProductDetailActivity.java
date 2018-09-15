package com.example.minhaj.demo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.minhaj.demo.adapters.ProductDetailAdapter;
import com.example.minhaj.demo.models.StoreListingModel;
import com.example.minhaj.demo.utils.Constants;

public class ProductDetailActivity extends AppCompatActivity {

    //variables
    private StoreListingModel storeListingModel;

    //views
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);

        storeListingModel = getIntent().getParcelableExtra(Constants.EXTRA_STORE_LISTING_MODEL);
        init();
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        storeListingModel = intent.getParcelableExtra(Constants.EXTRA_STORE_LISTING_MODEL);
    }

    private void init() {

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        ProductDetailAdapter adapter = new ProductDetailAdapter(this,storeListingModel.getArrayListDetailImages());
        recyclerView.setAdapter(adapter);
    }
}
