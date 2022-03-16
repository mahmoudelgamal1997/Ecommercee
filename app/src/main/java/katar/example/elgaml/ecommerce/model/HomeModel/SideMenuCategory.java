
package katar.example.elgaml.ecommerce.model.HomeModel;

import java.util.List;
import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class SideMenuCategory {

    @SerializedName("created_at")
    private String mCreatedAt;
    @SerializedName("icon")
    private String mIcon;
    @SerializedName("id")
    private Long mId;
    @SerializedName("image")
    private String mImage;
    @SerializedName("name_ar")
    private String mNameAr;
    @SerializedName("name_en")
    private String mNameEn;
    @SerializedName("special")
    private Long mSpecial;
    @SerializedName("status")
    private Long mStatus;
    @SerializedName("sub_categories_active")
    private List<SubCategoriesActive> mSubCategoriesActive;
    @SerializedName("sub_title_ar")
    private String mSubTitleAr;
    @SerializedName("sub_title_en")
    private String mSubTitleEn;
    @SerializedName("title_ar")
    private String mTitleAr;
    @SerializedName("title_en")
    private String mTitleEn;
    @SerializedName("updated_at")
    private String mUpdatedAt;

    public String getCreatedAt() {
        return mCreatedAt;
    }

    public void setCreatedAt(String createdAt) {
        mCreatedAt = createdAt;
    }

    public String getIcon() {
        return mIcon;
    }

    public void setIcon(String icon) {
        mIcon = icon;
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

    public Long getSpecial() {
        return mSpecial;
    }

    public void setSpecial(Long special) {
        mSpecial = special;
    }

    public Long getStatus() {
        return mStatus;
    }

    public void setStatus(Long status) {
        mStatus = status;
    }

    public List<SubCategoriesActive> getSubCategoriesActive() {
        return mSubCategoriesActive;
    }

    public void setSubCategoriesActive(List<SubCategoriesActive> subCategoriesActive) {
        mSubCategoriesActive = subCategoriesActive;
    }

    public String getSubTitleAr() {
        return mSubTitleAr;
    }

    public void setSubTitleAr(String subTitleAr) {
        mSubTitleAr = subTitleAr;
    }

    public String getSubTitleEn() {
        return mSubTitleEn;
    }

    public void setSubTitleEn(String subTitleEn) {
        mSubTitleEn = subTitleEn;
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

}
