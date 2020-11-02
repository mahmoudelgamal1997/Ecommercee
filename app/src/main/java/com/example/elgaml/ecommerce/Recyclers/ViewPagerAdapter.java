package com.example.elgaml.ecommerce.Recyclers;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.elgaml.ecommerce.model.DealModel.Ad;
import com.example.elgaml.ecommerce.utils.ProjectUtils;

import java.util.List;

public class ViewPagerAdapter extends PagerAdapter {

    private Context context;
    private List<Ad> list;
    private ProjectUtils utils = new ProjectUtils();

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
        utils.loadImage(list.get(position).getImage(),img);
        container.addView(img);
        return img;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((ImageView)object);
    }
}
