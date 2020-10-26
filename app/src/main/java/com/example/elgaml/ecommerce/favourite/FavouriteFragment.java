package com.example.elgaml.ecommerce.favourite;

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
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.elgaml.ecommerce.home.HomeViewModel;
import com.example.elgaml.ecommerce.R;
import com.example.elgaml.ecommerce.utils.FavouritRecyclerAdapter;
import com.example.elgaml.ecommerce.model.Cart.CartResponse;
import com.example.elgaml.ecommerce.model.FavouritModel.AddToFavourit;
import com.example.elgaml.ecommerce.model.FavouritModel.Datum;
import com.example.elgaml.ecommerce.model.FavouritModel.FavouritResponse;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

import static android.content.Context.MODE_PRIVATE;
import static com.example.elgaml.ecommerce.utils.Utils.isNetworkAvailable;
import static com.example.elgaml.ecommerce.utils.Utils.showToast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FavouriteFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FavouriteFragment extends Fragment implements FavouritRecyclerAdapter.FavouritListner {

    private FavouriteViewModel favouriteViewModel;
    private HomeViewModel      homeViewModel;
    private String mUSER_ID = "UserId";
    private SharedPreferences prefs;
    private static final String MY_PREFS_NAME = "UserAuth";
    private String token;
    private RecyclerView recyclerView_favourit;
    private List<Datum> mfavourit;
    private List<Datum> mfavouritSeperate;
    private FavouritRecyclerAdapter favouritRecyclerAdapter;
    private Toast toast;
    private ProgressBar progressBar;
    private BottomNavigationView navBar;
    private TextView fav_emputy;

    public static FavouriteFragment favouriteFragment;
    public FavouriteFragment() {
        // Required empty public constructor
    }

    public static FavouriteFragment newInstance(String param1, String param2) {
        FavouriteFragment fragment = new FavouriteFragment();

        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_favourit, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        progressBar=(ProgressBar)view.findViewById(R.id.progress_favourit);
        fav_emputy=(TextView)view.findViewById(R.id.fav_emputy);
        navBar = getActivity().findViewById(R.id.nav_view_bar);
        favouriteViewModel =new FavouriteViewModel();
        favouriteViewModel.init();

        homeViewModel= new HomeViewModel();
        homeViewModel.init();
        prefs = getContext().getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE);
        token = prefs.getString(mUSER_ID, "");
        mfavourit = new ArrayList<>();
        mfavouritSeperate = new ArrayList<>();

        Log.e("Token",token);
        progressBar.setVisibility(View.VISIBLE);
        recyclerView_favourit = (RecyclerView) view.findViewById(R.id.favourit_recycler);
        recyclerView_favourit.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));

        favouritRecyclerAdapter= new FavouritRecyclerAdapter(mfavourit,this);
        recyclerView_favourit.setAdapter(favouritRecyclerAdapter);

   //     hideBottomNavigationBar(recyclerView_favourit,navBar);

        favouriteViewModel.getFavourit(token).observe(getViewLifecycleOwner(), new Observer<FavouritResponse>() {
            @Override
            public void onChanged(FavouritResponse favouritResponse) {
                if(favouritResponse.getData().size()!=0){
                fav_emputy.setVisibility(View.GONE);
                mfavourit =favouritResponse.getData();
                favouritRecyclerAdapter.setList(mfavourit);
                favouritRecyclerAdapter.notifyDataSetChanged();
                progressBar.setVisibility(View.INVISIBLE);
            }else {
                progressBar.setVisibility(View.INVISIBLE);
                fav_emputy.setVisibility(View.VISIBLE);
                }
            }
        });
    }

    @Override
    public void onClickAddCart(final int postion) {

        if ( isNetworkAvailable(getContext())) {
            //default
            String quatatiy = "1";
            String size = "1";
            String color = "1";
            Datum model = mfavourit.get(postion);
            Log.e("productId",model.getId()+"");
            favouriteViewModel.add_to_cart(token, String.valueOf(model.getId()), quatatiy, size, color).observe(getViewLifecycleOwner(), new Observer<CartResponse>() {
                @Override
                public void onChanged(CartResponse cartResponse) {

                    //remove for favourit
                    homeViewModel.addFavourit(token, String.valueOf(mfavourit.get(postion).getId())).observe(getViewLifecycleOwner(), new Observer<AddToFavourit>() {
                        @Override
                        public void onChanged(AddToFavourit addToFavourit) {
                            mfavouritSeperate=mfavourit;
                            mfavouritSeperate.remove(postion);
                            favouritRecyclerAdapter.setList(mfavouritSeperate);
                            favouritRecyclerAdapter.notifyDataSetChanged();
                            showToast("Added Successfully",getContext(),toast);
                            showEmputyText(mfavouritSeperate);
                        }
                    });
                }
            });
        }else {
            showToast("No Internet Connection",getContext(),toast);
        }
    }


    @Override
    public void onClickDelet(final int postion) {

        //remove for favourit
        homeViewModel.addFavourit(token, String.valueOf(mfavourit.get(postion).getId())).observe(getViewLifecycleOwner(), new Observer<AddToFavourit>() {
            @Override
            public void onChanged(AddToFavourit addToFavourit) {
                mfavouritSeperate=mfavourit;
                mfavouritSeperate.remove(postion);
                favouritRecyclerAdapter.setList(mfavouritSeperate);
                favouritRecyclerAdapter.notifyDataSetChanged();
                showToast(addToFavourit.getMessage(),getContext(),toast);
                showEmputyText(mfavouritSeperate);

            }
        });
    }

    void showEmputyText(List<Datum> list){
        if (list.size()==0){
            fav_emputy.setVisibility(View.VISIBLE);
        }
    }
}