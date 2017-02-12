package com.example.piotrekj.shopppingproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class BasketAdapter extends ArrayAdapter<Product> {


    public BasketAdapter(Context context, int resource, List<Product> objects) {
        super(context, resource, objects);
    }


    // method to reload ViewList
    public void refreshViewList() {
        this.notifyDataSetChanged();
    }


    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {


        // view lookup cache stored in tag
        ViewHolder holder = null;


        // Get the data item for this position
        final Product product = getItem(position);



        if ( convertView == null){

//            refresh List View
            refreshViewList();

            holder = new ViewHolder();

            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.basket_activity,null);

            holder.title = (TextView) convertView.findViewById(R.id.name);
            holder.number = (TextView) convertView.findViewById(R.id.list_item_number);
            holder.ProductPrice = (TextView) convertView.findViewById(R.id.productPrice);

            convertView.setTag(holder);


        }else{

            holder = (ViewHolder) convertView.getTag();

        }

        // Populate the data into the template view using the data object
        holder.title.setText(product.getName());

        // set counter
        holder.number.setText("Ordered : " +String.valueOf(Service.getInstance().getCounter(product)));
        holder.ProductPrice.setText(product.getShopsPrice()+" x "+String.valueOf(Service.getInstance().getCounter(product))+" = "+String.valueOf(Service.getInstance().totalPriceForProduct(product)));


        // Return the completed view to render on screen
        return convertView;
    }

    public class ViewHolder {
        TextView title;
        TextView number;
        TextView ProductPrice;
        TextView Total;

    }
}
