package com.example.elgaml.ecommerce.Fragment;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.elgaml.ecommerce.Home.HomeViewModel;
import com.example.elgaml.ecommerce.R;
import com.example.elgaml.ecommerce.Utils.BestSellerRecyclerAdapter;
import com.example.elgaml.ecommerce.Utils.CategoryRecyclerAdapter;
import com.example.elgaml.ecommerce.Utils.NewArrivalRecyclerAdapter;
import com.example.elgaml.ecommerce.Utils.HotDealsRecyclerAdapter;
import com.example.elgaml.ecommerce.model.FavouritModel.AddToFavourit;
import com.example.elgaml.ecommerce.model.HomeModel.BestSeller;
import com.example.elgaml.ecommerce.model.HomeModel.HomeResponse;
import com.example.elgaml.ecommerce.model.HomeModel.HotDeals;
import com.example.elgaml.ecommerce.model.HomeModel.NewArrival;
import com.example.elgaml.ecommerce.model.HomeModel.SideMenuCategory;
import com.example.elgaml.ecommerce.model.HomeModel.TopCategory;

import java.util.ArrayList;
import java.util.List;

import static android.content.Context.MODE_PRIVATE;
import static com.example.elgaml.ecommerce.Utils.Utils.isNetworkAvailable;

public class HomeFragment extends Fragment implements NewArrivalRecyclerAdapter.NewArrivalRecyclerAdapterListiner {

    RecyclerView recyclerView_new_arrival, recyclerView_best_seller, recyclerView_category, recyclerView_hotdeals;
    HomeViewModel homeViewModel;
    String USER_ID = "UserId";
    SharedPreferences prefs;
    private static final String MY_PREFS_NAME = "UserAuth";
    TextView hot_deals, seemore_hotdeals;
    ImageView next_img;

    NewArrivalRecyclerAdapter arrivalAdapter;
    BestSellerRecyclerAdapter bestSellerRecyclerAdapter;
    CategoryRecyclerAdapter categoryRecyclerAdapter;
    HotDealsRecyclerAdapter hotDealsRecyclerAdapter;

    Toast toast;
    String token;

    private List<BestSeller> mBestSeller = new ArrayList<>();
    private List<HotDeals> mHotDeals = new ArrayList<>();
    private List<NewArrival> mNewArrival = new ArrayList<>();
    private List<SideMenuCategory> mSideMenuCategories = new ArrayList<>();
    private List<TopCategory> mTopCategories = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        androidx.appcompat.widget.Toolbar mToolbar = (androidx.appcompat.widget.Toolbar) view.findViewById(R.id.toolbar_home);

        homeViewModel = new ViewModelProvider(getActivity()).get(HomeViewModel.class);
        homeViewModel.init();

        hot_deals = (TextView) view.findViewById(R.id.hot_deals);
        seemore_hotdeals = (TextView) view.findViewById(R.id.seemore_hot_deals);
        next_img = (ImageView) view.findViewById(R.id.next_sign);
        prefs = getContext().getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE);
        token = prefs.getString(USER_ID, "");

        recyclerView_new_arrival = (RecyclerView) view.findViewById(R.id.newarrival_recycler);
        recyclerView_new_arrival.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));

        recyclerView_best_seller = (RecyclerView) view.findViewById(R.id.best_seller_recycler);
        recyclerView_best_seller.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));

        recyclerView_category = (RecyclerView) view.findViewById(R.id.top_categories_recycler);
        recyclerView_category.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));

        recyclerView_hotdeals = (RecyclerView) view.findViewById(R.id.hot_deals_recycler);
        recyclerView_hotdeals.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));

        arrivalAdapter = new NewArrivalRecyclerAdapter(getContext(), mNewArrival , HomeFragment.this);
        recyclerView_new_arrival.setAdapter(arrivalAdapter);

        bestSellerRecyclerAdapter = new BestSellerRecyclerAdapter(getContext(), mBestSeller, token, getViewLifecycleOwner(), homeViewModel);
        recyclerView_best_seller.setAdapter(bestSellerRecyclerAdapter);

        categoryRecyclerAdapter = new CategoryRecyclerAdapter(mTopCategories);
        recyclerView_category.setAdapter(categoryRecyclerAdapter);

        hotDealsRecyclerAdapter = new HotDealsRecyclerAdapter(getContext(), mHotDeals, token, getViewLifecycleOwner(), homeViewModel);
        recyclerView_hotdeals.setAdapter(hotDealsRecyclerAdapter);

        homeViewModel.getHome(token).observe(getViewLifecycleOwner(), new Observer<HomeResponse>() {
            @Override
            public void onChanged(HomeResponse homeResponse) {
                onGetHome(homeResponse);
            }});
    }


    void onGetHome(HomeResponse homeResponse) {
        mBestSeller =  homeResponse.getBestSeller();
        mHotDeals = homeResponse.getHotDeals();
        mNewArrival = homeResponse.getNewArrival();
        mSideMenuCategories = homeResponse.getSideMenuCategories();
        mTopCategories = homeResponse.getTopCategories();

        arrivalAdapter.setList(mNewArrival);
        arrivalAdapter.notifyDataSetChanged();

        bestSellerRecyclerAdapter.setList(mBestSeller);
        bestSellerRecyclerAdapter.notifyDataSetChanged();

        categoryRecyclerAdapter.setList(mTopCategories);
        categoryRecyclerAdapter.notifyDataSetChanged();

        hotDealsRecyclerAdapter.setList(mHotDeals);
        hotDealsRecyclerAdapter.notifyDataSetChanged();

        if (homeResponse.getHotDeals().size() == 0) {
            hot_deals.setVisibility(View.INVISIBLE);
            seemore_hotdeals.setVisibility(View.INVISIBLE);
            next_img.setVisibility(View.INVISIBLE);
        }
    }

    @Override
    public void onClickFav(final int position) {

        if (isNetworkAvailable(this.getContext())) {
            final NewArrival model=mNewArrival.get(position);

            if (!model.getIsFav()) { model.setIsFav(true); }
            else { model.setIsFav(false); }

            arrivalAdapter.notifyItemChanged(position);
            //send to data base
            homeViewModel.addFavourit(token, String.valueOf(model.getId())).observe(this, new Observer<AddToFavourit>() {
                @Override
                public void onChanged(AddToFavourit addToFavourit) { }});

        } else {
            //no connection
            showToast("No internet connection", getContext());
        } }


    void showToast(String msg, Context context) {
        if (toast != null) {
            toast.cancel();
        }
        toast = Toast.makeText((context), msg, Toast.LENGTH_SHORT);
        toast.show();
    }




}