package com.hust.htd.persistence.model;

public class Brand {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column brand.brand_id
     *
     * @mbggenerated Sun Oct 25 18:48:50 ICT 2015
     */
    private Long brandId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column brand.brand_name
     *
     * @mbggenerated Sun Oct 25 18:48:50 ICT 2015
     */
    private String brandName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column brand.brand_info
     *
     * @mbggenerated Sun Oct 25 18:48:50 ICT 2015
     */
    private String brandInfo;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column brand.brand_id
     *
     * @return the value of brand.brand_id
     *
     * @mbggenerated Sun Oct 25 18:48:50 ICT 2015
     */
    public Long getBrandId() {
        return brandId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column brand.brand_id
     *
     * @param brandId the value for brand.brand_id
     *
     * @mbggenerated Sun Oct 25 18:48:50 ICT 2015
     */
    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column brand.brand_name
     *
     * @return the value of brand.brand_name
     *
     * @mbggenerated Sun Oct 25 18:48:50 ICT 2015
     */
    public String getBrandName() {
        return brandName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column brand.brand_name
     *
     * @param brandName the value for brand.brand_name
     *
     * @mbggenerated Sun Oct 25 18:48:50 ICT 2015
     */
    public void setBrandName(String brandName) {
        this.brandName = brandName == null ? null : brandName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column brand.brand_info
     *
     * @return the value of brand.brand_info
     *
     * @mbggenerated Sun Oct 25 18:48:50 ICT 2015
     */
    public String getBrandInfo() {
        return brandInfo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column brand.brand_info
     *
     * @param brandInfo the value for brand.brand_info
     *
     * @mbggenerated Sun Oct 25 18:48:50 ICT 2015
     */
    public void setBrandInfo(String brandInfo) {
        this.brandInfo = brandInfo == null ? null : brandInfo.trim();
    }
}