
package katar.example.elgaml.ecommerce.model.HomeModel;

import java.util.List;
import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class HotDeal {

    @SerializedName("activation")
    private Long mActivation;
    @SerializedName("best_seller")
    private Long mBestSeller;
    @SerializedName("brand_id")
    private Long mBrandId;
    @SerializedName("category")
    private Category mCategory;
    @SerializedName("count_paid")
    private Long mCountPaid;
    @SerializedName("created_at")
    private CreatedAt mCreatedAt;
    @SerializedName("default_image")
    private String mDefaultImage;
    @SerializedName("description_ar")
    private String mDescriptionAr;
    @SerializedName("description_en")
    private String mDescriptionEn;
    @SerializedName("disable")
    private Long mDisable;
    @SerializedName("has_offer")
    private Boolean mHasOffer;
    @SerializedName("hot_deals")
    private Long mHotDeals;
    @SerializedName("id")
    private Long mId;
    @SerializedName("images")
    private List<Image> mImages;
    @SerializedName("ingredients_ar")
    private String mIngredientsAr;
    @SerializedName("ingredients_en")
    private String mIngredientsEn;
    @SerializedName("is_fav")
    private Boolean mIsFav;
    @SerializedName("is_outofstock_allowed")
    private Long mIsOutofstockAllowed;
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
    private Price mPrice;
    @SerializedName("provider_id")
    private Long mProviderId;
    @SerializedName("shipping_specification")
    private String mShippingSpecification;
    @SerializedName("shipping_specifications_ar")
    private String mShippingSpecificationsAr;
    @SerializedName("status")
    private Long mStatus;
    @SerializedName("stock")
    private Long mStock;
    @SerializedName("sub_category")
    private SubCategory mSubCategory;
    @SerializedName("today_offer")
    private String mTodayOffer;
    @SerializedName("total_rate")
    private Long mTotalRate;
    @SerializedName("updated_at")
    private UpdatedAt mUpdatedAt;

    public Long getActivation() {
        return mActivation;
    }

    public void setActivation(Long activation) {
        mActivation = activation;
    }

    public Long getBestSeller() {
        return mBestSeller;
    }

    public void setBestSeller(Long bestSeller) {
        mBestSeller = bestSeller;
    }

    public Long getBrandId() {
        return mBrandId;
    }

    public void setBrandId(Long brandId) {
        mBrandId = brandId;
    }

    public Category getCategory() {
        return mCategory;
    }

    public void setCategory(Category category) {
        mCategory = category;
    }

    public Long getCountPaid() {
        return mCountPaid;
    }

    public void setCountPaid(Long countPaid) {
        mCountPaid = countPaid;
    }

    public CreatedAt getCreatedAt() {
        return mCreatedAt;
    }

    public void setCreatedAt(CreatedAt createdAt) {
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

    public Boolean getHasOffer() {
        return mHasOffer;
    }

    public void setHasOffer(Boolean hasOffer) {
        mHasOffer = hasOffer;
    }

    public Long getHotDeals() {
        return mHotDeals;
    }

    public void setHotDeals(Long hotDeals) {
        mHotDeals = hotDeals;
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

    public String getIngredientsAr() {
        return mIngredientsAr;
    }

    public void setIngredientsAr(String ingredientsAr) {
        mIngredientsAr = ingredientsAr;
    }

    public String getIngredientsEn() {
        return mIngredientsEn;
    }

    public void setIngredientsEn(String ingredientsEn) {
        mIngredientsEn = ingredientsEn;
    }

    public Boolean getIsFav() {
        return mIsFav;
    }

    public void setIsFav(Boolean isFav) {
        mIsFav = isFav;
    }

    public Long getIsOutofstockAllowed() {
        return mIsOutofstockAllowed;
    }

    public void setIsOutofstockAllowed(Long isOutofstockAllowed) {
        mIsOutofstockAllowed = isOutofstockAllowed;
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

    public Price getPrice() {
        return mPrice;
    }

    public void setPrice(Price price) {
        mPrice = price;
    }

    public Long getProviderId() {
        return mProviderId;
    }

    public void setProviderId(Long providerId) {
        mProviderId = providerId;
    }

    public String getShippingSpecification() {
        return mShippingSpecification;
    }

    public void setShippingSpecification(String shippingSpecification) {
        mShippingSpecification = shippingSpecification;
    }

    public String getShippingSpecificationsAr() {
        return mShippingSpecificationsAr;
    }

    public void setShippingSpecificationsAr(String shippingSpecificationsAr) {
        mShippingSpecificationsAr = shippingSpecificationsAr;
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

    public SubCategory getSubCategory() {
        return mSubCategory;
    }

    public void setSubCategory(SubCategory subCategory) {
        mSubCategory = subCategory;
    }

    public String getTodayOffer() {
        return mTodayOffer;
    }

    public void setTodayOffer(String todayOffer) {
        mTodayOffer = todayOffer;
    }

    public Long getTotalRate() {
        return mTotalRate;
    }

    public void setTotalRate(Long totalRate) {
        mTotalRate = totalRate;
    }

    public UpdatedAt getUpdatedAt() {
        return mUpdatedAt;
    }

    public void setUpdatedAt(UpdatedAt updatedAt) {
        mUpdatedAt = updatedAt;
    }

}
