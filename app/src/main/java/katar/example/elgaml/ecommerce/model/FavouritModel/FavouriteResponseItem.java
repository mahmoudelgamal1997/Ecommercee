package katar.example.elgaml.ecommerce.model.FavouritModel;

import com.google.gson.annotations.SerializedName;

public class FavouriteResponseItem{
	@SerializedName("best_seller")
	private int bestSeller;
	@SerializedName("is_outofstock_allowed")
	private int isOutofstockAllowed;
	@SerializedName("ingredients_ar")
	private String ingredientsAr;
	@SerializedName("name_ar")
	private String nameAr;
	@SerializedName("long_description_en")
	private String longDescriptionEn;
	@SerializedName("total_rate")
	private int totalRate;
	private String createdAt;
	private String ingredientsEn;
	private String longDescriptionAr;
	private String updatedAt;
	private int categoryId;
	private int subCategoryId;
	@SerializedName("price")
	private Price price;
	private int hotDeals;
	@SerializedName("id")
	private int id;
	private int stock;
	private String descriptionEn;
	private boolean isFav;
	private String url;
	private int brandId;
	private boolean isReviewed;
	private int disable;
	private int countPaid;
	private Object providerId;
	@SerializedName("default_image")
	private String defaultImage;
	private String shippingSpecification;
	private int activation;
	@SerializedName("name_en")
	private String nameEn;
	@SerializedName("description_ar")
	private String descriptionAr;
	@SerializedName("status")
	private int status;
	private String shippingSpecificationsAr;

	public int getBestSeller(){
		return bestSeller;
	}

	public int getIsOutofstockAllowed(){
		return isOutofstockAllowed;
	}

	public String getIngredientsAr(){
		return ingredientsAr;
	}

	public String getNameAr(){
		return nameAr;
	}

	public String getLongDescriptionEn(){
		return longDescriptionEn;
	}

	public int getTotalRate(){
		return totalRate;
	}

	public String getCreatedAt(){
		return createdAt;
	}

	public String getIngredientsEn(){
		return ingredientsEn;
	}

	public String getLongDescriptionAr(){
		return longDescriptionAr;
	}

	public String getUpdatedAt(){
		return updatedAt;
	}

	public int getCategoryId(){
		return categoryId;
	}

	public int getSubCategoryId(){
		return subCategoryId;
	}

	public Price getPrice(){
		return price;
	}

	public int getHotDeals(){
		return hotDeals;
	}

	public int getId(){
		return id;
	}

	public int getStock(){
		return stock;
	}

	public String getDescriptionEn(){
		return descriptionEn;
	}

	public boolean isIsFav(){
		return isFav;
	}

	public String getUrl(){
		return url;
	}

	public int getBrandId(){
		return brandId;
	}

	public boolean isIsReviewed(){
		return isReviewed;
	}

	public int getDisable(){
		return disable;
	}

	public int getCountPaid(){
		return countPaid;
	}

	public Object getProviderId(){
		return providerId;
	}

	public String getDefaultImage(){
		return defaultImage;
	}

	public String getShippingSpecification(){
		return shippingSpecification;
	}

	public int getActivation(){
		return activation;
	}

	public String getNameEn(){
		return nameEn;
	}

	public String getDescriptionAr(){
		return descriptionAr;
	}

	public int getStatus(){
		return status;
	}

	public String getShippingSpecificationsAr(){
		return shippingSpecificationsAr;
	}
}
