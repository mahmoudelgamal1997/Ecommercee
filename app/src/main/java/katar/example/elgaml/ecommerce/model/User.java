
package katar.example.elgaml.ecommerce.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class User {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("phone")
    @Expose
    private String phone;
    @SerializedName("gender")
    @Expose
    private Integer gender;
    @SerializedName("birth_date")
    @Expose
    private String birthDate;
    @SerializedName("activation")
    @Expose
    private Integer activation;
    @SerializedName("type")
    @Expose
    private Integer type;
    @SerializedName("image")
    @Expose
    private String image;
    @SerializedName("cover")
    @Expose
    private String cover;
    @SerializedName("reset_password_code")
    @Expose
    private Object resetPasswordCode;
    @SerializedName("api_token")
    @Expose
    private String apiToken;
    @SerializedName("country_id")
    @Expose
    private Object countryId;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    @SerializedName("mobile_token")
    @Expose
    private Object mobileToken;
    @SerializedName("os")
    @Expose
    private Object os;
    @SerializedName("temp_phone_code")
    @Expose
    private String tempPhoneCode;
    @SerializedName("address_id")
    @Expose
    private Object addressId;
    @SerializedName("social_id")
    @Expose
    private Object socialId;
    @SerializedName("social_type")
    @Expose
    private Object socialType;
    @SerializedName("cart_count")
    @Expose
    private Integer cartCount;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public Integer getActivation() {
        return activation;
    }

    public void setActivation(Integer activation) {
        this.activation = activation;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public Object getResetPasswordCode() {
        return resetPasswordCode;
    }

    public void setResetPasswordCode(Object resetPasswordCode) {
        this.resetPasswordCode = resetPasswordCode;
    }

    public String getApiToken() {
        return apiToken;
    }

    public void setApiToken(String apiToken) {
        this.apiToken = apiToken;
    }

    public Object getCountryId() {
        return countryId;
    }

    public void setCountryId(Object countryId) {
        this.countryId = countryId;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Object getMobileToken() {
        return mobileToken;
    }

    public void setMobileToken(Object mobileToken) {
        this.mobileToken = mobileToken;
    }

    public Object getOs() {
        return os;
    }

    public void setOs(Object os) {
        this.os = os;
    }

    public String getTempPhoneCode() {
        return tempPhoneCode;
    }

    public void setTempPhoneCode(String tempPhoneCode) {
        this.tempPhoneCode = tempPhoneCode;
    }

    public Object getAddressId() {
        return addressId;
    }

    public void setAddressId(Object addressId) {
        this.addressId = addressId;
    }

    public Object getSocialId() {
        return socialId;
    }

    public void setSocialId(Object socialId) {
        this.socialId = socialId;
    }

    public Object getSocialType() {
        return socialType;
    }

    public void setSocialType(Object socialType) {
        this.socialType = socialType;
    }

    public Integer getCartCount() {
        return cartCount;
    }

    public void setCartCount(Integer cartCount) {
        this.cartCount = cartCount;
    }

}
