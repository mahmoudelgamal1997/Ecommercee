
package com.example.elgaml.ecommerce.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SignUpErrorModel {

    @SerializedName("errors")
    @Expose
    private List<Error> errors = null;

    public List<Error> getErrors() {
        return errors;
    }

    public void setErrors(List<Error> errors)
    {
        this.errors = errors;
    }

}
