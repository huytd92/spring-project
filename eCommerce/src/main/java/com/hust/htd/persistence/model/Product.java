package com.hust.htd.persistence.model;

import java.util.Date;

public class Product {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column product.product_id
     *
     * @mbggenerated Sun Oct 25 18:48:50 ICT 2015
     */
    private Long productId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column product.product_name
     *
     * @mbggenerated Sun Oct 25 18:48:50 ICT 2015
     */
    private String productName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column product.product_price
     *
     * @mbggenerated Sun Oct 25 18:48:50 ICT 2015
     */
    private Float productPrice;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column product.product_available
     *
     * @mbggenerated Sun Oct 25 18:48:50 ICT 2015
     */
    private Boolean productAvailable;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column product.product_short_desc
     *
     * @mbggenerated Sun Oct 25 18:48:50 ICT 2015
     */
    private String productShortDesc;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column product.product_sizes
     *
     * @mbggenerated Sun Oct 25 18:48:50 ICT 2015
     */
    private String productSizes;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column product.product_colors
     *
     * @mbggenerated Sun Oct 25 18:48:50 ICT 2015
     */
    private String productColors;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column product.product_seo_keyword
     *
     * @mbggenerated Sun Oct 25 18:48:50 ICT 2015
     */
    private String productSeoKeyword;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column product.brand_id
     *
     * @mbggenerated Sun Oct 25 18:48:50 ICT 2015
     */
    private Long brandId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column product.brand_name
     *
     * @mbggenerated Sun Oct 25 18:48:50 ICT 2015
     */
    private String brandName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column product.user_id
     *
     * @mbggenerated Sun Oct 25 18:48:50 ICT 2015
     */
    private Long userId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column product.user_display_name
     *
     * @mbggenerated Sun Oct 25 18:48:50 ICT 2015
     */
    private String userDisplayName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column product.product_image_url
     *
     * @mbggenerated Sun Oct 25 18:48:50 ICT 2015
     */
    private String productImageUrl;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column product.product_discounted
     *
     * @mbggenerated Sun Oct 25 18:48:50 ICT 2015
     */
    private Float productDiscounted;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column product.product_expired_datetime
     *
     * @mbggenerated Sun Oct 25 18:48:50 ICT 2015
     */
    private Date productExpiredDatetime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column product.product_viewed
     *
     * @mbggenerated Sun Oct 25 18:48:50 ICT 2015
     */
    private Integer productViewed;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column product.origin_id
     *
     * @mbggenerated Sun Oct 25 18:48:50 ICT 2015
     */
    private Long originId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column product.origin_name
     *
     * @mbggenerated Sun Oct 25 18:48:50 ICT 2015
     */
    private String originName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column product.product_created_datetime
     *
     * @mbggenerated Sun Oct 25 18:48:50 ICT 2015
     */
    private Date productCreatedDatetime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column product.product_best_seller
     *
     * @mbggenerated Sun Oct 25 18:48:50 ICT 2015
     */
    private Boolean productBestSeller;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column product.subcategory_id
     *
     * @mbggenerated Sun Oct 25 18:48:50 ICT 2015
     */
    private Long subcategoryId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column product.subcategory_name
     *
     * @mbggenerated Sun Oct 25 18:48:50 ICT 2015
     */
    private String subcategoryName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column product.product_long_desc
     *
     * @mbggenerated Sun Oct 25 18:48:50 ICT 2015
     */
    private String productLongDesc;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column product.product_id
     *
     * @return the value of product.product_id
     *
     * @mbggenerated Sun Oct 25 18:48:50 ICT 2015
     */
    public Long getProductId() {
        return productId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column product.product_id
     *
     * @param productId the value for product.product_id
     *
     * @mbggenerated Sun Oct 25 18:48:50 ICT 2015
     */
    public void setProductId(Long productId) {
        this.productId = productId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column product.product_name
     *
     * @return the value of product.product_name
     *
     * @mbggenerated Sun Oct 25 18:48:50 ICT 2015
     */
    public String getProductName() {
        return productName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column product.product_name
     *
     * @param productName the value for product.product_name
     *
     * @mbggenerated Sun Oct 25 18:48:50 ICT 2015
     */
    public void setProductName(String productName) {
        this.productName = productName == null ? null : productName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column product.product_price
     *
     * @return the value of product.product_price
     *
     * @mbggenerated Sun Oct 25 18:48:50 ICT 2015
     */
    public Float getProductPrice() {
        return productPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column product.product_price
     *
     * @param productPrice the value for product.product_price
     *
     * @mbggenerated Sun Oct 25 18:48:50 ICT 2015
     */
    public void setProductPrice(Float productPrice) {
        this.productPrice = productPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column product.product_available
     *
     * @return the value of product.product_available
     *
     * @mbggenerated Sun Oct 25 18:48:50 ICT 2015
     */
    public Boolean getProductAvailable() {
        return productAvailable;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column product.product_available
     *
     * @param productAvailable the value for product.product_available
     *
     * @mbggenerated Sun Oct 25 18:48:50 ICT 2015
     */
    public void setProductAvailable(Boolean productAvailable) {
        this.productAvailable = productAvailable;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column product.product_short_desc
     *
     * @return the value of product.product_short_desc
     *
     * @mbggenerated Sun Oct 25 18:48:50 ICT 2015
     */
    public String getProductShortDesc() {
        return productShortDesc;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column product.product_short_desc
     *
     * @param productShortDesc the value for product.product_short_desc
     *
     * @mbggenerated Sun Oct 25 18:48:50 ICT 2015
     */
    public void setProductShortDesc(String productShortDesc) {
        this.productShortDesc = productShortDesc == null ? null : productShortDesc.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column product.product_sizes
     *
     * @return the value of product.product_sizes
     *
     * @mbggenerated Sun Oct 25 18:48:50 ICT 2015
     */
    public String getProductSizes() {
        return productSizes;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column product.product_sizes
     *
     * @param productSizes the value for product.product_sizes
     *
     * @mbggenerated Sun Oct 25 18:48:50 ICT 2015
     */
    public void setProductSizes(String productSizes) {
        this.productSizes = productSizes == null ? null : productSizes.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column product.product_colors
     *
     * @return the value of product.product_colors
     *
     * @mbggenerated Sun Oct 25 18:48:50 ICT 2015
     */
    public String getProductColors() {
        return productColors;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column product.product_colors
     *
     * @param productColors the value for product.product_colors
     *
     * @mbggenerated Sun Oct 25 18:48:50 ICT 2015
     */
    public void setProductColors(String productColors) {
        this.productColors = productColors == null ? null : productColors.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column product.product_seo_keyword
     *
     * @return the value of product.product_seo_keyword
     *
     * @mbggenerated Sun Oct 25 18:48:50 ICT 2015
     */
    public String getProductSeoKeyword() {
        return productSeoKeyword;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column product.product_seo_keyword
     *
     * @param productSeoKeyword the value for product.product_seo_keyword
     *
     * @mbggenerated Sun Oct 25 18:48:50 ICT 2015
     */
    public void setProductSeoKeyword(String productSeoKeyword) {
        this.productSeoKeyword = productSeoKeyword == null ? null : productSeoKeyword.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column product.brand_id
     *
     * @return the value of product.brand_id
     *
     * @mbggenerated Sun Oct 25 18:48:50 ICT 2015
     */
    public Long getBrandId() {
        return brandId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column product.brand_id
     *
     * @param brandId the value for product.brand_id
     *
     * @mbggenerated Sun Oct 25 18:48:50 ICT 2015
     */
    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column product.brand_name
     *
     * @return the value of product.brand_name
     *
     * @mbggenerated Sun Oct 25 18:48:50 ICT 2015
     */
    public String getBrandName() {
        return brandName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column product.brand_name
     *
     * @param brandName the value for product.brand_name
     *
     * @mbggenerated Sun Oct 25 18:48:50 ICT 2015
     */
    public void setBrandName(String brandName) {
        this.brandName = brandName == null ? null : brandName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column product.user_id
     *
     * @return the value of product.user_id
     *
     * @mbggenerated Sun Oct 25 18:48:50 ICT 2015
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column product.user_id
     *
     * @param userId the value for product.user_id
     *
     * @mbggenerated Sun Oct 25 18:48:50 ICT 2015
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column product.user_display_name
     *
     * @return the value of product.user_display_name
     *
     * @mbggenerated Sun Oct 25 18:48:50 ICT 2015
     */
    public String getUserDisplayName() {
        return userDisplayName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column product.user_display_name
     *
     * @param userDisplayName the value for product.user_display_name
     *
     * @mbggenerated Sun Oct 25 18:48:50 ICT 2015
     */
    public void setUserDisplayName(String userDisplayName) {
        this.userDisplayName = userDisplayName == null ? null : userDisplayName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column product.product_image_url
     *
     * @return the value of product.product_image_url
     *
     * @mbggenerated Sun Oct 25 18:48:50 ICT 2015
     */
    public String getProductImageUrl() {
        return productImageUrl;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column product.product_image_url
     *
     * @param productImageUrl the value for product.product_image_url
     *
     * @mbggenerated Sun Oct 25 18:48:50 ICT 2015
     */
    public void setProductImageUrl(String productImageUrl) {
        this.productImageUrl = productImageUrl == null ? null : productImageUrl.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column product.product_discounted
     *
     * @return the value of product.product_discounted
     *
     * @mbggenerated Sun Oct 25 18:48:50 ICT 2015
     */
    public Float getProductDiscounted() {
        return productDiscounted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column product.product_discounted
     *
     * @param productDiscounted the value for product.product_discounted
     *
     * @mbggenerated Sun Oct 25 18:48:50 ICT 2015
     */
    public void setProductDiscounted(Float productDiscounted) {
        this.productDiscounted = productDiscounted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column product.product_expired_datetime
     *
     * @return the value of product.product_expired_datetime
     *
     * @mbggenerated Sun Oct 25 18:48:50 ICT 2015
     */
    public Date getProductExpiredDatetime() {
        return productExpiredDatetime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column product.product_expired_datetime
     *
     * @param productExpiredDatetime the value for product.product_expired_datetime
     *
     * @mbggenerated Sun Oct 25 18:48:50 ICT 2015
     */
    public void setProductExpiredDatetime(Date productExpiredDatetime) {
        this.productExpiredDatetime = productExpiredDatetime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column product.product_viewed
     *
     * @return the value of product.product_viewed
     *
     * @mbggenerated Sun Oct 25 18:48:50 ICT 2015
     */
    public Integer getProductViewed() {
        return productViewed;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column product.product_viewed
     *
     * @param productViewed the value for product.product_viewed
     *
     * @mbggenerated Sun Oct 25 18:48:50 ICT 2015
     */
    public void setProductViewed(Integer productViewed) {
        this.productViewed = productViewed;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column product.origin_id
     *
     * @return the value of product.origin_id
     *
     * @mbggenerated Sun Oct 25 18:48:50 ICT 2015
     */
    public Long getOriginId() {
        return originId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column product.origin_id
     *
     * @param originId the value for product.origin_id
     *
     * @mbggenerated Sun Oct 25 18:48:50 ICT 2015
     */
    public void setOriginId(Long originId) {
        this.originId = originId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column product.origin_name
     *
     * @return the value of product.origin_name
     *
     * @mbggenerated Sun Oct 25 18:48:50 ICT 2015
     */
    public String getOriginName() {
        return originName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column product.origin_name
     *
     * @param originName the value for product.origin_name
     *
     * @mbggenerated Sun Oct 25 18:48:50 ICT 2015
     */
    public void setOriginName(String originName) {
        this.originName = originName == null ? null : originName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column product.product_created_datetime
     *
     * @return the value of product.product_created_datetime
     *
     * @mbggenerated Sun Oct 25 18:48:50 ICT 2015
     */
    public Date getProductCreatedDatetime() {
        return productCreatedDatetime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column product.product_created_datetime
     *
     * @param productCreatedDatetime the value for product.product_created_datetime
     *
     * @mbggenerated Sun Oct 25 18:48:50 ICT 2015
     */
    public void setProductCreatedDatetime(Date productCreatedDatetime) {
        this.productCreatedDatetime = productCreatedDatetime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column product.product_best_seller
     *
     * @return the value of product.product_best_seller
     *
     * @mbggenerated Sun Oct 25 18:48:50 ICT 2015
     */
    public Boolean getProductBestSeller() {
        return productBestSeller;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column product.product_best_seller
     *
     * @param productBestSeller the value for product.product_best_seller
     *
     * @mbggenerated Sun Oct 25 18:48:50 ICT 2015
     */
    public void setProductBestSeller(Boolean productBestSeller) {
        this.productBestSeller = productBestSeller;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column product.subcategory_id
     *
     * @return the value of product.subcategory_id
     *
     * @mbggenerated Sun Oct 25 18:48:50 ICT 2015
     */
    public Long getSubcategoryId() {
        return subcategoryId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column product.subcategory_id
     *
     * @param subcategoryId the value for product.subcategory_id
     *
     * @mbggenerated Sun Oct 25 18:48:50 ICT 2015
     */
    public void setSubcategoryId(Long subcategoryId) {
        this.subcategoryId = subcategoryId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column product.subcategory_name
     *
     * @return the value of product.subcategory_name
     *
     * @mbggenerated Sun Oct 25 18:48:50 ICT 2015
     */
    public String getSubcategoryName() {
        return subcategoryName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column product.subcategory_name
     *
     * @param subcategoryName the value for product.subcategory_name
     *
     * @mbggenerated Sun Oct 25 18:48:50 ICT 2015
     */
    public void setSubcategoryName(String subcategoryName) {
        this.subcategoryName = subcategoryName == null ? null : subcategoryName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column product.product_long_desc
     *
     * @return the value of product.product_long_desc
     *
     * @mbggenerated Sun Oct 25 18:48:50 ICT 2015
     */
    public String getProductLongDesc() {
        return productLongDesc;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column product.product_long_desc
     *
     * @param productLongDesc the value for product.product_long_desc
     *
     * @mbggenerated Sun Oct 25 18:48:50 ICT 2015
     */
    public void setProductLongDesc(String productLongDesc) {
        this.productLongDesc = productLongDesc == null ? null : productLongDesc.trim();
    }
}