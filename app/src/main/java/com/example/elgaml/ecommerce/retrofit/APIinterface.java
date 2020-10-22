package com.example.elgaml.ecommerce.retrofit;

import com.example.elgaml.ecommerce.model.Cart.CartResponse;
import com.example.elgaml.ecommerce.model.ChangePasswordModel;
import com.example.elgaml.ecommerce.model.DealModel.DealResponse;
import com.example.elgaml.ecommerce.model.FavouritModel.AddToFavourit;
import com.example.elgaml.ecommerce.model.FavouritModel.FavouritResponse;
import com.example.elgaml.ecommerce.model.ForgetPasswordModel;
import com.example.elgaml.ecommerce.model.HomeModel.HomeResponse;
import com.example.elgaml.ecommerce.model.MyAccountModel.UserResponse;
import com.example.elgaml.ecommerce.model.SignInModel;
import com.example.elgaml.ecommerce.model.SignUpModel;

import io.reactivex.Observable;
import io.reactivex.Single;
import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface APIinterface {
    @FormUrlEncoded
    @Headers({
            "Accept: application/json",
            "Content-Type: application/x-www-form-urlencoded"
    })
    @POST("v1/user/auth/signin")
    Call<SignInModel> signin(@Field("name") String name ,
                             @Field("password" ) String password);


    @FormUrlEncoded
    @Headers({
            "Accept: application/json",
            "Content-Type: application/x-www-form-urlencoded"
    })
    @POST("v1/user/auth/signup")
    Call<SignUpModel> signup (@Field("name") String name ,
                              @Field("email") String email,
                              @Field("phone") String phone,
                              @Field("password" ) String password);


    @FormUrlEncoded
    @Headers({
            "Accept: application/json",
            "Content-Type: application/x-www-form-urlencoded"
    })
    @POST("v1/user/auth/send-reset-password-code")
    Single<ForgetPasswordModel> send_reset_password(@Field("phone") String phone);





    @Headers({
            "Accept: application/json",
            "Content-Type: application/x-www-form-urlencoded"
    })

    @PATCH("v1/user/auth/reset-password")
    Single<ChangePasswordModel> send_new_password(@Query("phone") String phone,
                                                @Query("reset_password_code") String reset_password_code,
                               @Query("password") String password);






    @Headers({
            "Accept: application/json",
            "Content-Type: application/x-www-form-urlencoded"
    })
    @GET("v1/user/app/home")
    Observable<HomeResponse> getHome(@Query("api_token")String api_token);




    @FormUrlEncoded
    @Headers({
            "Accept: application/json",
            "Content-Type: application/x-www-form-urlencoded"
    })
    @POST("v1/user/app/action/favourite")
    Single<AddToFavourit> add_Favourit(@Field("api_token") String api_token,
                                       @Field("product_id") String product_id);






    @Headers({
            "Accept: application/json",
            "Content-Type: application/x-www-form-urlencoded"
    })
    @GET("v1/user/app/deals-page")
    Observable<DealResponse> getDeals();




    @Headers({
            "Accept: application/json",
            "Content-Type: application/x-www-form-urlencoded"
    })
    @GET("v1/user/auth/favourite")
    Observable<FavouritResponse> getFavourit(@Query("api_token") String api_token);



    @FormUrlEncoded
    @Headers({
            "Accept: application/json",
            "Content-Type: application/x-www-form-urlencoded"
    })
    @POST("v1/user/app/cart/add")
    Observable<CartResponse> add_to_cart(@Field("api_token") String api_token,
                                         @Field("product_id") String product_id,
                                         @Field("quantity") String quantity,
                                         @Field("size_id") String size_id,
                                         @Field("color_id") String color_id);


    @Headers({"Accept: application/json", "Content-Type: application/x-www-form-urlencoded"})
    @GET("v1/user/app/cart/get-carts")
    Single<CartResponse> getCarts(@Query("api_token") String api_token);



    @Headers({
            "Accept: application/json",
            "Content-Type: application/x-www-form-urlencoded"
    })
    @GET("v1/user/auth/get-profile")
    Single<UserResponse> getProfile(@Query("api_token")String api_token);



    @Headers({"Accept: application/json", "Content-Type: application/x-www-form-urlencoded"})
    @PATCH("v1/user/app/cart/update-cart")
    Single<CartResponse> updateCart(@Query("api_token") String api_token,
                                    @Query("quantity") int quantity,
                                    @Query("cart_id") int cart_id);


    @Headers({"Accept: application/json", "Content-Type: application/x-www-form-urlencoded"})
    @DELETE("v1/user/app/cart/delete/{cart_id}")
    Single<CartResponse> deleteCart(@Path("cart_id") int cart_id, @Query("api_token") String api_token );


}
