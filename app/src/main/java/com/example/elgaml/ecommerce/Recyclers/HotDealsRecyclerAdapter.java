package com.example.elgaml.ecommerce.Recyclers;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;

import com.example.elgaml.ecommerce.deals.DealsViewModel;
import com.example.elgaml.ecommerce.R;
import com.example.elgaml.ecommerce.model.FavouritModel.AddToFavourit;
import com.example.elgaml.ecommerce.model.HomeModel.HotDeal;
import com.example.elgaml.ecommerce.utils.ProjectUtils;
import java.util.List;

import static com.example.elgaml.ecommerce.utils.ProjectUtils.isNetworkAvailable;

public class HotDealsRecyclerAdapter extends RecyclerView.Adapter<HotDealsRecyclerAdapter.HotDealsViewHolder> {

    private List<HotDeal> list;
    private String token;
    private LifecycleOwner owner;
    private Toast toast;
    //constructor
    private DealsViewModel dealsViewModel;
    private Context context;
    private ProjectUtils utils;

    public HotDealsRecyclerAdapter(Context context, List<HotDeal> list, String token, LifecycleOwner lifecycleOwner, DealsViewModel homeViewModel){
        this.list = list;
        this.token = token;
        this.dealsViewModel = homeViewModel;
        this.owner = lifecycleOwner;
        this.context=context;
        utils=new ProjectUtils();
    }


    @NonNull
    @Override
    public HotDealsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View row= LayoutInflater.from(parent.getContext()).inflate(R.layout.product_layout,parent,false);
        HotDealsViewHolder hold=new HotDealsViewHolder(row);
        return hold;
    }

    @Override
    public void onBindViewHolder(final HotDealsViewHolder holder, final int position)
    {
        //instace from new Arrival product
        final HotDeal model=list.get(position);

        if (model!=null) {

        if (model.getIsFav()){
            holder.love.setImageResource(R.drawable.heart_loved);
        }else {
            holder.love.setImageResource(R.drawable.heart_unlove);
        }

            //make animation
            holder.love.setAnimation(utils.makeAnimation(holder.itemView.getContext()));

            utils.loadImage(model.getCategory().getImage(), holder.product);
            holder.discount_text.setText(((String) model.getTodayOffer()));

            holder.item_price.setText(String.valueOf(model.getPrice().getPrice() + " $"));
            holder.item_category.setText(String.valueOf(model.getNameEn()));
            holder.love.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    holder.love.setAnimation(utils.makeAnimation(holder.itemView.getContext()));
                    if (isNetworkAvailable(context)) {
                        dealsViewModel.addFavourit(token, String.valueOf(model.getId())).observe(owner, new Observer<AddToFavourit>() {
                            @Override
                            public void onChanged(AddToFavourit addToFavourit) {
                                if (!model.getIsFav()) {
                                    holder.love.setImageResource(R.drawable.heart_loved);
                                    model.setIsFav(true);
                                } else {
                                    holder.love.setImageResource(R.drawable.heart_unlove);
                                    model.setIsFav(false);
                                }
                                notifyDataSetChanged();
                            }
                        });

                    } else {
                        //no connection
                        utils.showToast(toast,"No internet connection", context);
                    } }
            });
        } }
    @Override
    public int getItemCount()
    {
        //to return all images
        //if zero it won't appeat any thing
        return list.size();
    }
    public List<HotDeal> getList() {
        return list;
    }

    public void setList(List<HotDeal> list) {
        this.list = list;
    }

    //holder_class
    class HotDealsViewHolder extends RecyclerView.ViewHolder
    {
        ImageView love,product;
        TextView item_category,item_price,discount_text;
        public HotDealsViewHolder(View itemView)
        {
            super(itemView);
            love =(ImageView)itemView.findViewById(R.id.love_icon);
            product =(ImageView)itemView.findViewById(R.id.product_image);
            item_category=(TextView)itemView.findViewById(R.id.item_name);
            item_price=(TextView)itemView.findViewById(R.id.item_price);
            discount_text=(TextView)itemView.findViewById(R.id.text_discount);
        }}}
