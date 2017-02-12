package com.example.piotrekj.shopppingproject;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;


public class ProductListActivity extends AppCompatActivity {

    ListView listView;
    ProductAdapter productAdapter;
    private Service service = new Service();
    int[] productImages = {R.drawable.water, R.drawable.milk, R.drawable.bread, R.drawable.soap, R.drawable.ipad};

    private static Context mContext;

    public static Context getContext() {

        return mContext;
    }

    public void setContext(Context mContext) {

        this.mContext = this.getApplicationContext();
    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        service.getInstance().initStorage();

        listView = (ListView) findViewById(R.id.listView);

        List<Product> products = new ArrayList<>();


        if(getIntent().getExtras() != null) {
            if (getIntent().getExtras().getString("shop_name1").equals("Bilka")) {
                products = service.getInstance().getBilkaProducts();
            } else if (getIntent().getExtras().getString("shop_name2").equals("Fotex")) {
                products = service.getInstance().getFotexProducts();
            } else if (getIntent().getExtras().getString("shop_name3").equals("Netto")) {
                products = service.getInstance().getNettoProducts();
            } else if (getIntent().getExtras().getString("shop_name4").equals("Rema")) {
                products = service.getInstance().getRemaProducts();
            } else if (getIntent().getExtras().getString("shop_name5").equals("Kvickly")) {
                products = service.getInstance().getKvicklyProducts();
            } else if (getIntent().getExtras().getString("shop_name6").equals("Kiwi")) {
                products = service.getInstance().getKiwiProducts();

            }
        }

        productAdapter = new ProductAdapter(this, -1, products , service, productImages);

        listView.setAdapter(productAdapter);
        productAdapter.notifyDataSetChanged();
        listView.invalidateViews();
        listView.refreshDrawableState();
    }



    // -----------   BAR ACTIONS  ,  METHODS ---------------------

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_activity_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.


        //    ---------     Busket Bar ICON  --------------
        // be iF statment poniewaz mamy tylko jeden button na BAR

        Intent basket = new Intent(ProductListActivity.this, BasketActivity.class);
            startActivity(basket);

        System.err.println("Basket ICON Pressed !!!!!!!!!!  ");

            Service.getInstance().createBasketWithItems();


            service.getInstance().saveData(this);



        return super.onOptionsItemSelected(item);
    }
}
