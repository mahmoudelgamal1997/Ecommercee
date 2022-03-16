package com.example.elgaml.ecommerce.retrofit;

import com.example.elgaml.ecommerce.model.Cart.CartResponse;
import com.example.elgaml.ecommerce.model.ChangePasswordModel;
import com.example.elgaml.ecommerce.model.DealModel.DealResponse;
import com.example.elgaml.ecommerce.model.FavouritModel.AddToFavourit;
import com.example.elgaml.ecommerce.model.FavouritModel.FavouriteResponseItem;
import com.example.elgaml.ecommerce.model.ForgetPasswordModel;
import com.example.elgaml.ecommerce.model.MyAccountModel.UserResponse;
import com.example.elgaml.ecommerce.model.SignInModel;
import com.example.elgaml.ecommerce.model.SignUpModel;
import com.example.elgaml.ecommerce.model.HomeModel.HomeTestResponse;
import com.example.elgaml.ecommerce.model.product.ProductResponse;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Single;
import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface APIinterface {



    @FormUrlEncoded
    @POST(GlobalKeys.signIN)
    Call<SignInModel> signin(@Field("name") String name ,
                             @Field("password" ) String password);


    @FormUrlEncoded
    @POST(GlobalKeys.signUP)
    Call<SignUpModel> signup (@Field("name") String name ,
                              @Field("email") String email,
                              @Field("phone") String phone,
                              @Field("password" ) String password);

    @FormUrlEncoded
    @POST(GlobalKeys.sendResetPasswordCode)
    Single<ForgetPasswordModel> send_reset_password_code(@Field("phone") String phone);


    @PATCH(GlobalKeys.newPassword)
    Single<ChangePasswordModel> send_new_password(@Query("phone") String phone,
                                                @Query("reset_password_code") String reset_password_code,
                               @Query("password") String password);

    @GET(GlobalKeys.home)
    Observable<HomeTestResponse> getHome( );


    @FormUrlEncoded
    @POST(GlobalKeys.addFavourit)
    Single<AddToFavourit> add_Favourit(
            @Query("api_token") String api_token,
          //  @Field("api_token") String api_token,
                                       @Field("product_id") String product_id);

    @GET(GlobalKeys.getDeals)
    Observable<DealResponse> getDeals();

    @GET(GlobalKeys.getFavourit)
    Observable<List<FavouriteResponseItem>> getFavourit(@Query("api_token") String api_token);

    @FormUrlEncoded
    @POST(GlobalKeys.addCart)
    Observable<CartResponse> add_to_cart(@Field("api_token") String api_token,
                                         @Field("product_id") String product_id,
                                         @Field("quantity") String quantity);
                                      //   @Field("size_id") String size_id,
                                       //  @Field("color_id") String color_id);


    @GET(GlobalKeys.getCart)
    Single<CartResponse> getCarts(@Query("api_token") String api_token);



    @GET(GlobalKeys.profile)
    Single<UserResponse> getProfile(@Query("api_token")String api_token);

    @PATCH(GlobalKeys.updateCart)
    Single<CartResponse> updateCart(@Query("api_token") String api_token,
                                    @Query("quantity") int quantity,
                                    @Query("cart_id") int cart_id);

    @DELETE(GlobalKeys.deleteCart+"{cart_id}")
    Single<CartResponse> deleteCart(@Path("cart_id") int cart_id, @Query("api_token") String api_token );


    @GET(GlobalKeys.product+"{productId}")
    Single<ProductResponse> getProduct(@Path("productId") int productId);

}
