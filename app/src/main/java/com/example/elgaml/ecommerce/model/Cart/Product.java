
package com.example.elgaml.ecommerce.model.Cart;

import java.util.List;

import com.example.elgaml.ecommerce.model.HomeModel.Brand;
import com.example.elgaml.ecommerce.model.HomeModel.Subcategory;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Product {

    @Expose
    private Brand brand;
    @Expose
//    private List<Colors> colors;
    @SerializedName("count_paid")
    private int countPaid;
    @SerializedName("default_image")
    private String defaultImage;
    @SerializedName("friendly_url")
    private String friendlyUrl;
    @Expose
    private int id;
    @Expose
    private List<Image> images;
    @SerializedName("is_fav")
    private Boolean isFav;
    @SerializedName("is_reviewed")
    private Boolean isReviewed;
    @SerializedName("name_ar")
    private String nameAr;
    @SerializedName("name_en")
    private String nameEn;
    @Expose
    private int price;
    @Expose
    private List<Object> reviews;
//    @Expose
//    private List<Sizes> sizes;
//    @Expose
//    private int stock;
    @Expose
    private List<Subcategory> subcategory;
    @SerializedName("today_offer")
    private Object todayOffer;
    @SerializedName("total_rate")
    private Long totalRate;
    @Expose
    private String url;

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

//    public List<Colors> getColors() {
//        return colors;
//    }
//
//    public void setColors(List<Colors> colors) {
//        this.colors = colors;
//    }

    public int getCountPaid() {
        return countPaid;
    }

    public void setCountPaid(int countPaid) {
        this.countPaid = countPaid;
    }

    public String getDefaultImage() {
        return defaultImage;
    }

    public void setDefaultImage(String defaultImage) {
        this.defaultImage = defaultImage;
    }

    public String getFriendlyUrl() {
        return friendlyUrl;
    }

    public void setFriendlyUrl(String friendlyUrl) {
        this.friendlyUrl = friendlyUrl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    public Boolean getIsFav() {
        return isFav;
    }

    public void setIsFav(Boolean isFav) {
        this.isFav = isFav;
    }

    public Boolean getIsReviewed() {
        return isReviewed;
    }

    public void setIsReviewed(Boolean isReviewed) {
        this.isReviewed = isReviewed;
    }

    public String getNameAr() {
        return nameAr;
    }

    public void setNameAr(String nameAr) {
        this.nameAr = nameAr;
    }

    public String getNameEn() {
        return nameEn;
    }

    public void setNameEn(String nameEn) {
        this.nameEn = nameEn;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public List<Object> getReviews() {
        return reviews;
    }

    public void setReviews(List<Object> reviews) {
        this.reviews = reviews;
    }

//    public List<Sizes> getSizes() {
//        return sizes;
//    }

//    public void setSizes(List<Sizes> sizes) {
//        this.sizes = sizes;
//    }

//    public int getStock() {
//        return stock;
//    }

//    public void setStock(int stock) {
//        this.stock = stock;
//    }

    public List<Subcategory> getSubcategory() {
        return subcategory;
    }

    public void setSubcategory(List<Subcategory> subcategory) {
        this.subcategory = subcategory;
    }

    public Object getTodayOffer() {
        return todayOffer;
    }

    public void setTodayOffer(Object todayOffer) {
        this.todayOffer = todayOffer;
    }

    public Long getTotalRate() {
        return totalRate;
    }

    public void setTotalRate(Long totalRate) {
        this.totalRate = totalRate;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
