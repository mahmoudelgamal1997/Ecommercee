
package katar.example.elgaml.ecommerce.model.HomeModel;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class Blog {

    @SerializedName("content_ar")
    private String mContentAr;
    @SerializedName("content_en")
    private String mContentEn;
    @SerializedName("created_at")
    private String mCreatedAt;
    @SerializedName("friendly_url")
    private String mFriendlyUrl;
    @SerializedName("id")
    private Long mId;
    @SerializedName("image")
    private String mImage;
    @SerializedName("title_ar")
    private String mTitleAr;
    @SerializedName("title_en")
    private String mTitleEn;
    @SerializedName("updated_at")
    private String mUpdatedAt;
    @SerializedName("url")
    private String mUrl;

    public String getContentAr() {
        return mContentAr;
    }

    public void setContentAr(String contentAr) {
        mContentAr = contentAr;
    }

    public String getContentEn() {
        return mContentEn;
    }

    public void setContentEn(String contentEn) {
        mContentEn = contentEn;
    }

    public String getCreatedAt() {
        return mCreatedAt;
    }

    public void setCreatedAt(String createdAt) {
        mCreatedAt = createdAt;
    }

    public String getFriendlyUrl() {
        return mFriendlyUrl;
    }

    public void setFriendlyUrl(String friendlyUrl) {
        mFriendlyUrl = friendlyUrl;
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

    public String getTitleAr() {
        return mTitleAr;
    }

    public void setTitleAr(String titleAr) {
        mTitleAr = titleAr;
    }

    public String getTitleEn() {
        return mTitleEn;
    }

    public void setTitleEn(String titleEn) {
        mTitleEn = titleEn;
    }

    public String getUpdatedAt() {
        return mUpdatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        mUpdatedAt = updatedAt;
    }

    public String getUrl() {
        return mUrl;
    }

    public void setUrl(String url) {
        mUrl = url;
    }

}
