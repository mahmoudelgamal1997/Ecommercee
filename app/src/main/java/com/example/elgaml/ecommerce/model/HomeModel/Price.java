
package com.example.elgaml.ecommerce.model.HomeModel;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class Price {

    @SerializedName("country")
    private Country mCountry;
    @SerializedName("country_id")
    private Long mCountryId;
    @SerializedName("created_at")
    private String mCreatedAt;
    @SerializedName("id")
    private Long mId;
    @SerializedName("price")
    private String mPrice;
    @SerializedName("product_id")
    private Long mProductId;
    @SerializedName("updated_at")
    private String mUpdatedAt;

    public Country getCountry() {
        return mCountry;
    }

    public void setCountry(Country country) {
        mCountry = country;
    }

    public Long getCountryId() {
        return mCountryId;
    }

    public void setCountryId(Long countryId) {
        mCountryId = countryId;
    }

    public String getCreatedAt() {
        return mCreatedAt;
    }

    public void setCreatedAt(String createdAt) {
        mCreatedAt = createdAt;
    }

    public Long getId() {
        return mId;
    }

    public void setId(Long id) {
        mId = id;
    }

    public String getPrice() {
        return mPrice;
    }

    public void setPrice(String price) {
        mPrice = price;
    }

    public Long getProductId() {
        return mProductId;
    }

    public void setProductId(Long productId) {
        mProductId = productId;
    }

    public String getUpdatedAt() {
        return mUpdatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        mUpdatedAt = updatedAt;
    }

}
