package com.example.elgaml.ecommerce.deals;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.elgaml.ecommerce.home.HomeViewModel;
import com.example.elgaml.ecommerce.R;
import com.example.elgaml.ecommerce.Recyclers.BrandRecyclerAdapter;
import com.example.elgaml.ecommerce.Recyclers.CategoryRecyclerAdapter;
import com.example.elgaml.ecommerce.Recyclers.HotDealsRecyclerAdapter;
import com.example.elgaml.ecommerce.Recyclers.ViewPagerAdapter;
import com.example.elgaml.ecommerce.model.DealModel.DealResponse;

import static android.content.Context.MODE_PRIVATE;


public class DealsFragment extends Fragment {

    RecyclerView hot_deals_recycler,recyclerView_category,brand_recycler;
    SharedPreferences prefs;
    private static final String MY_PREFS_NAME ="UserAuth" ;
    String USER_ID="UserId";
    HomeViewModel homeViewModel;
    TextView hot_txt,seemore_hot_txt;
    ImageView next_hot_deals;
    DealsViewModel dealsViewModel;
    public DealsFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_deals, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final ViewPager viewPager=(ViewPager)view.findViewById(R.id.viewPager);
        hot_txt=(TextView)view.findViewById(R.id.hot_deals_today_txt);
        seemore_hot_txt=(TextView)view.findViewById(R.id.seemore_hot_deals);
        next_hot_deals=(ImageView)view.findViewById(R.id.next_sign_hot_deals);

        hot_deals_recycler=(RecyclerView)view.findViewById(R.id.hot_deals_recycler);
        hot_deals_recycler.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL, false));

        recyclerView_category=(RecyclerView)view.findViewById(R.id.top_categories_recycler);
        recyclerView_category.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL, false));

        brand_recycler=(RecyclerView)view.findViewById(R.id.brand_recycler);
        brand_recycler.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL, false));



        homeViewModel=new HomeViewModel();

        dealsViewModel = new DealsViewModel();
        dealsViewModel.init();


        prefs = getContext().getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE);
        final String  token = prefs.getString(USER_ID, "");


        dealsViewModel.getDeals().observe(getViewLifecycleOwner(), new Observer<DealResponse>() {
            @Override
            public void onChanged(DealResponse dealResponse) {
            ViewPagerAdapter viewPagerAdapter= new ViewPagerAdapter(getContext(),dealResponse.getAds());
            viewPager.setAdapter(viewPagerAdapter);


            if (dealResponse.getHotDeals().size()!=0) {
                next_hot_deals.setVisibility(View.VISIBLE);
                hot_txt.setVisibility(View.VISIBLE);
                seemore_hot_txt.setVisibility(View.VISIBLE);
                HotDealsRecyclerAdapter hotDealsRecyclerView = new HotDealsRecyclerAdapter(getContext(), dealResponse.getHotDeals(), token, getViewLifecycleOwner(), homeViewModel);
                hot_deals_recycler.setAdapter(hotDealsRecyclerView);
            }

                CategoryRecyclerAdapter categoryRecyclerAdapter = new CategoryRecyclerAdapter(dealResponse.getTopCategories());
                recyclerView_category.setAdapter(categoryRecyclerAdapter);


                BrandRecyclerAdapter brandRecyclerAdapter = new BrandRecyclerAdapter(getContext(), dealResponse.getTopBrand());
        brand_recycler.setAdapter(brandRecyclerAdapter);

            }});
    }
}