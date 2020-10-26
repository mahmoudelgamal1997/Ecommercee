package com.example.elgaml.ecommerce.utils;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;

import com.example.elgaml.ecommerce.home.HomeViewModel;
import com.example.elgaml.ecommerce.R;
import com.example.elgaml.ecommerce.model.FavouritModel.AddToFavourit;
import com.example.elgaml.ecommerce.model.HomeModel.BestSeller;
import com.squareup.picasso.Picasso;

import java.util.List;

import static com.example.elgaml.ecommerce.utils.Utils.isNetworkAvailable;

public class BestSellerRecyclerAdapter extends RecyclerView.Adapter<BestSellerRecyclerAdapter.BestSellerViewHolder> {

    private List<BestSeller> list;
    private String token;
    private LifecycleOwner owner;
    private Toast toast;

    //constructor
    private HomeViewModel homeViewModel;
    private Context context;
    public BestSellerRecyclerAdapter(Context context, List<BestSeller> list, String token, LifecycleOwner lifecycleOwner, HomeViewModel homeViewModel){
        this.list = list;
        this.token = token;
        this.homeViewModel = homeViewModel;
        this.owner = lifecycleOwner;
        this.context=context;
    }


    @NonNull
    @Override
    public BestSellerRecyclerAdapter.BestSellerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View row= LayoutInflater.from(parent.getContext()).inflate(R.layout.product_layout,parent,false);
        BestSellerViewHolder hold=new BestSellerViewHolder(row);
        return hold;
    }

    @Override
    public void onBindViewHolder(final BestSellerRecyclerAdapter.BestSellerViewHolder holder, final int position)
    {

        //instace from new Arrival product
        final BestSeller model=list.get(position);
        Log.e("isFav",model.getIsFav()+"");
        if (model.getIsFav()){
            holder.love.setImageResource(R.drawable.heart_loved);
        }else {
            holder.love.setImageResource(R.drawable.heart_unlove);
        }

       // holder.love.setAnimation(makeAnimation());

        loadImage(model.getDefaultImage(),holder.product);
        /*
        if (model.getTodayOffer()!=null){
            holder.discount_text.setText(((String) model.getTodayOffer()));
        }

         */
        holder.item_price.setText(model.getPrice()+" $");
        holder.item_category.setText(String.valueOf(model.getNameEn()));
        holder.love.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.love.setAnimation(makeAnimation());
                if (isNetworkAvailable(context)){

                    Log.e("Clicked","clicked");
                    homeViewModel.addFavourit(token,String.valueOf(model.getId())).observe(owner, new Observer<AddToFavourit>() {
                        @Override
                        public void onChanged(AddToFavourit addToFavourit) {
                            if (!model.getIsFav()){
                                holder.love.setImageResource(R.drawable.heart_loved);
                                model.setIsFav(true);
                            }else {
                                holder.love.setImageResource(R.drawable.heart_unlove);
                                model.setIsFav(false);

                            }
                        notifyItemChanged(position);

                        }
                    });

                }else {
                    //no connection
                    showToast("No internet connection",context);
                }
            }
        });

    }

    public List<BestSeller> getList() {
        return list;
    }

    public void setList(List<BestSeller> list) {
        this.list = list;
    }

    @Override
    public int getItemCount()
    {
        //to return all images
        //if zero it won't appeat any thing
        return list.size();
    }

    //holder_class
    class BestSellerViewHolder extends RecyclerView.ViewHolder
    {
        ImageView love,product;
        TextView item_category,item_price,discount_text;
        public BestSellerViewHolder(View itemView)
        {
            super(itemView);

            love =(ImageView)itemView.findViewById(R.id.love_icon);
            product =(ImageView)itemView.findViewById(R.id.product_image);
            item_category=(TextView)itemView.findViewById(R.id.item_name);
            item_price=(TextView)itemView.findViewById(R.id.item_price);
            discount_text=(TextView)itemView.findViewById(R.id.text_discount);

        }



    }

    void loadImage(String url,ImageView img){
        Picasso.get().load("http://e-commerce-dev.intcore.net/"+url).into(img);
    }

    void showToast(String msg, Context context){
        if (toast!=null){
            toast.cancel();
        }
        toast= Toast.makeText((context),msg,Toast.LENGTH_SHORT);
        toast.show();
    }

    Animation makeAnimation(){
        final Animation myAnim = AnimationUtils.loadAnimation(context, R.anim.love_animation);

        // Use bounce interpolator with amplitude 0.2 and frequency 20
        BonusInterpolator interpolator = new BonusInterpolator(0.3, 20);
        myAnim.setInterpolator(interpolator);
        return myAnim;
    }



}


