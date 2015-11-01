package com.hust.htd.persistence.model;

import java.util.Date;

public class Comment {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column comment.comment_id
     *
     * @mbggenerated Sun Oct 25 18:48:50 ICT 2015
     */
    private Long commentId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column comment.comment_datetime
     *
     * @mbggenerated Sun Oct 25 18:48:50 ICT 2015
     */
    private Date commentDatetime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column comment.user_id
     *
     * @mbggenerated Sun Oct 25 18:48:50 ICT 2015
     */
    private Long userId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column comment.anonymous_id
     *
     * @mbggenerated Sun Oct 25 18:48:50 ICT 2015
     */
    private Long anonymousId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column comment.product_id
     *
     * @mbggenerated Sun Oct 25 18:48:50 ICT 2015
     */
    private Long productId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column comment.comment_author
     *
     * @mbggenerated Sun Oct 25 18:48:50 ICT 2015
     */
    private String commentAuthor;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column comment.comment_body
     *
     * @mbggenerated Sun Oct 25 18:48:50 ICT 2015
     */
    private String commentBody;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column comment.comment_id
     *
     * @return the value of comment.comment_id
     *
     * @mbggenerated Sun Oct 25 18:48:50 ICT 2015
     */
    public Long getCommentId() {
        return commentId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column comment.comment_id
     *
     * @param commentId the value for comment.comment_id
     *
     * @mbggenerated Sun Oct 25 18:48:50 ICT 2015
     */
    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column comment.comment_datetime
     *
     * @return the value of comment.comment_datetime
     *
     * @mbggenerated Sun Oct 25 18:48:50 ICT 2015
     */
    public Date getCommentDatetime() {
        return commentDatetime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column comment.comment_datetime
     *
     * @param commentDatetime the value for comment.comment_datetime
     *
     * @mbggenerated Sun Oct 25 18:48:50 ICT 2015
     */
    public void setCommentDatetime(Date commentDatetime) {
        this.commentDatetime = commentDatetime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column comment.user_id
     *
     * @return the value of comment.user_id
     *
     * @mbggenerated Sun Oct 25 18:48:50 ICT 2015
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column comment.user_id
     *
     * @param userId the value for comment.user_id
     *
     * @mbggenerated Sun Oct 25 18:48:50 ICT 2015
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column comment.anonymous_id
     *
     * @return the value of comment.anonymous_id
     *
     * @mbggenerated Sun Oct 25 18:48:50 ICT 2015
     */
    public Long getAnonymousId() {
        return anonymousId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column comment.anonymous_id
     *
     * @param anonymousId the value for comment.anonymous_id
     *
     * @mbggenerated Sun Oct 25 18:48:50 ICT 2015
     */
    public void setAnonymousId(Long anonymousId) {
        this.anonymousId = anonymousId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column comment.product_id
     *
     * @return the value of comment.product_id
     *
     * @mbggenerated Sun Oct 25 18:48:50 ICT 2015
     */
    public Long getProductId() {
        return productId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column comment.product_id
     *
     * @param productId the value for comment.product_id
     *
     * @mbggenerated Sun Oct 25 18:48:50 ICT 2015
     */
    public void setProductId(Long productId) {
        this.productId = productId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column comment.comment_author
     *
     * @return the value of comment.comment_author
     *
     * @mbggenerated Sun Oct 25 18:48:50 ICT 2015
     */
    public String getCommentAuthor() {
        return commentAuthor;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column comment.comment_author
     *
     * @param commentAuthor the value for comment.comment_author
     *
     * @mbggenerated Sun Oct 25 18:48:50 ICT 2015
     */
    public void setCommentAuthor(String commentAuthor) {
        this.commentAuthor = commentAuthor == null ? null : commentAuthor.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column comment.comment_body
     *
     * @return the value of comment.comment_body
     *
     * @mbggenerated Sun Oct 25 18:48:50 ICT 2015
     */
    public String getCommentBody() {
        return commentBody;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column comment.comment_body
     *
     * @param commentBody the value for comment.comment_body
     *
     * @mbggenerated Sun Oct 25 18:48:50 ICT 2015
     */
    public void setCommentBody(String commentBody) {
        this.commentBody = commentBody == null ? null : commentBody.trim();
    }
}