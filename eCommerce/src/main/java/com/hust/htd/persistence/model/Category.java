package com.hust.htd.persistence.model;

public class Category {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column category.category_id
     *
     * @mbggenerated Sun Oct 25 18:48:50 ICT 2015
     */
    private Long categoryId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column category.category_name
     *
     * @mbggenerated Sun Oct 25 18:48:50 ICT 2015
     */
    private String categoryName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column category.category_info
     *
     * @mbggenerated Sun Oct 25 18:48:50 ICT 2015
     */
    private String categoryInfo;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column category.category_id
     *
     * @return the value of category.category_id
     *
     * @mbggenerated Sun Oct 25 18:48:50 ICT 2015
     */
    public Long getCategoryId() {
        return categoryId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column category.category_id
     *
     * @param categoryId the value for category.category_id
     *
     * @mbggenerated Sun Oct 25 18:48:50 ICT 2015
     */
    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column category.category_name
     *
     * @return the value of category.category_name
     *
     * @mbggenerated Sun Oct 25 18:48:50 ICT 2015
     */
    public String getCategoryName() {
        return categoryName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column category.category_name
     *
     * @param categoryName the value for category.category_name
     *
     * @mbggenerated Sun Oct 25 18:48:50 ICT 2015
     */
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName == null ? null : categoryName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column category.category_info
     *
     * @return the value of category.category_info
     *
     * @mbggenerated Sun Oct 25 18:48:50 ICT 2015
     */
    public String getCategoryInfo() {
        return categoryInfo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column category.category_info
     *
     * @param categoryInfo the value for category.category_info
     *
     * @mbggenerated Sun Oct 25 18:48:50 ICT 2015
     */
    public void setCategoryInfo(String categoryInfo) {
        this.categoryInfo = categoryInfo == null ? null : categoryInfo.trim();
    }
}