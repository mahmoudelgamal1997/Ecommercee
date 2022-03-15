package com.example.elgaml.ecommerce.homefragment;

import android.content.Context;
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
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.elgaml.ecommerce.home.HomeViewModel;
import com.example.elgaml.ecommerce.R;
import com.example.elgaml.ecommerce.Recyclers.BestSellerRecyclerAdapter;
import com.example.elgaml.ecommerce.Recyclers.CategoryRecyclerAdapter;
import com.example.elgaml.ecommerce.Recyclers.NewArrivalRecyclerAdapter;
import com.example.elgaml.ecommerce.Recyclers.HotDealsRecyclerAdapter;
import com.example.elgaml.ecommerce.model.FavouritModel.AddToFavourit;
import com.example.elgaml.ecommerce.model.HomeModel.BestSeller;
import com.example.elgaml.ecommerce.model.HomeModel.HomeTestResponse;
import com.example.elgaml.ecommerce.model.HomeModel.HotDeal;
import com.example.elgaml.ecommerce.model.HomeModel.NewArrival;
import com.example.elgaml.ecommerce.model.HomeModel.SideMenuCategory;
import com.example.elgaml.ecommerce.model.HomeModel.TopCategory;

import java.util.ArrayList;
import java.util.List;

import static android.content.Context.MODE_PRIVATE;
import static com.example.elgaml.ecommerce.utils.ProjectUtils.isNetworkAvailable;

public class HomeFragment extends Fragment implements NewArrivalRecyclerAdapter.NewArrivalRecyclerAdapterListiner {

    RecyclerView recyclerView_new_arrival, recyclerView_best_seller, recyclerView_category, recyclerView_hotdeals;
    HomeViewModel homeViewModel;
    String mUSER_ID = "UserId";
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
    private List<HotDeal> mHotDeals = new ArrayList<>();
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

        Toolbar toolbar=(Toolbar)getActivity().findViewById(R.id.toolbar_base);

        toolbar.setTitleMarginStart(40);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("Home");


        homeViewModel = new ViewModelProvider(getActivity()).get(HomeViewModel.class);
        homeViewModel.init();

        seemore_hotdeals = (TextView) view.findViewById(R.id.seemore_hot_deals);
        prefs = getContext().getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE);
        token = prefs.getString(mUSER_ID, "");

        recyclerView_new_arrival = (RecyclerView) view.findViewById(R.id.newarrival_recycler);
        recyclerView_new_arrival.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));

        recyclerView_best_seller = (RecyclerView) view.findViewById(R.id.best_seller_recycler);
        recyclerView_best_seller.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));

        recyclerView_category = (RecyclerView) view.findViewById(R.id.top_categories_recycler);
        recyclerView_category.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));

       // recyclerView_hotdeals = (RecyclerView) view.findViewById(R.id.hot_deals_recycler);
       // recyclerView_hotdeals.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));

        arrivalAdapter = new NewArrivalRecyclerAdapter(getContext(), mNewArrival , HomeFragment.this);
        recyclerView_new_arrival.setAdapter(arrivalAdapter);

        bestSellerRecyclerAdapter = new BestSellerRecyclerAdapter(getContext(), mBestSeller, token, getViewLifecycleOwner(), homeViewModel);
        recyclerView_best_seller.setAdapter(bestSellerRecyclerAdapter);

        categoryRecyclerAdapter = new CategoryRecyclerAdapter(mTopCategories);
        recyclerView_category.setAdapter(categoryRecyclerAdapter);

      //  hotDealsRecyclerAdapter = new HotDealsRecyclerAdapter(getContext(), mTopCategories, token, getViewLifecycleOwner(), homeViewModel);
      //  recyclerView_hotdeals.setAdapter(categoryRecyclerAdapter);

        homeViewModel.getHome(token).observe(getViewLifecycleOwner(), new Observer<HomeTestResponse>() {
            @Override
            public void onChanged(HomeTestResponse homeResponse) {


                onGetHome(homeResponse);
            }});
    }


    void onGetHome(HomeTestResponse homeResponse) {
        mBestSeller =  homeResponse.getBestSeller();
        mNewArrival = homeResponse.getNewArrival();
        mSideMenuCategories = homeResponse.getSideMenuCategories();
        mTopCategories = homeResponse.getTopCategories();

        mHotDeals = homeResponse.getHotDeals();
           
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
    }}