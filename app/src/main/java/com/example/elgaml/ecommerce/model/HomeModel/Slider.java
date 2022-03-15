
package com.example.elgaml.ecommerce.model.HomeModel;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class Slider {

    @SerializedName("created_at")
    private String mCreatedAt;
    @SerializedName("id")
    private Long mId;
    @SerializedName("image")
    private String mImage;
    @SerializedName("product_id")
    private Long mProductId;
    @SerializedName("status")
    private Long mStatus;
    @SerializedName("sub_title_ar")
    private String mSubTitleAr;
    @SerializedName("sub_title_en")
    private String mSubTitleEn;
    @SerializedName("title_ar")
    private String mTitleAr;
    @SerializedName("title_en")
    private String mTitleEn;
    @SerializedName("updated_at")
    private String mUpdatedAt;

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

    public String getImage() {
        return mImage;
    }

    public void setImage(String image) {
        mImage = image;
    }

    public Long getProductId() {
        return mProductId;
    }

    public void setProductId(Long productId) {
        mProductId = productId;
    }

    public Long getStatus() {
        return mStatus;
    }

    public void setStatus(Long status) {
        mStatus = status;
    }

    public String getSubTitleAr() {
        return mSubTitleAr;
    }

    public void setSubTitleAr(String subTitleAr) {
        mSubTitleAr = subTitleAr;
    }

    public String getSubTitleEn() {
        return mSubTitleEn;
    }

    public void setSubTitleEn(String subTitleEn) {
        mSubTitleEn = subTitleEn;
    }

    public String getTitleAr() {
        return mTitleAr;
    }

    public void setTitleAr(String titleAr) {
        mTitleAr = titleAr;
    }

    public String getTitleEn() {
        return mTitleEn;
    }

    public void setTitleEn(String titleEn) {
        mTitleEn = titleEn;
    }

    public String getUpdatedAt() {
        return mUpdatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        mUpdatedAt = updatedAt;
    }

}
