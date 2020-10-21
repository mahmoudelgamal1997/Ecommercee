
package com.example.elgaml.ecommerce.model.FavouritModel;

import java.util.List;
import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class Datum {

    @SerializedName("brand")
    private Object mBrand;
    @SerializedName("brand_id")
    private Object mBrandId;
    @SerializedName("colors")
    private List<Object> mColors;
    @SerializedName("count_paid")
    private Long mCountPaid;
    @SerializedName("created_at")
    private String mCreatedAt;
    @SerializedName("default_image")
    private String mDefaultImage;
    @SerializedName("description_ar")
    private String mDescriptionAr;
    @SerializedName("description_en")
    private String mDescriptionEn;
    @SerializedName("disable")
    private Long mDisable;
    @SerializedName("friendly_url")
    private String mFriendlyUrl;
    @SerializedName("id")
    private Long mId;
    @SerializedName("images")
    private List<Image> mImages;
    @SerializedName("is_fav")
    private Boolean mIsFav;
    @SerializedName("is_reviewed")
    private Boolean mIsReviewed;
    @SerializedName("long_description_ar")
    private String mLongDescriptionAr;
    @SerializedName("long_description_en")
    private String mLongDescriptionEn;
    @SerializedName("name_ar")
    private String mNameAr;
    @SerializedName("name_en")
    private String mNameEn;
    @SerializedName("price")
    private Long mPrice;
    @SerializedName("reviews")
    private List<Review> mReviews;
    @SerializedName("shipping_specification")
    private String mShippingSpecification;
    @SerializedName("sizes")
    private List<Object> mSizes;
    @SerializedName("status")
    private Long mStatus;
    @SerializedName("stock")
    private Long mStock;
    @SerializedName("sub_category_id")
    private Long mSubCategoryId;
    @SerializedName("subcategory")
    private Subcategory mSubcategory;
    @SerializedName("today_offer")
    private Object mTodayOffer;
    @SerializedName("total_rate")
    private Long mTotalRate;
    @SerializedName("updated_at")
    private String mUpdatedAt;
    @SerializedName("url")
    private String mUrl;

    public Object getBrand() {
        return mBrand;
    }

    public void setBrand(Object brand) {
        mBrand = brand;
    }

    public Object getBrandId() {
        return mBrandId;
    }

    public void setBrandId(Object brandId) {
        mBrandId = brandId;
    }

    public List<Object> getColors() {
        return mColors;
    }

    public void setColors(List<Object> colors) {
        mColors = colors;
    }

    public Long getCountPaid() {
        return mCountPaid;
    }

    public void setCountPaid(Long countPaid) {
        mCountPaid = countPaid;
    }

    public String getCreatedAt() {
        return mCreatedAt;
    }

    public void setCreatedAt(String createdAt) {
        mCreatedAt = createdAt;
    }

    public String getDefaultImage() {
        return mDefaultImage;
    }

    public void setDefaultImage(String defaultImage) {
        mDefaultImage = defaultImage;
    }

    public String getDescriptionAr() {
        return mDescriptionAr;
    }

    public void setDescriptionAr(String descriptionAr) {
        mDescriptionAr = descriptionAr;
    }

    public String getDescriptionEn() {
        return mDescriptionEn;
    }

    public void setDescriptionEn(String descriptionEn) {
        mDescriptionEn = descriptionEn;
    }

    public Long getDisable() {
        return mDisable;
    }

    public void setDisable(Long disable) {
        mDisable = disable;
    }

    public String getFriendlyUrl() {
        return mFriendlyUrl;
    }

    public void setFriendlyUrl(String friendlyUrl) {
        mFriendlyUrl = friendlyUrl;
    }

    public Long getId() {
        return mId;
    }

    public void setId(Long id) {
        mId = id;
    }

    public List<Image> getImages() {
        return mImages;
    }

    public void setImages(List<Image> images) {
        mImages = images;
    }

    public Boolean getIsFav() {
        return mIsFav;
    }

    public void setIsFav(Boolean isFav) {
        mIsFav = isFav;
    }

    public Boolean getIsReviewed() {
        return mIsReviewed;
    }

    public void setIsReviewed(Boolean isReviewed) {
        mIsReviewed = isReviewed;
    }

    public String getLongDescriptionAr() {
        return mLongDescriptionAr;
    }

    public void setLongDescriptionAr(String longDescriptionAr) {
        mLongDescriptionAr = longDescriptionAr;
    }

    public String getLongDescriptionEn() {
        return mLongDescriptionEn;
    }

    public void setLongDescriptionEn(String longDescriptionEn) {
        mLongDescriptionEn = longDescriptionEn;
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

    public Long getPrice() {
        return mPrice;
    }

    public void setPrice(Long price) {
        mPrice = price;
    }

    public List<Review> getReviews() {
        return mReviews;
    }

    public void setReviews(List<Review> reviews) {
        mReviews = reviews;
    }

    public String getShippingSpecification() {
        return mShippingSpecification;
    }

    public void setShippingSpecification(String shippingSpecification) {
        mShippingSpecification = shippingSpecification;
    }

    public List<Object> getSizes() {
        return mSizes;
    }

    public void setSizes(List<Object> sizes) {
        mSizes = sizes;
    }

    public Long getStatus() {
        return mStatus;
    }

    public void setStatus(Long status) {
        mStatus = status;
    }

    public Long getStock() {
        return mStock;
    }

    public void setStock(Long stock) {
        mStock = stock;
    }

    public Long getSubCategoryId() {
        return mSubCategoryId;
    }

    public void setSubCategoryId(Long subCategoryId) {
        mSubCategoryId = subCategoryId;
    }

    public Subcategory getSubcategory() {
        return mSubcategory;
    }

    public void setSubcategory(Subcategory subcategory) {
        mSubcategory = subcategory;
    }

    public Object getTodayOffer() {
        return mTodayOffer;
    }

    public void setTodayOffer(Object todayOffer) {
        mTodayOffer = todayOffer;
    }

    public Long getTotalRate() {
        return mTotalRate;
    }

    public void setTotalRate(Long totalRate) {
        mTotalRate = totalRate;
    }

    public String getUpdatedAt() {
        return mUpdatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        mUpdatedAt = updatedAt;
    }

    public String getUrl() {
        return mUrl;
    }

    public void setUrl(String url) {
        mUrl = url;
    }

}
