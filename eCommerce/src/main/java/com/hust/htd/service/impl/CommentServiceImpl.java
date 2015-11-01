package com.hust.htd.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hust.htd.common.ECommerceException;
import com.hust.htd.common.Page;
import com.hust.htd.persistence.mapper.CommentMapper;
import com.hust.htd.persistence.model.Comment;
import com.hust.htd.persistence.model.CommentExample;
import com.hust.htd.persistence.validator.CommentValidator;
import com.hust.htd.persistence.validator.UserValidator;
import com.hust.htd.service.CommentService;

/**
 * @author HuyTaDuc
 */

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	private CommentMapper commentMapper;

	@Override
	@Transactional(readOnly = true, rollbackFor = ECommerceException.class, propagation = Propagation.REQUIRED)
	public Page<List<Comment>> getListComment(Integer offset, Integer limit) throws ECommerceException {
		try {
			UserValidator.validateQueryParameter(offset, limit);
			CommentExample commentExample = new CommentExample();

			int count = commentMapper.countByExample(commentExample);

			commentExample.setOrderByClause(
					"comment_datetime ASC LIMIT " + String.valueOf(offset * limit) + ", " + String.valueOf(limit));
			List<Comment> comments = commentMapper.selectByExample(commentExample);
			Page<List<Comment>> result = new Page<List<Comment>>();
			result.setContent(comments);
			result.setSizeofList(count);
			result.setSizeofPage(comments.size());
			result.setTotalPage(count % limit == 0 ? count / limit : count / limit + 1);
			result.setCurrentPage(offset + 1);
			return result;
		} catch (Exception e) {
			if (e instanceof ECommerceException)
				throw (ECommerceException) e;
			throw new ECommerceException("SQL Exception");
		}
	}

	@Override
	@Transactional(readOnly = true, rollbackFor = ECommerceException.class, propagation = Propagation.REQUIRED)
	public Page<List<Comment>> getListCommentByProductId(Long productId, Integer offset, Integer limit)
			throws ECommerceException {
		try {
			UserValidator.validateQueryParameter(offset, limit);
			CommentExample commentExample = new CommentExample();
			commentExample.createCriteria().andProductIdEqualTo(productId);

			int count = commentMapper.countByExample(commentExample);

			commentExample.setOrderByClause(
					"comment_datetime DESC LIMIT " + String.valueOf(offset * limit) + ", " + String.valueOf(limit));
			List<Comment> comments = commentMapper.selectByExample(commentExample);
			Page<List<Comment>> result = new Page<List<Comment>>();
			result.setContent(comments);
			result.setSizeofList(count);
			result.setSizeofPage(comments.size());
			result.setTotalPage(count % limit == 0 ? count / limit : count / limit + 1);
			result.setCurrentPage(offset + 1);
			return result;
		} catch (Exception e) {
			if (e instanceof ECommerceException)
				throw (ECommerceException) e;
			throw new ECommerceException("SQL Exception");
		}
	}

	@Override
	@Transactional(readOnly = true, rollbackFor = ECommerceException.class, propagation = Propagation.REQUIRED)
	public Comment getCommentById(Long commentId) throws ECommerceException {
		try {
			Comment comment = commentMapper.selectByPrimaryKey(commentId);
			if (comment == null) {
				throw new ECommerceException("comment doesn't exists");
			}
			return comment;
		} catch (Exception e) {
			if (e instanceof ECommerceException)
				throw (ECommerceException) e;
			throw new ECommerceException("SQL Exception");
		}
	}

	@Override
	@Transactional(readOnly = false, rollbackFor = ECommerceException.class, propagation = Propagation.REQUIRED)
	public Comment updateComment(Long commentId, Comment comment) throws ECommerceException {
		try {
			return null;
		} catch (Exception e) {
			if (e instanceof ECommerceException)
				throw (ECommerceException) e;
			throw new ECommerceException("SQL Exception");
		}
	}

	@Override
	@Transactional(readOnly = false, rollbackFor = ECommerceException.class, propagation = Propagation.REQUIRED)
	public Comment addComment(Comment comment) throws ECommerceException {
		try {
			CommentValidator.validateNotNull(comment);
			Integer resultCode = commentMapper.insert(comment);
			if (resultCode <= 0) {
				throw new ECommerceException("Add failed");
			}
			return null;
		} catch (Exception e) {
			if (e instanceof ECommerceException)
				throw (ECommerceException) e;
			throw new ECommerceException("SQL Exception");
		}
	}

	@Override
	@Transactional(readOnly = false, rollbackFor = ECommerceException.class, propagation = Propagation.REQUIRED)
	public Integer deleteComment(Long commentId) throws ECommerceException {
		try {
			Comment comment = commentMapper.selectByPrimaryKey(commentId);
			if (comment == null) {
				throw new ECommerceException("Comment doesn't exists");
			}

			Integer resultCode = commentMapper.deleteByPrimaryKey(commentId);
			if (resultCode <= 0) {
				throw new ECommerceException("Delete failed");
			}
			return resultCode;
		} catch (Exception e) {
			if (e instanceof ECommerceException)
				throw (ECommerceException) e;
			throw new ECommerceException("SQL Exception");
		}
	}

}
