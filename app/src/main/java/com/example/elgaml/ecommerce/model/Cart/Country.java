package com.example.elgaml.ecommerce.model.Cart;

// import com.fasterxml.jackson.databind.ObjectMapper; // version 2.11.1
// import com.fasterxml.jackson.annotation.JsonProperty; // version 2.11.1
/* ObjectMapper om = new ObjectMapper();
Root root = om.readValue(myJsonString, Root.class); */
class Country {
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
