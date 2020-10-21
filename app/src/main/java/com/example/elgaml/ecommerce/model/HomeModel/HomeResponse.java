
package com.example.elgaml.ecommerce.model.HomeModel;

import java.util.List;
import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class HomeResponse {

    @SerializedName("best_seller")
    private List<BestSeller> mBestSeller;
    @SerializedName("hot_deals")
    private List<HotDeals> mHotDeals;
    @SerializedName("new_arrival")
    private List<NewArrival> mNewArrival;
    @SerializedName("side_menu_categories")
    private List<SideMenuCategory> mSideMenuCategories;
    @SerializedName("top_categories")
    private List<TopCategory> mTopCategories;

    public List<BestSeller> getBestSeller() {
        return mBestSeller;
    }

    public void setBestSeller(List<BestSeller> bestSeller) {
        mBestSeller = bestSeller;
    }

    public List<HotDeals> getHotDeals() {
        return mHotDeals;
    }

    public void setHotDeals(List<HotDeals> hotDeals) {
        mHotDeals = hotDeals;
    }

    public List<NewArrival> getNewArrival() {
        return mNewArrival;
    }

    public void setNewArrival(List<NewArrival> newArrival) {
        mNewArrival = newArrival;
    }

    public List<SideMenuCategory> getSideMenuCategories() {
        return mSideMenuCategories;
    }

    public void setSideMenuCategories(List<SideMenuCategory> sideMenuCategories) {
        mSideMenuCategories = sideMenuCategories;
    }

    public List<TopCategory> getTopCategories() {
        return mTopCategories;
    }

    public void setTopCategories(List<TopCategory> topCategories) {
        mTopCategories = topCategories;
    }

}
