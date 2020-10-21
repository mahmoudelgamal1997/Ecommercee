
package com.example.elgaml.ecommerce.model.MyAccountModel;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class UserResponse {

    @SerializedName("user")
    private User mUser;

    public User getUser() {
        return mUser;
    }

    public void setUser(User user) {
        mUser = user;
    }

}
