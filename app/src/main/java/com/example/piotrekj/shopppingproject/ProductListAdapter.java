package com.example.piotrekj.shopppingproject;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;


public class ProductListAdapter extends ArrayAdapter<Shop>
{
    private Service service;

    TextView textView1;
    TextView textView2;
    ImageView logo;

    List<Shop> shops;
    int [] images;

    public ProductListAdapter(Context context, int resource, List<Shop> shops, Service s, int[] images) {
        super(context, resource, shops);
        service = s;
        this.images = images;
    }

    @Override
    public View getView(final int position, View convertView, final ViewGroup parent) {

        if (convertView == null) {

            convertView = View.inflate(getContext(), R.layout.shop_list_row, null);
        }

        textView1 = (TextView) convertView.findViewById(R.id.title);
        textView2 = (TextView) convertView.findViewById(R.id.description);
        logo = (ImageView) convertView.findViewById(R.id.logo);

        final Shop s = (Shop) getItem(position);
        textView1.setText(s.getTitle());
        textView2.setText(s.getDescription());
        logo.setImageResource(images[position]);

        return convertView;
}

}
