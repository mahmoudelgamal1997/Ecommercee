
package com.example.elgaml.ecommerce.model.HomeModel;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class SubCategory {

    @SerializedName("category_id")
    private Long mCategoryId;
    @SerializedName("created_at")
    private String mCreatedAt;
    @SerializedName("id")
    private Long mId;
    @SerializedName("name_ar")
    private String mNameAr;
    @SerializedName("name_en")
    private String mNameEn;
    @SerializedName("status")
    private Long mStatus;
    @SerializedName("title_ar")
    private String mTitleAr;
    @SerializedName("title_en")
    private String mTitleEn;
    @SerializedName("updated_at")
    private String mUpdatedAt;

    public Long getCategoryId() {
        return mCategoryId;
    }

    public void setCategoryId(Long categoryId) {
        mCategoryId = categoryId;
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

    public String getNameAr() {
        return mNameAr;
    }

    public void setNameAr(String nameAr) {
        mNameAr = nameAr;
    }

    public String getNameEn() {
        return mNameEn;
    }

    public void setNameEn(String nameEn) {
        mNameEn = nameEn;
    }

    public Long getStatus() {
        return mStatus;
    }

    public void setStatus(Long status) {
        mStatus = status;
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
