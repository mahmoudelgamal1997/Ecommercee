
package com.example.elgaml.ecommerce.model.DealModel;

import java.util.List;

import com.example.elgaml.ecommerce.model.HomeModel.HotDeal;
import com.example.elgaml.ecommerce.model.HomeModel.TopCategory;
import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class DealResponse {

    @SerializedName("ads")
    private List<Ad> mAds;
    @SerializedName("hot_deals")
    private List<HotDeal> mHotDeals;
    @SerializedName("top_brand")
    private List<TopBrand> mTopBrand;
    @SerializedName("top_categories")
    private List<TopCategory> mTopCategories;

    public List<Ad> getAds() {
        return mAds;
    }

    public void setAds(List<Ad> ads) {
        mAds = ads;
    }

    public List<HotDeal> getHotDeals() {
        return mHotDeals;
    }

    public void setHotDeals(List<HotDeal> hotDeals) {
        mHotDeals = hotDeals;
    }

    public List<TopBrand> getTopBrand() {
        return mTopBrand;
    }

    public void setTopBrand(List<TopBrand> topBrand) {
        mTopBrand = topBrand;
    }

    public List<TopCategory> getTopCategories() {
        return mTopCategories;
    }

    public void setTopCategories(List<TopCategory> topCategories) {
        mTopCategories = topCategories;
    }

}
