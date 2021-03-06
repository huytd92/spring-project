package com.hust.htd.persistence.model;

import java.util.Date;

public class User {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.user_id
     *
     * @mbggenerated Sun Oct 25 18:48:50 ICT 2015
     */
    private Long userId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.username
     *
     * @mbggenerated Sun Oct 25 18:48:50 ICT 2015
     */
    private String username;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.password
     *
     * @mbggenerated Sun Oct 25 18:48:50 ICT 2015
     */
    private String password;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.user_display_name
     *
     * @mbggenerated Sun Oct 25 18:48:50 ICT 2015
     */
    private String userDisplayName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.user_created_datetime
     *
     * @mbggenerated Sun Oct 25 18:48:50 ICT 2015
     */
    private Date userCreatedDatetime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.role_id
     *
     * @mbggenerated Sun Oct 25 18:48:50 ICT 2015
     */
    private Long roleId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.user_id
     *
     * @return the value of user.user_id
     *
     * @mbggenerated Sun Oct 25 18:48:50 ICT 2015
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.user_id
     *
     * @param userId the value for user.user_id
     *
     * @mbggenerated Sun Oct 25 18:48:50 ICT 2015
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.username
     *
     * @return the value of user.username
     *
     * @mbggenerated Sun Oct 25 18:48:50 ICT 2015
     */
    public String getUsername() {
        return username;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.username
     *
     * @param username the value for user.username
     *
     * @mbggenerated Sun Oct 25 18:48:50 ICT 2015
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.password
     *
     * @return the value of user.password
     *
     * @mbggenerated Sun Oct 25 18:48:50 ICT 2015
     */
    public String getPassword() {
        return password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.password
     *
     * @param password the value for user.password
     *
     * @mbggenerated Sun Oct 25 18:48:50 ICT 2015
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.user_display_name
     *
     * @return the value of user.user_display_name
     *
     * @mbggenerated Sun Oct 25 18:48:50 ICT 2015
     */
    public String getUserDisplayName() {
        return userDisplayName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.user_display_name
     *
     * @param userDisplayName the value for user.user_display_name
     *
     * @mbggenerated Sun Oct 25 18:48:50 ICT 2015
     */
    public void setUserDisplayName(String userDisplayName) {
        this.userDisplayName = userDisplayName == null ? null : userDisplayName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.user_created_datetime
     *
     * @return the value of user.user_created_datetime
     *
     * @mbggenerated Sun Oct 25 18:48:50 ICT 2015
     */
    public Date getUserCreatedDatetime() {
        return userCreatedDatetime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.user_created_datetime
     *
     * @param userCreatedDatetime the value for user.user_created_datetime
     *
     * @mbggenerated Sun Oct 25 18:48:50 ICT 2015
     */
    public void setUserCreatedDatetime(Date userCreatedDatetime) {
        this.userCreatedDatetime = userCreatedDatetime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.role_id
     *
     * @return the value of user.role_id
     *
     * @mbggenerated Sun Oct 25 18:48:50 ICT 2015
     */
    public Long getRoleId() {
        return roleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.role_id
     *
     * @param roleId the value for user.role_id
     *
     * @mbggenerated Sun Oct 25 18:48:50 ICT 2015
     */
    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }
}