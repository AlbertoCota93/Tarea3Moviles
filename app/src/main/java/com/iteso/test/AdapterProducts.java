package com.iteso.test;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.iteso.test.beans.ItemProduct;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class AdapterProducts extends RecyclerView.Adapter<AdapterProducts.ViewHolder>{

    private ArrayList<ItemProduct> products;
    private Context context;

    public AdapterProducts(Context context, ArrayList<ItemProduct> products){
        this.context=context;
        this.products=products;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_product,parent,false);
        ViewHolder viewHolder= new ViewHolder(v);
        return viewHolder;
    }

    public static class  ViewHolder extends RecyclerView.ViewHolder{
        private ImageView image;
        private TextView title;
        private Button mDetail;
        private TextView mProductStore;
        private TextView mProductLocation;
        private TextView mProductPhone;
        private ImageView mProductThumbnail;
        private RelativeLayout mEventLayout;

        public ViewHolder(View v){
            super(v);
            image = v.findViewById(R.id.item_product_image);
            title=v.findViewById(R.id.item_product_title);
            mDetail=v.findViewById(R.id.item_product_detail);
            mProductStore= v.findViewById(R.id.item_product_store);
            mProductLocation= v.findViewById(R.id.item_product_location);
            mProductPhone= v.findViewById(R.id.item_product_phone);
            mProductThumbnail=v.findViewById(R.id.item_product_thumbnail);
            mEventLayout=v.findViewById(R.id.item_product_layout);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.mProductStore.setText(products.get(position).getStore());
        holder.title.setText(products.get(position).getTitle());
        holder.mProductLocation.setText(products.get(position).getLocation());
        holder.mProductPhone.setText(products.get(position).getPhone());
        switch (products.get(position).getImage()){
            case 0:
                holder.image.setImageResource(R.drawable.mac);
            case 1:
                holder.image.setImageResource(R.drawable.alienware);
        }
        Bitmap bitmap = ((BitmapDrawable)holder.mProductThumbnail.getDrawable()).getBitmap();
        holder.mProductThumbnail.setImageBitmap(bitmap);
    }

    public int getItemCount(){
        return products.size();
    }
}
