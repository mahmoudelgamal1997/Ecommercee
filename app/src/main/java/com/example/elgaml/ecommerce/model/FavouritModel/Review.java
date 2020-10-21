
package com.example.elgaml.ecommerce.model.FavouritModel;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class Review {

    @SerializedName("created_at")
    private String mCreatedAt;
    @SerializedName("date")
    private String mDate;
    @SerializedName("id")
    private Long mId;
    @SerializedName("product_id")
    private Long mProductId;
    @SerializedName("rate")
    private Long mRate;
    @SerializedName("review")
    private String mReview;
    @SerializedName("status")
    private Long mStatus;
    @SerializedName("updated_at")
    private String mUpdatedAt;
    @SerializedName("user")
    private User mUser;
    @SerializedName("user_id")
    private Long mUserId;

    public String getCreatedAt() {
        return mCreatedAt;
    }

    public void setCreatedAt(String createdAt) {
        mCreatedAt = createdAt;
    }

    public String getDate() {
        return mDate;
    }

    public void setDate(String date) {
        mDate = date;
    }

    public Long getId() {
        return mId;
    }

    public void setId(Long id) {
        mId = id;
    }

    public Long getProductId() {
        return mProductId;
    }

    public void setProductId(Long productId) {
        mProductId = productId;
    }

    public Long getRate() {
        return mRate;
    }

    public void setRate(Long rate) {
        mRate = rate;
    }

    public String getReview() {
        return mReview;
    }

    public void setReview(String review) {
        mReview = review;
    }

    public Long getStatus() {
        return mStatus;
    }

    public void setStatus(Long status) {
        mStatus = status;
    }

    public String getUpdatedAt() {
        return mUpdatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        mUpdatedAt = updatedAt;
    }

    public User getUser() {
        return mUser;
    }

    public void setUser(User user) {
        mUser = user;
    }

    public Long getUserId() {
        return mUserId;
    }

    public void setUserId(Long userId) {
        mUserId = userId;
    }

}
