
package com.example.elgaml.ecommerce.model.MyAccountModel;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class User {

    @SerializedName("activation")
    private Long mActivation;
    @SerializedName("address_id")
    private Object mAddressId;
    @SerializedName("api_token")
    private String mApiToken;
    @SerializedName("birth_date")
    private Object mBirthDate;
    @SerializedName("cart_count")
    private Long mCartCount;
    @SerializedName("country_id")
    private Object mCountryId;
    @SerializedName("cover")
    private String mCover;
    @SerializedName("created_at")
    private String mCreatedAt;
    @SerializedName("email")
    private String mEmail;
    @SerializedName("gender")
    private Object mGender;
    @SerializedName("id")
    private Long mId;
    @SerializedName("image")
    private String mImage;
    @SerializedName("mobile_token")
    private Object mMobileToken;
    @SerializedName("name")
    private String mName;
    @SerializedName("os")
    private Object mOs;
    @SerializedName("phone")
    private String mPhone;
    @SerializedName("reset_password_code")
    private Object mResetPasswordCode;
    @SerializedName("social_id")
    private Object mSocialId;
    @SerializedName("social_type")
    private Object mSocialType;
    @SerializedName("temp_phone_code")
    private Object mTempPhoneCode;
    @SerializedName("type")
    private Long mType;
    @SerializedName("updated_at")
    private String mUpdatedAt;

    public Long getActivation() {
        return mActivation;
    }

    public void setActivation(Long activation) {
        mActivation = activation;
    }

    public Object getAddressId() {
        return mAddressId;
    }

    public void setAddressId(Object addressId) {
        mAddressId = addressId;
    }

    public String getApiToken() {
        return mApiToken;
    }

    public void setApiToken(String apiToken) {
        mApiToken = apiToken;
    }

    public Object getBirthDate() {
        return mBirthDate;
    }

    public void setBirthDate(Object birthDate) {
        mBirthDate = birthDate;
    }

    public Long getCartCount() {
        return mCartCount;
    }

    public void setCartCount(Long cartCount) {
        mCartCount = cartCount;
    }

    public Object getCountryId() {
        return mCountryId;
    }

    public void setCountryId(Object countryId) {
        mCountryId = countryId;
    }

    public String getCover() {
        return mCover;
    }

    public void setCover(String cover) {
        mCover = cover;
    }

    public String getCreatedAt() {
        return mCreatedAt;
    }

    public void setCreatedAt(String createdAt) {
        mCreatedAt = createdAt;
    }

    public String getEmail() {
        return mEmail;
    }

    public void setEmail(String email) {
        mEmail = email;
    }

    public Object getGender() {
        return mGender;
    }

    public void setGender(Object gender) {
        mGender = gender;
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

    public Object getMobileToken() {
        return mMobileToken;
    }

    public void setMobileToken(Object mobileToken) {
        mMobileToken = mobileToken;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public Object getOs() {
        return mOs;
    }

    public void setOs(Object os) {
        mOs = os;
    }

    public String getPhone() {
        return mPhone;
    }

    public void setPhone(String phone) {
        mPhone = phone;
    }

    public Object getResetPasswordCode() {
        return mResetPasswordCode;
    }

    public void setResetPasswordCode(Object resetPasswordCode) {
        mResetPasswordCode = resetPasswordCode;
    }

    public Object getSocialId() {
        return mSocialId;
    }

    public void setSocialId(Object socialId) {
        mSocialId = socialId;
    }

    public Object getSocialType() {
        return mSocialType;
    }

    public void setSocialType(Object socialType) {
        mSocialType = socialType;
    }

    public Object getTempPhoneCode() {
        return mTempPhoneCode;
    }

    public void setTempPhoneCode(Object tempPhoneCode) {
        mTempPhoneCode = tempPhoneCode;
    }

    public Long getType() {
        return mType;
    }

    public void setType(Long type) {
        mType = type;
    }

    public String getUpdatedAt() {
        return mUpdatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        mUpdatedAt = updatedAt;
    }

}
