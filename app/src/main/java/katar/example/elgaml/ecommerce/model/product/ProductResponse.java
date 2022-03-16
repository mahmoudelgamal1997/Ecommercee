package katar.example.elgaml.ecommerce.model.product;

import java.util.ArrayList;

// import com.fasterxml.jackson.databind.ObjectMapper; // version 2.11.1
// import com.fasterxml.jackson.annotation.JsonProperty; // version 2.11.1
/* ObjectMapper om = new ObjectMapper();
Root root = om.readValue(myJsonString, Root.class); */
 class Category{
    public int id;
    public String name_ar;
    public String name_en;
    public int status;
    public String created_at;
    public String updated_at;
    public String image;
    public int special;
    public String icon;
    public String title_en;
    public String title_ar;
    public String sub_title_en;
    public String sub_title_ar;
}

 class SubCategory{
    public int id;
    public String name_ar;
    public String name_en;
    public int status;
    public int category_id;
    public String created_at;
    public String updated_at;
    public String title_en;
    public String title_ar;
    public Category category;
}

 class CreatedAt{
    public String date;
    public int timezone_type;
    public String timezone;
}

 class UpdatedAt{
    public String date;
    public int timezone_type;
    public String timezone;
}

 class Country{
    public int id;
    public String name_en;
    public String name_ar;
    public int activation;
    public String currency_en;
    public String currency_ar;
    public String created_at;
    public String updated_at;
    public String image;
}

 class Price{
    public int id;
    public int product_id;
    public int country_id;
    public String price;
    public String created_at;
    public String updated_at;
    public Country country;
}

 class Image{
    public int id;
    public String image;
    public int product_id;
    public String created_at;
    public String updated_at;
    public String type;
}

class SimilarProduct{
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

public class ProductResponse{
    public Product product;
    public ArrayList<SimilarProduct> similar_products;
}

