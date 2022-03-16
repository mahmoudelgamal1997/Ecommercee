package com.example.elgaml.ecommerce.model.product;

import java.util.ArrayList;

public class Product {
    public int id;
    public String name_ar;
    public String name_en;
    public String description_ar;
    public String description_en;
    public int stock;
    public int status;
    public String shipping_specification;
    public SubCategory sub_category;
    public CreatedAt created_at;
    public UpdatedAt updated_at;
    public String long_description_ar;
    public String long_description_en;
    public int brand_id;
    public int disable;
    public int is_outofstock_allowed;
    public int best_seller;
    public int hot_deals;
    public Category category;
    public String shipping_specifications_ar;
    public String ingredients_en;
    public String ingredients_ar;
    public int provider_id;
    public int activation;
    public String default_image;
    public boolean is_fav;
    public int count_paid;
    public int total_rate;
    public boolean is_reviewed;
    public Price price;
    public String today_offer;
    public boolean has_offer;
    public ArrayList<Image> images;
}
