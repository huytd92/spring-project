package com.hust.htd.service;

import java.util.List;

import com.hust.htd.common.ECommerceException;
import com.hust.htd.common.Page;
import com.hust.htd.persistence.model.Comment;

/**
 * @author HuyTaDuc
 */

public interface CommentService {

	/**
	 * getListComment
	 * 
	 * @exception ECommerceException
	 *                (SQL Exception)
	 */
	public Page<List<Comment>> getListComment(Integer offset, Integer limit) throws ECommerceException;

	/**
	 * getCommentById
	 * 
	 * @exception ECommerceException
	 *                (Comment doesn't exists, SQL Exception)
	 */
	public Comment getCommentById(Long commentId) throws ECommerceException;

	/**
	 * getListCommentByProductId
	 * 
	 * @exception ECommerceException
	 *                (SQL Exception)
	 */
	public Page<List<Comment>> getListCommentByProductId(Long productId, Integer offset, Integer limit)
			throws ECommerceException;

	/**
	 * updateComment
	 * 
	 * @exception ECommerceException
	 *                (Comment doesn't exists, Update failed, SQL Exception)
	 */
	public Comment updateComment(Long commentId, Comment comment) throws ECommerceException;

	/**
	 * addComment
	 * 
	 * @exception ECommerceException
	 *                (Comment existing, Add failed, SQL Exception)
	 */
	public Comment addComment(Comment comment) throws ECommerceException;

	/**
	 * deleteComment
	 * 
	 * @exception ECommerceException
	 *                (Comment doesn't exists, Delete failed, SQL Exception)
	 */
	public Integer deleteComment(Long commentId) throws ECommerceException;
}
