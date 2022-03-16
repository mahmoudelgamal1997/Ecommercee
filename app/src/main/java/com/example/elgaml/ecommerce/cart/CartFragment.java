package com.example.elgaml.ecommerce.cart;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.elgaml.ecommerce.R;
import com.example.elgaml.ecommerce.Recyclers.CartRecyclerAdapter;
import com.example.elgaml.ecommerce.model.Cart.Cart;
import com.example.elgaml.ecommerce.model.Cart.CartResponse;
import com.example.elgaml.ecommerce.model.User;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import static android.content.Context.MODE_PRIVATE;
import static com.example.elgaml.ecommerce.utils.ProjectUtils.showToast;


public class CartFragment extends Fragment implements CartRecyclerAdapter.CartRecyclerListner {

    private RecyclerView cart_recycler;
    private CartViewModel cartViewModel;
    SharedPreferences prefs;
    private String mUSER_Data ="UserData";
    private User user;
    private String userData;
    private static final String MY_PREFS_NAME = "UserAuth";
    String USER_ID = "UserId";
    private List<Cart> mList, mSeperateList;
    private CartRecyclerAdapter cartRecyclerAdapter;
    private BottomNavigationView navBar;
    TextView price_number, shipping_number, total_number, number_Items, toast_emputy, subtotalWord, total_word, shipping_word;
    View view_cart;
    Button checkout;
    Toast toast;
    ProgressBar progressBar;
    Observer<CartResponse> observer;
    private RelativeLayout relativeLayout;

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

        Toolbar toolbar = (Toolbar) getActivity().findViewById(R.id.toolbar_base);
        toolbar.setTitle("Cart");
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);

        navBar = getActivity().findViewById(R.id.nav_view_bar);
        cart_recycler = (RecyclerView) view.findViewById(R.id.cart_recycler);
        cart_recycler.setLayoutManager(new LinearLayoutManager(getContext()));
        cart_recycler.setHasFixedSize(true);

        init(view);

        mList = new ArrayList<>();
        mSeperateList = new ArrayList<>();
        cartRecyclerAdapter = new CartRecyclerAdapter(mList, getContext(), this);

        cart_recycler.setAdapter(cartRecyclerAdapter);

        cartViewModel = new CartViewModel();
        cartViewModel.init();

        prefs = getContext().getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE);
        Gson gson=new Gson();
        userData = prefs.getString(mUSER_Data, "");
        user = gson.fromJson(userData, User.class);
       // token = prefs.getString(USER_ID, "");

        //hideAllView();
        relativeLayout.setVisibility(View.INVISIBLE);
        progressBar.setVisibility(View.VISIBLE);

        observer = new Observer<CartResponse>() {
            @Override
            public void onChanged(CartResponse cartResponse) {
                if (cartResponse.getCarts().size() != 0) {
                    mSeperateList = mList;
                    toast_emputy.setVisibility(View.GONE);
                    //   showAllView();
                    relativeLayout.setVisibility(View.VISIBLE);
                    mList = cartResponse.getCarts();
                    cartRecyclerAdapter.setList(mList);
                    cartRecyclerAdapter.notifyDataSetChanged();
                    bindUI(cartResponse);
                    progressBar.setVisibility(View.INVISIBLE);
                } else {
                    toast_emputy.setVisibility(View.VISIBLE);
                    toast_emputy.setText("No Item in Cart ");
                    progressBar.setVisibility(View.INVISIBLE);
                }
            }
        };
        cartViewModel.getCart(user.getApiToken()).observe(getViewLifecycleOwner(), observer);
    }

    @Override
    public void onClickDelete(int postion) {
        cartViewModel.deleteCart(mList.get(postion).getId(), user.getApiToken()).observe(getViewLifecycleOwner(), new Observer<CartResponse>() {
            @Override
            public void onChanged(CartResponse cartResponse) {

                if (mSeperateList.size() == 1) {
                    //   hideAllView();
                    relativeLayout.setVisibility(View.INVISIBLE);
                    toast_emputy.setVisibility(View.VISIBLE);
                    toast_emputy.setText("No Item in Cart ");
                }
                mSeperateList = mList;
                mSeperateList.remove(postion);
                // mList=cartResponse.getCarts();
                cartRecyclerAdapter.setList(mSeperateList);
                cartRecyclerAdapter.notifyItemChanged(postion);
                showToast("removed Successfully", getContext(), toast);
            }
        });
    }

    @Override
    public void onClickChangeQuantity(int postiion, String but_id) {
        int card_id = mList.get(postiion).getId();
        int quantity = 0;
        if (but_id.equals("plus")) {
            quantity = 1;
        } else if (but_id.equals("minus")) {
            quantity = 0;
        }
        cartViewModel.updateCart(user.getApiToken(), quantity, card_id).observe(getViewLifecycleOwner(), new Observer<CartResponse>() {
            @Override
            public void onChanged(CartResponse cartResponse) {
                cartViewModel.getCart(user.getApiToken()).observe(getViewLifecycleOwner(), new Observer<CartResponse>() {
                    @Override
                    public void onChanged(CartResponse cartResponse) {
                        if (cartResponse.getCarts().size() != 0) {
                            mSeperateList = mList;

                            //mList = cartResponse.getCarts();
                            cartRecyclerAdapter.setList(mList);
                            cartRecyclerAdapter.notifyItemChanged(postiion);
                            bindUI(cartResponse);
                        }
                    }
                });
            }
        });

    }

    /*
    void hideAllView() {
        shipping_number.setVisibility(View.GONE);
        price_number.setVisibility(View.GONE);
        number_Items.setVisibility(View.GONE);
        total_number.setVisibility(View.GONE);
        subtotalWord.setVisibility(View.GONE);
        total_word.setVisibility(View.GONE);
        view_cart.setVisibility(View.GONE);
        shipping_word.setVisibility(View.GONE);
        checkout.setVisibility(View.GONE);
        cart_recycler.setVisibility(View.GONE);
    }

    void showAllView() {
        shipping_number.setVisibility(View.VISIBLE);
        price_number.setVisibility(View.VISIBLE);
        number_Items.setVisibility(View.VISIBLE);
        total_number.setVisibility(View.VISIBLE);
        subtotalWord.setVisibility(View.VISIBLE);
        total_word.setVisibility(View.VISIBLE);
        view_cart.setVisibility(View.VISIBLE);
        shipping_word.setVisibility(View.VISIBLE);
        checkout.setVisibility(View.VISIBLE);
        cart_recycler.setVisibility(View.VISIBLE);
    }


     */
    void bindUI(CartResponse cartResponse) {
        shipping_number.setText("USD " + cartResponse.getShipping());
        price_number.setText("USD " + cartResponse.getTotal_price());
        number_Items.setText(cartResponse.getTotal_items() + " items");
        double sum = cartResponse.getTotal_price() + Integer.parseInt(cartResponse.getShipping());
        total_number.setText("USD " + sum);
    }

    void init(View view) {
        relativeLayout = (RelativeLayout) view.findViewById(R.id.cartrelative);
        price_number = (TextView) view.findViewById(R.id.price_number);
        shipping_number = (TextView) view.findViewById(R.id.shipping_number);
        total_number = (TextView) view.findViewById(R.id.total_number);
        number_Items = (TextView) view.findViewById(R.id.numberOfItems);
        subtotalWord = (TextView) view.findViewById(R.id.subtotal);
        total_word = (TextView) view.findViewById(R.id.total_word);
        view_cart = (View) view.findViewById(R.id.view_cart);
        shipping_word = view.findViewById(R.id.shipping_word);
        toast_emputy = (TextView) view.findViewById(R.id.toast_emputy);
        progressBar = view.findViewById(R.id.progress_cart);
        checkout = (Button) view.findViewById(R.id.checkout_but);
    }
}