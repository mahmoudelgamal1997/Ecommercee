package com.example.elgaml.ecommerce.utils;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.elgaml.ecommerce.R;
import com.example.elgaml.ecommerce.model.HomeModel.TopCategory;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CategoryRecyclerAdapter extends RecyclerView.Adapter<CategoryRecyclerAdapter.CategoryViewHolder> {

    private List<TopCategory> list;
    //constructor
    public CategoryRecyclerAdapter( List<TopCategory> list){
        this.list = list;
    }
    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View row= LayoutInflater.from(parent.getContext()).inflate(R.layout.category_product,parent,false);
        CategoryViewHolder hold=new CategoryViewHolder(row);
        return hold;
    }
    @Override
    public void onBindViewHolder(final CategoryViewHolder holder, final int position)
    {
        //instace from new Arrival product
        final TopCategory model=list.get(position);
        loadImage(model.getImage(),holder.category_image);
        Log.e("img",model.getImage());
        holder.category_name.setText(String.valueOf(model.getNameEn()));
    }
    @Override
    public int getItemCount()
    {
        //to return all images
        //if zero it won't appeat any thing
        return list.size();
    }
    public List<TopCategory> getList() {
        return list;
    }
    public void setList(List<TopCategory> list) {
        this.list = list;
    }
    //holder_class
    class CategoryViewHolder extends RecyclerView.ViewHolder
    {
        ImageView category_image;
        TextView category_name;
        public CategoryViewHolder(View itemView)
        {
            super(itemView);

            category_image = (ImageView)itemView.findViewById(R.id.category_image);
            category_name  = (TextView)itemView.findViewById(R.id.category_name);
        }}

    void loadImage(String url,ImageView img){
        Picasso.get().load("http://e-commerce-dev.intcore.net/"+url).placeholder(R.drawable.refresh).into(img);
    }
}