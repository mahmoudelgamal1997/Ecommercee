
package com.example.elgaml.ecommerce.model.FavouritModel;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class User {

    @SerializedName("cart_count")
    private Long mCartCount;
    @SerializedName("id")
    private Long mId;
    @SerializedName("image")
    private String mImage;
    @SerializedName("name")
    private String mName;

    public Long getCartCount() {
        return mCartCount;
    }

    public void setCartCount(Long cartCount) {
        mCartCount = cartCount;
    }

    public Long getId() {
        return mId;
    }

    public void setId(Long id) {
        mId = id;
    }

    public String getImage() {
        return mImage;
    }

    public void setImage(String image) {
        mImage = image;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

}
