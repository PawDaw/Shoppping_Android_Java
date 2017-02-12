package com.example.piotrekj.shopppingproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;

public class MainActivity extends AppCompatActivity {


    Service service = new Service();
    Storage storage = new Storage();
    BasketActivity basket = new BasketActivity();
    ProductListAdapter productListAdapter;
    ListView listView;
    private List<Shop> shops = storage.getInstance().getShops();
    int[] images = {R.drawable.bilka, R.drawable.fotex, R.drawable.netto, R.drawable.rema, R.drawable.kvickly, R.drawable.kiwi};




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        service.getInstance().initStorage();

        if(service.getInstance().getShoppingBasket().isEmpty()){

            service.getInstance().readFile(this);
            service.getInstance().retriveBasketFromLastSession();
        }


        listView = (ListView) findViewById(R.id.listView);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Shop clickedShop = shops.get(position);


                Intent intent = new Intent(MainActivity.this, ProductListActivity.class);

                if (intent.getExtras() == null) {
                    intent.putExtra("shop_name1", clickedShop.getTitle());
                    intent.putExtra("shop_name2", clickedShop.getTitle());
                    intent.putExtra("shop_name3", clickedShop.getTitle());
                    intent.putExtra("shop_name4", clickedShop.getTitle());
                    intent.putExtra("shop_name5", clickedShop.getTitle());
                    intent.putExtra("shop_name6", clickedShop.getTitle());

                    startActivity(intent); // then you start it this way

                }

        }
    });

         //set Adapter to Shops
        productListAdapter = new ProductListAdapter(this, -1, storage.getInstance().getShops(), service, images);
        listView.setAdapter(productListAdapter);
    }

}
