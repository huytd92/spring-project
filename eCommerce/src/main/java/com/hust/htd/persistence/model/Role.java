package com.hust.htd.persistence.model;

public class Role {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column role.role_id
     *
     * @mbggenerated Sun Oct 25 18:48:50 ICT 2015
     */
    private Long roleId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column role.role_name
     *
     * @mbggenerated Sun Oct 25 18:48:50 ICT 2015
     */
    private String roleName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column role.role_info
     *
     * @mbggenerated Sun Oct 25 18:48:50 ICT 2015
     */
    private String roleInfo;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column role.role_id
     *
     * @return the value of role.role_id
     *
     * @mbggenerated Sun Oct 25 18:48:50 ICT 2015
     */
    public Long getRoleId() {
        return roleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column role.role_id
     *
     * @param roleId the value for role.role_id
     *
     * @mbggenerated Sun Oct 25 18:48:50 ICT 2015
     */
    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column role.role_name
     *
     * @return the value of role.role_name
     *
     * @mbggenerated Sun Oct 25 18:48:50 ICT 2015
     */
    public String getRoleName() {
        return roleName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column role.role_name
     *
     * @param roleName the value for role.role_name
     *
     * @mbggenerated Sun Oct 25 18:48:50 ICT 2015
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column role.role_info
     *
     * @return the value of role.role_info
     *
     * @mbggenerated Sun Oct 25 18:48:50 ICT 2015
     */
    public String getRoleInfo() {
        return roleInfo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column role.role_info
     *
     * @param roleInfo the value for role.role_info
     *
     * @mbggenerated Sun Oct 25 18:48:50 ICT 2015
     */
    public void setRoleInfo(String roleInfo) {
        this.roleInfo = roleInfo == null ? null : roleInfo.trim();
    }
}