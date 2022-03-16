package katar.example.elgaml.ecommerce.favourite;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import katar.example.elgaml.ecommerce.home.HomeViewModel;
import com.example.elgaml.ecommerce.R;
import katar.example.elgaml.ecommerce.Recyclers.FavouritRecyclerAdapter;
import katar.example.elgaml.ecommerce.model.Cart.CartResponse;
import katar.example.elgaml.ecommerce.model.FavouritModel.AddToFavourit;
import katar.example.elgaml.ecommerce.model.FavouritModel.FavouriteResponseItem;
import katar.example.elgaml.ecommerce.model.User;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import static android.content.Context.MODE_PRIVATE;
import static katar.example.elgaml.ecommerce.utils.ProjectUtils.isNetworkAvailable;
import static katar.example.elgaml.ecommerce.utils.ProjectUtils.showToast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FavouriteFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FavouriteFragment extends Fragment implements FavouritRecyclerAdapter.FavouritListner {

    private FavouriteViewModel favouriteViewModel;
    private HomeViewModel      homeViewModel;
    private String mUSER_ID = "UserId";
    private String mUSER_Data ="UserData";
    private User user;
    private SharedPreferences prefs;
    private static final String MY_PREFS_NAME = "UserAuth";
    private RecyclerView recyclerView_favourit;
    private List<FavouriteResponseItem> mfavourit;
    private List<FavouriteResponseItem> mfavouritSeperate;
    private FavouritRecyclerAdapter favouritRecyclerAdapter;
    private Toast toast;
    private String userData;
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
        Gson gson=new Gson();
        userData = prefs.getString(mUSER_Data, "");
        user = gson.fromJson(userData, User.class);
        mfavourit = new ArrayList<>();
        mfavouritSeperate = new ArrayList<>();

        progressBar.setVisibility(View.VISIBLE);
        recyclerView_favourit = (RecyclerView) view.findViewById(R.id.favourit_recycler);
        recyclerView_favourit.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));

        favouritRecyclerAdapter= new FavouritRecyclerAdapter(mfavourit,this);
        recyclerView_favourit.setAdapter(favouritRecyclerAdapter);

        favouriteViewModel.getFavourit(user.getApiToken()).observe(getViewLifecycleOwner(), new Observer<List<FavouriteResponseItem>>() {
            @Override
            public void onChanged(List<FavouriteResponseItem> favouritResponse) {

                if(favouritResponse.size()!=0){
                fav_emputy.setVisibility(View.GONE);
                mfavourit =favouritResponse;
                favouritRecyclerAdapter.setList(mfavourit);
                onGetResponse(favouritResponse);
                }else {
                progressBar.setVisibility(View.INVISIBLE);
                fav_emputy.setVisibility(View.VISIBLE);
                }
            }
        });


    }

    private void onGetResponse(List<FavouriteResponseItem> favouritResponse)
    {
    progressBar.setVisibility(View.INVISIBLE);
    mfavourit = favouritResponse;
    favouritRecyclerAdapter.setList(mfavourit);
    favouritRecyclerAdapter.notifyDataSetChanged();
    }

    @Override
    public void onClickAddCart(final int postion) {
        FavouriteResponseItem model = mfavourit.get(postion);

        favouriteViewModel.add_to_cart(user.getApiToken(), String.valueOf(model.getId()))
                .observe(getViewLifecycleOwner(), new Observer<CartResponse>() {
                    @Override
                    public void onChanged(CartResponse cartResponse) {
                    }
                });
        if ( isNetworkAvailable(getContext())) {
            //default
            String quatatiy = "1";
            String size = "1";
            String color = "1";
            favouriteViewModel.add_to_cart(user.getApiToken(), String.valueOf(model.getId())).observe(getViewLifecycleOwner(), new Observer<CartResponse>() {
                @Override
                public void onChanged(CartResponse cartResponse) {

                    //remove from favourit
                    homeViewModel.addFavourit(user.getApiToken(), String.valueOf(mfavourit.get(postion).getId())).observe(getViewLifecycleOwner(), new Observer<AddToFavourit>() {
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
        homeViewModel.addFavourit(user.getApiToken(), String.valueOf(mfavourit.get(postion).getId())).observe(getViewLifecycleOwner(), new Observer<AddToFavourit>() {
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

    void showEmputyText(List<FavouriteResponseItem> list){
        if (list.size()==0){
            fav_emputy.setVisibility(View.VISIBLE);
        }
    }
}