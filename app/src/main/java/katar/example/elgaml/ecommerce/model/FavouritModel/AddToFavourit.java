
package katar.example.elgaml.ecommerce.model.FavouritModel;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class AddToFavourit {

    @SerializedName("message")
    private String mMessage;

    public String getMessage() {
        return mMessage;
    }

    public void setMessage(String message) {
        mMessage = message;
    }

}
