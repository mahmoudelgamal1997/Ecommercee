package com.example.elgaml.ecommerce.Utils;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.elgaml.ecommerce.R;
import com.example.elgaml.ecommerce.model.Cart.Cart;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CartRecyclerAdapter extends RecyclerView.Adapter<CartRecyclerAdapter.CartViewHolder> {

    private List<Cart> list;
    Context context;
    CartRecyclerListner listner;
    public interface CartRecyclerListner{
        void onClickDelete(int postion);
    }
    //constructor
    public CartRecyclerAdapter(List<Cart> list,Context context,CartRecyclerListner listner) {
        this.list = list;
        this.context= context;
        this.listner=listner;
    }

    @NonNull
    @Override
    public CartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View row = LayoutInflater.from(parent.getContext()).inflate(R.layout.cart_items, parent, false);
        CartViewHolder hold = new CartViewHolder(row);
        return hold;
    }

    @Override
    public void onBindViewHolder(final CartViewHolder holder, final int position) {

        //instace from new Arrival product
        final Cart model = list.get(position);
        loadImage(model.getProduct().getDefaultImage(), holder.cart_img);


        holder.item_name.setText(model.getProduct().getNameEn());
        holder.item_price.setText(model.getProduct().getPrice()+" $");
        Typeface font = Typeface.createFromAsset(context.getAssets(), "fonts/fontawesome.ttf");
        holder.minus_button.setTypeface(font);
        holder.plus_button.setTypeface(font);
        holder.delete_from_cart.setTypeface(font);

        holder.minus_button.setText("\uf056");
        holder.plus_button.setText("\uF055");
        holder.delete_from_cart.setText("\uf2ed");

        holder.quantity.setText(model.getQuantity()+"");


        holder.delete_from_cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listner.onClickDelete(position);
            }
        });
        holder.plus_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int sum=model.getQuantity()+1;
                model.setQuantity(sum);
                holder.quantity.setText(sum+"");
            }
        });

        holder.minus_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (model.getQuantity() != 0){
                int sum=model.getQuantity()-1;
                model.setQuantity(sum);
                holder.quantity.setText(sum+"");
            }

            }
        });





    }

    @Override
    public int getItemCount() {
        //to return all images
        //if zero it won't appeat any thing
        return list.size();
    }

    public List<Cart> getList() {
        return list;
    }

    public void setList(List<Cart> list) {
        this.list = list;
    }

    //holder_class
    static class CartViewHolder extends RecyclerView.ViewHolder {
        ImageView cart_img;
        TextView item_name,item_price,minus_button,plus_button,delete_from_cart,quantity;

        public CartViewHolder(View itemView) {
            super(itemView);

            cart_img = (ImageView) itemView.findViewById(R.id.cart_image);
            delete_from_cart = (TextView) itemView.findViewById(R.id.delete_icon_cart);
            plus_button = (TextView) itemView.findViewById(R.id.add);
            minus_button = (TextView) itemView.findViewById(R.id.remove);
            item_name=(TextView)itemView.findViewById(R.id.cart_item_name);
            item_price=(TextView)itemView.findViewById(R.id.cart_item_price);
            quantity=(TextView)itemView.findViewById(R.id.quantity);
        }
    }
    void loadImage(String url, ImageView img) {
        Picasso.get().load("http://e-commerce-dev.intcore.net/"+url).into(img);
    }}
