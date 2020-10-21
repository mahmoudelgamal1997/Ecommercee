package com.example.elgaml.ecommerce.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.bumptech.glide.Glide;
import com.example.elgaml.ecommerce.R;

import static com.example.elgaml.ecommerce.Utils.Utils.isNetworkAvailable;

public class NoConnectionFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.no_connection,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final TextView retry=(TextView)view.findViewById(R.id.retry);
        final ImageView noConnection_img = (ImageView)view.findViewById(R.id.no_connection_image);
        final ImageView refresh_img = (ImageView)view.findViewById(R.id.refresh_img);
        final TextView text_no_connection  = ( TextView)view.findViewById(R.id.text_no_connection);

        Glide.with(view).asGif().load(R.drawable.loading).into(noConnection_img);
        refresh_img.setAnimation(rotateImage());


        retry.setOnClickListener(new View.OnClickListener() {
           @Override
            public void onClick(View v) {
               if (isNetworkAvailable(getContext())) {
                   //init state is home fragment
                   homeFrgament frgament = new homeFrgament();
                   changeFrgment(frgament);
               } }});
        }

        public Animation rotateImage(){
        Animation animation = new RotateAnimation(0.0f, 360.0f,
                Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF,
                0.5f);
        animation.setRepeatCount(-1);
        animation.setDuration(2000);
        return animation;
    }
    void changeFrgment(Fragment fragment){
        getActivity().getSupportFragmentManager().beginTransaction()
                .replace(R.id.main_fragment, fragment, "findThisFragment")
                .commit();
    }
}
