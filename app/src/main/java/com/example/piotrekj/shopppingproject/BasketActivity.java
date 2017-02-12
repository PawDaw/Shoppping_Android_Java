package com.example.piotrekj.shopppingproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TextView;

import java.io.IOException;

public class BasketActivity extends AppCompatActivity {

    Service service = new Service();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.basket_activity_main);


        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(new BasketAdapter(this, R.layout.basket_activity, service.getInstance().getShoppingBasket()));

        // show Total
        TextView t1 = (TextView) findViewById(R.id.TextViewTotal);
        t1.setText(String.valueOf(Service.getInstance().totalAmountFromBasket()) + " dkk");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.basket_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        int id = item.getItemId();

//        ------ Remove Button -------

        if(id == R.id.remove_id) {

                //Toast.makeText(getApplicationContext(), "remove icon is selected", Toast.LENGTH_SHORT).show();

//            clear Basket
                Service.getInstance().clearBasket();

//            clear Counter
                Service.getInstance().clearCounter();

//            back to MainActivity
                Intent toMainActivity = new Intent(BasketActivity.this, MainActivity.class);
                startActivity(toMainActivity);
                finish();

//           delete file with last basket session
               service.getInstance().clearFile(this);

            }

//        ------ Back Button,  previous page with products items -------

        else if (id == R.id.back)
        {
                Intent toProducts=new Intent(BasketActivity.this, ProductListActivity.class);
                toProducts.putExtra("shop_name1", "Bilka");
                toProducts.putExtra("shop_name2", "Fotex");
                toProducts.putExtra("shop_name3", "Netto");
                toProducts.putExtra("shop_name4", "Rema");
                toProducts.putExtra("shop_name5", "Kvickly");
                toProducts.putExtra("shop_name6", "Kiwi");
                startActivity(toProducts);
        }
        return super.onOptionsItemSelected(item);
    }






}
