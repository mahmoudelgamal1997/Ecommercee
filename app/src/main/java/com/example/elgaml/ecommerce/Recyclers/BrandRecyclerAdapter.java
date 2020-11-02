package com.example.elgaml.ecommerce.Recyclers;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.elgaml.ecommerce.R;
import com.example.elgaml.ecommerce.model.DealModel.TopBrand;
import com.example.elgaml.ecommerce.utils.ProjectUtils;
import com.squareup.picasso.Picasso;

import java.util.List;

public class BrandRecyclerAdapter  extends RecyclerView.Adapter<BrandRecyclerAdapter.BrandViewHolder> {

    private List<TopBrand> list;
    private Toast toast;
    private ProjectUtils utils;

    //constructor
    public BrandRecyclerAdapter(Context context, List<TopBrand> list) {

        this.list = list;
        utils= new ProjectUtils();
    }


    @NonNull
    @Override
    public  BrandViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View row = LayoutInflater.from(parent.getContext()).inflate(R.layout.brand_layout, parent, false);
        BrandViewHolder hold = new BrandViewHolder(row);
        return hold;
    }

    @Override
    public void onBindViewHolder(final BrandViewHolder holder, final int position) {

        //instace from new Arrival product
        final TopBrand model = list.get(position);

        utils.loadImage(model.getImage(), holder.brand_image);
        Log.e("img", model.getImage());
    }

    @Override
    public int getItemCount() {
        //to return all images
        //if zero it won't appeat any thing
        return list.size();
    }

    //holder_class
    class BrandViewHolder extends RecyclerView.ViewHolder {
        ImageView brand_image;
      //  TextView category_name;

        public BrandViewHolder(View itemView) {
            super(itemView);

            brand_image = (ImageView) itemView.findViewById(R.id.brand_image);
        }
    }


}