
package katar.example.elgaml.ecommerce.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SignInModel {

    @SerializedName("user")
    @Expose
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
