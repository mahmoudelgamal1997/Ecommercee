package com.example.elgaml.ecommerce.Utils;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.elgaml.ecommerce.R;
import com.example.elgaml.ecommerce.model.DealModel.Ad;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ViewPagerAdapter extends PagerAdapter {

    private Context context;
    private List<Ad> list;
    public ViewPagerAdapter(Context context,List<Ad> list){
        this.context = context;
        this.list=list;
    }
    @Override
    public int getCount() {
        return list.size();
        }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        ImageView img = new ImageView(context);
        img.setScaleType(ImageView.ScaleType.CENTER_CROP);
        loadImage(list.get(position).getImage(),img);
        container.addView(img);
        return img;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((ImageView)object);
    }
    void loadImage(String url,ImageView img){
        Picasso.get().load("http://e-commerce-dev.intcore.net/"+url).into(img);
    }
}
