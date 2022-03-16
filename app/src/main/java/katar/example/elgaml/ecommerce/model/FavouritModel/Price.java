package katar.example.elgaml.ecommerce.model.FavouritModel;

public class Price{
	private Country country;
	private String updatedAt;
	private String price;
	private int productId;
	private String createdAt;
	private int id;
	private int countryId;

	public Country getCountry(){
		return country;
	}

	public String getUpdatedAt(){
		return updatedAt;
	}

	public String getPrice(){
		return price;
	}

	public int getProductId(){
		return productId;
	}

	public String getCreatedAt(){
		return createdAt;
	}

	public int getId(){
		return id;
	}

	public int getCountryId(){
		return countryId;
	}
}
