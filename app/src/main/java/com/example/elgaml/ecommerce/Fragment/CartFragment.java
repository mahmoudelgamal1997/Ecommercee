package com.example.elgaml.ecommerce.Fragment;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.elgaml.ecommerce.R;
import com.example.elgaml.ecommerce.Utils.CartRecyclerAdapter;
import com.example.elgaml.ecommerce.model.Cart.Cart;
import com.example.elgaml.ecommerce.model.Cart.CartResponse;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

import static android.content.Context.MODE_PRIVATE;
import static com.example.elgaml.ecommerce.Utils.Utils.hideBottomNavigationBar;
import static com.example.elgaml.ecommerce.Utils.Utils.showToast;


public class CartFragment extends Fragment implements CartRecyclerAdapter.CartRecyclerListner {

    private RecyclerView cart_recycler;
    private CartViewModel cartViewModel ;
    SharedPreferences prefs;
    private static final String MY_PREFS_NAME ="UserAuth" ;
    String USER_ID="UserId";
    private List<Cart> mList,mSeperateList;
    private CartRecyclerAdapter cartRecyclerAdapter;
    private BottomNavigationView navBar;
    TextView price_number , shipping_number , total_number,number_Items,toast_emputy,subtotalWord ,total_word,shipping_word ;
    View view_cart;
    Button checkout ;
    Toast toast ;
    ProgressBar progressBar;
    public CartFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cart, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        navBar = getActivity().findViewById(R.id.nav_view_bar);
        cart_recycler = (RecyclerView)view.findViewById(R.id.cart_recycler);
        cart_recycler.setLayoutManager(new LinearLayoutManager(getContext()));
        cart_recycler.setHasFixedSize(true);

        price_number=(TextView)view.findViewById(R.id.price_number);
        shipping_number=(TextView)view.findViewById(R.id.shipping_number);
        total_number=(TextView)view.findViewById(R.id.total_number);
        number_Items=(TextView)view.findViewById(R.id.numberOfItems);
        subtotalWord=(TextView)view.findViewById(R.id.subtotal);
        total_word=(TextView)view.findViewById(R.id.total_word);
        view_cart=(View)view.findViewById(R.id.view_cart);
        shipping_word=view.findViewById(R.id.shipping_word);
        toast_emputy=(TextView)view.findViewById(R.id.toast_emputy);
        progressBar=view.findViewById(R.id.progress_cart);
        checkout=(Button)view.findViewById(R.id.checkout_but);

        mList= new ArrayList<>();
        mSeperateList= new ArrayList<>();
        cartRecyclerAdapter= new CartRecyclerAdapter(mList,getContext(),this);

        cart_recycler.setAdapter(cartRecyclerAdapter);

        cartViewModel = new CartViewModel();
        cartViewModel.init();

        prefs = getContext().getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE);
        final String  token = prefs.getString(USER_ID, "");

        hideAllView();
        progressBar.setVisibility(View.VISIBLE);

        cartViewModel.getCart(token).observe(getViewLifecycleOwner(), new Observer<CartResponse>() {
            @Override
            public void onChanged(CartResponse cartResponse) {

                if (cartResponse.getCarts().size() !=0 ) {
                    toast_emputy.setVisibility(View.GONE);
                    showAllView();
                    mList = cartResponse.getCarts();
                    cartRecyclerAdapter.setList(mList);
                    cartRecyclerAdapter.notifyDataSetChanged();

                    shipping_number.setText("USD " + cartResponse.getShipping());
                    price_number.setText("USD " + cartResponse.getTotalPrice());
                    number_Items.setText(cartResponse.getTotalItems() + " items");
                    double sum = cartResponse.getTotalPrice() + Integer.parseInt(cartResponse.getShipping());
                    total_number.setText("USD " + sum);
                    progressBar.setVisibility(View.INVISIBLE);
                }else {
                    toast_emputy.setVisibility(View.VISIBLE);
                    toast_emputy.setText("No Item in Cart ");
                    progressBar.setVisibility(View.INVISIBLE);
                }
            }
        });
    }

    @Override
    public void onClickDelete(int postion) {
        mSeperateList=mList;
        mSeperateList.remove(postion);
        cartRecyclerAdapter.setList(mSeperateList);
        cartRecyclerAdapter.notifyDataSetChanged();
        showToast("removed Successfully",getContext(),toast);
    }

    void hideAllView(){
        shipping_number.setVisibility(View.GONE);
        price_number.setVisibility(View.GONE);
        number_Items.setVisibility(View.GONE);
        total_number.setVisibility(View.GONE);
        subtotalWord.setVisibility(View.GONE);
        total_word.setVisibility(View.GONE);
        view_cart.setVisibility(View.GONE);
        shipping_word.setVisibility(View.GONE);
        checkout.setVisibility(View.GONE);
    }

    void showAllView(){
        shipping_number.setVisibility(View.VISIBLE);
        price_number.setVisibility(View.VISIBLE);
        number_Items.setVisibility(View.VISIBLE);
        total_number.setVisibility(View.VISIBLE);
        subtotalWord.setVisibility(View.VISIBLE);
        total_word.setVisibility(View.VISIBLE);
        view_cart.setVisibility(View.VISIBLE);
        shipping_word.setVisibility(View.VISIBLE);
        checkout.setVisibility(View.VISIBLE);
    }
}