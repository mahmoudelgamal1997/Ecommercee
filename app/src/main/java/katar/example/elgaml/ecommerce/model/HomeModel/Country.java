
package katar.example.elgaml.ecommerce.model.HomeModel;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class Country {

    @SerializedName("activation")
    private Long mActivation;
    @SerializedName("created_at")
    private String mCreatedAt;
    @SerializedName("currency_ar")
    private String mCurrencyAr;
    @SerializedName("currency_en")
    private String mCurrencyEn;
    @SerializedName("id")
    private Long mId;
    @SerializedName("image")
    private String mImage;
    @SerializedName("name_ar")
    private String mNameAr;
    @SerializedName("name_en")
    private String mNameEn;
    @SerializedName("updated_at")
    private String mUpdatedAt;

    public Long getActivation() {
        return mActivation;
    }

    public void setActivation(Long activation) {
        mActivation = activation;
    }

    public String getCreatedAt() {
        return mCreatedAt;
    }

    public void setCreatedAt(String createdAt) {
        mCreatedAt = createdAt;
    }

    public String getCurrencyAr() {
        return mCurrencyAr;
    }

    public void setCurrencyAr(String currencyAr) {
        mCurrencyAr = currencyAr;
    }

    public String getCurrencyEn() {
        return mCurrencyEn;
    }

    public void setCurrencyEn(String currencyEn) {
        mCurrencyEn = currencyEn;
    }

    public Long getId() {
        return mId;
    }

    public void setId(Long id) {
        mId = id;
    }

    public String getImage() {
        return mImage;
    }

    public void setImage(String image) {
        mImage = image;
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

    public String getUpdatedAt() {
        return mUpdatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        mUpdatedAt = updatedAt;
    }

}
