package com.example.elgaml.ecommerce.Utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.example.elgaml.ecommerce.R;
import com.example.elgaml.ecommerce.model.HomeModel.NewArrival;
import com.squareup.picasso.Picasso;

import java.util.List;

public class NewArrivalRecyclerAdapter extends RecyclerView.Adapter<NewArrivalRecyclerAdapter.NewArrivalHolder> {


    public interface NewArrivalRecyclerAdapterListiner {
        void onClickFav(int position);
    }

    private List<NewArrival> list;
    private Toast toast;
    //constructor
    private Context context;
    private NewArrivalRecyclerAdapterListiner listiner;

    public NewArrivalRecyclerAdapter(Context context, List<NewArrival> list, NewArrivalRecyclerAdapterListiner listiner) {
        this.list = list;
        this.context = context;
        this.listiner = listiner;
    }


    @Override
    public NewArrivalHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View row = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_layout, parent, false);
        NewArrivalHolder hold = new NewArrivalHolder(row);
        return hold;
    }

    @Override
    public void onBindViewHolder(final NewArrivalHolder holder, final int position) {

        NewArrival model = list.get(position);
        if (model.getIsFav()) {
            holder.love.setImageResource(R.drawable.heart_loved);
        } else {
            holder.love.setImageResource(R.drawable.heart_unlove);
        }

       // holder.love.setAnimation(makeAnimation());
        loadImage(model.getDefaultImage(), holder.product);
        holder.item_price.setText(String.valueOf(model.getPrice() + " $"));
        holder.item_category.setText(String.valueOf(model.getNameEn()));
        holder.love.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.love.setAnimation(makeAnimation());
                listiner.onClickFav(position);
            }
        });


    }

    @Override
    public int getItemCount() {
        //to return all images
        //if zero it won't appeat any thing
        return list.size();
    }



      public List<NewArrival> getList() {

          return list;

      }

      public void setList(List<NewArrival> list) {
        
          this.list = list;
          
      }
      

      //holder_class
    class NewArrivalHolder extends RecyclerView.ViewHolder {
        ImageView love, product;
        TextView item_category, item_price;

        public NewArrivalHolder(View itemView) {
            super(itemView);

            love = (ImageView) itemView.findViewById(R.id.love_icon);
            product = (ImageView) itemView.findViewById(R.id.product_image);
            item_category = (TextView) itemView.findViewById(R.id.item_name);
            item_price = (TextView) itemView.findViewById(R.id.item_price);


            love.setAnimation(makeAnimation());
        }



    }

    void loadImage(String url, ImageView img) {
        Picasso.get().load("http://e-commerce-dev.intcore.net/" + url).placeholder(R.drawable.refresh).into(img);
    }



    Animation makeAnimation() {
        final Animation myAnim = AnimationUtils.loadAnimation(context, R.anim.love_animation);

        // Use bounce interpolator with amplitude 0.2 and frequency 20
        BonusInterpolator interpolator = new BonusInterpolator(0.3, 20);
        myAnim.setInterpolator(interpolator);
        return myAnim;
    }
}


