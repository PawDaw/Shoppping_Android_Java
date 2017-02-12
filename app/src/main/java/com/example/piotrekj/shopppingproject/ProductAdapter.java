package com.example.piotrekj.shopppingproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;


public class ProductAdapter extends ArrayAdapter<Product> {


    Service service;
    int [] productImages;

    public ProductAdapter(Context context, int resource, List<Product> objects, Service service, int[] productImages) {
        super(context, resource, objects);
        this.service = service;
        this.productImages = productImages;
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

            holder = new ViewHolder();

            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.product_list_row,null);

            holder.image = (ImageView) convertView.findViewById(R.id.icon);
            holder.name = (TextView) convertView.findViewById(R.id.name);
            holder.number = (TextView) convertView.findViewById(R.id.list_item_number);
            holder.unit = (TextView) convertView.findViewById(R.id.unit);
            holder.price = (TextView) convertView.findViewById(R.id.price);
            holder.shopPrice = (TextView) convertView.findViewById(R.id.shopPrice);
            holder.buttonAdd = (Button) convertView.findViewById(R.id.addButton);
            holder.buttonRemove = (Button) convertView.findViewById(R.id.removeButton);

            convertView.setTag(holder);

            //-------- ADD Button On Click Listner -----------------
            holder.buttonAdd.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v ) {


                    // reload adapter, ListView
                    refreshViewList();

                    // info on the screen
                    Toast.makeText(getContext(), "Product was added  " + product.getName() + " from position: " + position, Toast.LENGTH_SHORT).show();

                    // update counter  +1 in selected  Product  item
                    Service.getInstance().updateProductCounterIncrease(product);

                    //System.out.println("COunter_1 !!!!!!!!!!!!!!! " + position + " " + product.getCounter());

                }

            });

            //----- Reomve Button ------------

            holder.buttonRemove.setOnClickListener(new View.OnClickListener(){

                @Override
                public void onClick(View v) {

                    // reload adapter, ListView
                    refreshViewList();

                    // info on the screen
                    Toast.makeText(getContext(), "Product was removed  " + product.getName() +" from position: " + position, Toast.LENGTH_SHORT).show();

                    // update counter to -1 in selected  Product  item
                    Service.getInstance().updateProductCounterDecrease(product);
                }
            });
        }else{

            holder = (ViewHolder) convertView.getTag();

        }
//

        holder.image.setImageResource(productImages[position]);
        holder.name.setText(product.getName());

        // counter
        holder.number.setText("Ordered : " + String.valueOf(Service.getInstance().getCounter(product)));
        holder.unit.setText("Unit: " + product.getUnit());
        holder.price.setText("Price: " + product.getPrice());
        holder.shopPrice.setText("Shop price: " + product.getShopsPrice());

        // Return the completed view to render on screen
        return convertView;
    }




    public class ViewHolder {

        ImageView image;
        TextView name;
        TextView number;
        TextView unit;
        TextView price;
        TextView shopPrice;
        Button buttonRemove;
        Button buttonAdd;

    }
}
