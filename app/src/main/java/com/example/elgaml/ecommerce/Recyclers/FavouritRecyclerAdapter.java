package com.example.elgaml.ecommerce.Recyclers;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.elgaml.ecommerce.R;
import com.example.elgaml.ecommerce.model.FavouritModel.FavouriteResponseItem;
import com.example.elgaml.ecommerce.utils.ProjectUtils;

import java.util.List;

public class FavouritRecyclerAdapter  extends RecyclerView.Adapter<FavouritRecyclerAdapter.FavouritViewHolder> {

    private List<FavouriteResponseItem> list;
    private FavouritListner favouritListner;
    private ProjectUtils utils;

    //constructor
    public FavouritRecyclerAdapter(List<FavouriteResponseItem> list, FavouritListner favouritListner) {
        this.list = list;
        this.favouritListner = favouritListner;
        utils= new ProjectUtils();
    }

    @NonNull
    @Override
    public FavouritViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View row = LayoutInflater.from(parent.getContext()).inflate(R.layout.favourit_product, parent, false);
        FavouritViewHolder hold = new FavouritViewHolder(row);
        return hold;
    }

    @Override
    public void onBindViewHolder(final FavouritViewHolder holder, final int position) {

        //instace from new Arrival product
        final FavouriteResponseItem model = list.get(position);
        utils.loadImage(model.getDefaultImage(), holder.favourit_image);
        holder.item_name.setText(model.getNameEn());
        holder.item_price.setText(model.getPrice().getPrice()+" $");


        holder.delete_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                favouritListner.onClickDelet(position);
            }
        });
        holder.add_to_cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                favouritListner.onClickAddCart(position);
              //  holder.add_to_cart.setEnabled(false);
            }
        });
    }

    @Override
    public int getItemCount() {
        //to return all images
        //if zero it won't appeat any thing
        return list.size();
    }

    public List<FavouriteResponseItem> getList() {
        return list;
    }

    public void setList(List<FavouriteResponseItem> list) {
        this.list = list;
    }

    //holder_class
    class FavouritViewHolder extends RecyclerView.ViewHolder {
        ImageView favourit_image,delete_icon;
        Button add_to_cart;
        TextView item_name,item_price;

        public FavouritViewHolder(View itemView) {
            super(itemView);

            favourit_image = (ImageView) itemView.findViewById(R.id.favourit_image);
            delete_icon = (ImageView) itemView.findViewById(R.id.delete_icon);
            add_to_cart= (Button)itemView.findViewById(R.id.add_to_cart);
            item_name=(TextView)itemView.findViewById(R.id.favourit_name);
            item_price=(TextView)itemView.findViewById(R.id.favourit_price);
        }
    }
    public interface  FavouritListner{
        void onClickAddCart(int postion);
        void onClickDelet(int postion);
    }
}
