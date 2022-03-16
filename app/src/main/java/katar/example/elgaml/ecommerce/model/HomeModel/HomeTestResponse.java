
package katar.example.elgaml.ecommerce.model.HomeModel;

import java.util.List;
import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class HomeTestResponse {

    @SerializedName("ad")
    private Ad mAd;
    @SerializedName("best_seller")
    private List<BestSeller> mBestSeller;
    @SerializedName("blog")
    private List<Blog> mBlog;
    @SerializedName("brands")
    private List<Brand> mBrands;
    @SerializedName("hot_deals")
    private List<HotDeal> mHotDeals;
    @SerializedName("new_arrival")
    private List<NewArrival> mNewArrival;
    @SerializedName("settings")
    private Settings mSettings;
    @SerializedName("side_menu_categories")
    private List<SideMenuCategory> mSideMenuCategories;
    @SerializedName("sliders")
    private List<Slider> mSliders;
    @SerializedName("sub_categories")
    private List<SubCategory> mSubCategories;
    @SerializedName("top_categories")
    private List<TopCategory> mTopCategories;

    public Ad getAd() {
        return mAd;
    }

    public void setAd(Ad ad) {
        mAd = ad;
    }

    public List<BestSeller> getBestSeller() {
        return mBestSeller;
    }

    public void setBestSeller(List<BestSeller> bestSeller) {
        mBestSeller = bestSeller;
    }

    public List<Blog> getBlog() {
        return mBlog;
    }

    public void setBlog(List<Blog> blog) {
        mBlog = blog;
    }

    public List<Brand> getBrands() {
        return mBrands;
    }

    public void setBrands(List<Brand> brands) {
        mBrands = brands;
    }

    public List<HotDeal> getHotDeals() {
        return mHotDeals;
    }

    public void setHotDeals(List<HotDeal> hotDeals) {
        mHotDeals = hotDeals;
    }

    public List<NewArrival> getNewArrival() {
        return mNewArrival;
    }

    public void setNewArrival(List<NewArrival> newArrival) {
        mNewArrival = newArrival;
    }

    public Settings getSettings() {
        return mSettings;
    }

    public void setSettings(Settings settings) {
        mSettings = settings;
    }

    public List<SideMenuCategory> getSideMenuCategories() {
        return mSideMenuCategories;
    }

    public void setSideMenuCategories(List<SideMenuCategory> sideMenuCategories) {
        mSideMenuCategories = sideMenuCategories;
    }

    public List<Slider> getSliders() {
        return mSliders;
    }

    public void setSliders(List<Slider> sliders) {
        mSliders = sliders;
    }

    public List<SubCategory> getSubCategories() {
        return mSubCategories;
    }

    public void setSubCategories(List<SubCategory> subCategories) {
        mSubCategories = subCategories;
    }

    public List<TopCategory> getTopCategories() {
        return mTopCategories;
    }

    public void setTopCategories(List<TopCategory> topCategories) {
        mTopCategories = topCategories;
    }

}
