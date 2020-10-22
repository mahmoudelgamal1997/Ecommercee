package com.example.elgaml.ecommerce.Fragment;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.elgaml.ecommerce.BuildConfig;
import com.example.elgaml.ecommerce.R;
import com.example.elgaml.ecommerce.model.MyAccountModel.UserResponse;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.squareup.picasso.Picasso;

import static android.content.Context.MODE_PRIVATE;

public class MyAccountFragment extends Fragment {

    MyAccountViewModel viewModel;
    private String USER_ID = "UserId";
    private String USER_NAME= "UserName";
    private String USER_EMAIL="UserEmail";
    private SharedPreferences prefs;
    private SharedPreferences.Editor editor ;
    private static final String MY_PREFS_NAME = "UserAuth";
    private String token,name,email;
    private ImageView userImage;
    TextView userName, userEmail;
    TextView icon_order,icon_address,icon_favourit,icon_cart;
    TextView title_order,title_address,title_favourit,title_cart;
    TextView next_order,next_favourit,next_cart,next_address,next_language,next_changePass,next_share,next_about;
    LinearLayout section1,section3,section_favourit,section_cart,section6,section7,section8, section_share,section10;

    public MyAccountFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static MyAccountFragment newInstance(String param1, String param2) {
        MyAccountFragment fragment = new MyAccountFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_account, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        viewModel = new MyAccountViewModel();
        viewModel.init();
        userImage = view.findViewById(R.id.userImage);
        userName = view.findViewById(R.id.userName);
        userEmail= view.findViewById(R.id.userEmail);
        prefs = getContext().getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE);
        editor = prefs.edit();
        token = prefs.getString(USER_ID, "");
        name=prefs.getString(USER_NAME,"");
        email=prefs.getString(USER_EMAIL,"");

        Toolbar toolbar=(Toolbar)view.findViewById(R.id.toolbar_account);
        toolbar.setTitle("");
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        TextView logout=(TextView)view.findViewById(R.id.logout);

        BottomNavigationView mBottomView=getActivity().findViewById(R.id.nav_view_bar);
        init(view);

        userName.setText(name);
        userEmail.setText(email);
        //loading data
        viewModel.getProfile(token).observe(getViewLifecycleOwner(), new Observer<UserResponse>() {
            @Override
            public void onChanged(UserResponse user) {
                userName.setText(name);
                userEmail.setText(email);
                loadImage(user.getUser().getImage(),userImage);
            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "Logged out", Toast.LENGTH_SHORT).show();
                editor.putBoolean("isExist", false); // Storing boolean
                editor.apply();
                getActivity().finish();
                viewModel.goToLogin(getView());
            }
        });

        section_cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CartFragment cartFragment= new CartFragment();
                changeFrgment(cartFragment);
                mBottomView.setSelectedItemId(R.id.cart_icon);
            }
        });

        section_favourit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FavouritFragment favouritFragment= new FavouritFragment();
                changeFrgment(favouritFragment);
                mBottomView.setSelectedItemId(R.id.favourit_icon);
            }
        });

        section_share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shareApp();
            }
        });
    }

     void loadImage(String url, ImageView img) {
        Picasso.get().load("http://e-commerce-dev.intcore.net/" + url).into(img);
    }
     void init(View view){
        Typeface font = Typeface.createFromAsset(getContext().getAssets(), "fonts/fontawesome.ttf");
        icon_order=(TextView)view.findViewById(R.id.icon_order);
        icon_address=(TextView)view.findViewById(R.id.icon_address);
        icon_favourit=(TextView)view.findViewById(R.id.icon_favourit);
        icon_cart  =(TextView)view.findViewById(R.id.icon_cart);

        icon_order.setTypeface(font);
        icon_address.setTypeface(font);
        icon_favourit.setTypeface(font);
        icon_cart.setTypeface(font);

        icon_order.setText("\uf07a");
        icon_address.setText("\uf07a");
        icon_favourit.setText("\uf004");
        icon_cart.setText("\uf07a");

        title_order=(TextView)view.findViewById(R.id.title_order);
        title_address=(TextView)view.findViewById(R.id.title_address);
        title_favourit=(TextView)view.findViewById(R.id.title_favourit);
        title_cart=(TextView)view.findViewById(R.id.title_cart);

        next_order = (TextView)view.findViewById(R.id.next_icon_order);
        next_favourit=(TextView)view.findViewById(R.id.next_icon_favourit);
        next_cart=(TextView)view.findViewById(R.id.next_icon_cart);
        next_address=(TextView)view.findViewById(R.id.next_icon_address);
        next_language=(TextView)view.findViewById(R.id.next_icon_language);
        next_changePass=(TextView)view.findViewById(R.id.next_icon_change);
        next_share=(TextView)view.findViewById(R.id.next_icon_share);
        next_about=(TextView)view.findViewById(R.id.next_icon_about);

        section1=(LinearLayout)view.findViewById(R.id.sectionFirst);
        section3=(LinearLayout)view.findViewById(R.id.section3);
        section_favourit=(LinearLayout)view.findViewById(R.id.section4);
        section_cart=(LinearLayout)view.findViewById(R.id.section5);
        section6=(LinearLayout)view.findViewById(R.id.section6);
        section7=(LinearLayout)view.findViewById(R.id.section7);
        section8=(LinearLayout)view.findViewById(R.id.section8);
        section_share =(LinearLayout)view.findViewById(R.id.section9);
        section10=(LinearLayout)view.findViewById(R.id.section10);

        next_order.setTypeface(font);
        next_order.setText("\uf054");

        next_favourit.setTypeface(font);
        next_favourit.setText("\uf054");

        next_cart.setTypeface(font);
        next_cart.setText("\uf054");

        next_address.setTypeface(font);
        next_address.setText("\uf054");

        next_language.setTypeface(font);
        next_language.setText("\uf054");

        next_changePass.setTypeface(font);
        next_changePass.setText("\uf054");

        next_share.setTypeface(font);
        next_share.setText("\uf054");

        next_about.setTypeface(font);
        next_about.setText("\uf054");

     }
     void changeFrgment(Fragment fragment){
               getActivity().getSupportFragmentManager().beginTransaction()
                .replace(R.id.main_fragment, fragment, "findThisFragment")
                .commit();
    }

     void shareApp(){
        try {
            Intent shareIntent = new Intent(Intent.ACTION_SEND);
            shareIntent.setType("text/plain");
            shareIntent.putExtra(Intent.EXTRA_SUBJECT, "My application name");
            String shareMessage= "\nLet me recommend you this application\n\n";
            shareMessage = shareMessage + "https://play.google.com/store/apps/details?id=" + BuildConfig.APPLICATION_ID +"\n\n";
            shareIntent.putExtra(Intent.EXTRA_TEXT, shareMessage);
            startActivity(Intent.createChooser(shareIntent, "choose one"));
        } catch(Exception e) {
            //e.toString();
        }
    }

}