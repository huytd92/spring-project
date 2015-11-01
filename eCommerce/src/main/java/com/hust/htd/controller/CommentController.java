package com.hust.htd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hust.htd.common.ECommerceException;
import com.hust.htd.common.Page;
import com.hust.htd.common.Result;
import com.hust.htd.persistence.model.Comment;
import com.hust.htd.service.CommentService;

/**
 * @author HuyTaDuc
 * @category /api/comments
 */

@RestController
@RequestMapping("/api/comments")
public class CommentController {
	
	@Autowired
	private CommentService commentService;

	/**
	 * getListComment
	 * 
	 * @method GET
	 * @uri /api/comments?offset=0&limit=10
	 */
	@RequestMapping(value = "", method = RequestMethod.GET)
	public Result<Page<List<Comment>>> getListComment(@RequestParam(defaultValue = "0") Integer offset,
			@RequestParam(defaultValue = "15") Integer limit) {
		try {
			Page<List<Comment>> page = commentService.getListComment(offset, limit);
			return Result.createResult(HttpStatus.OK, page);
		} catch (Exception e) {
			if (e instanceof ECommerceException) {
				return Result.createResult(HttpStatus.FORBIDDEN, ((ECommerceException) e).getError());
			} else {
				return Result.createResult(HttpStatus.FORBIDDEN, "Method failed");
			}
		}
	}

	/**
	 * getCommentById
	 * 
	 * @method GET
	 * @uri /api/comments/{commentId}
	 */
	@RequestMapping(value = "/{commentId}", method = RequestMethod.GET)
	public Result<Comment> getCommentById(@PathVariable("commentId") Long commentId) {
		try {
			Comment comment = commentService.getCommentById(commentId);
			return Result.createResult(HttpStatus.OK, comment);
		} catch (Exception e) {
			if (e instanceof ECommerceException) {
				return Result.createResult(HttpStatus.FORBIDDEN, ((ECommerceException) e).getError());
			} else {
				return Result.createResult(HttpStatus.FORBIDDEN, "Method failed");
			}
		}
	}

	/**
	 * addNewComment
	 * 
	 * @method POST
	 * @uri /api/comments
	 */
	@RequestMapping(value = "", method = RequestMethod.POST)
	public Result<Comment> addNewComment(@RequestBody Comment comment) {
		try {
			comment = commentService.addComment(comment);
			return Result.createResult(HttpStatus.OK, comment);
		} catch (Exception e) {
			if (e instanceof ECommerceException) {
				return Result.createResult(HttpStatus.FORBIDDEN, ((ECommerceException) e).getError());
			} else {
				return Result.createResult(HttpStatus.FORBIDDEN, "Method failed");
			}
		}
	}

	/**
	 * updateComment
	 * 
	 * @method PUT
	 * @uri /api/comments/{commentId}
	 */
	@RequestMapping(value = "/{commentId}", method = RequestMethod.PUT)
	public Result<Comment> updateComment(@PathVariable("commentId") Long commentId, @RequestBody Comment comment) {
		try {
			comment = commentService.updateComment(commentId, comment);
			return Result.createResult(HttpStatus.OK, comment);
		} catch (Exception e) {
			if (e instanceof ECommerceException) {
				return Result.createResult(HttpStatus.FORBIDDEN, ((ECommerceException) e).getError());
			} else {
				return Result.createResult(HttpStatus.FORBIDDEN, "Method failed");
			}
		}
	}

	/**
	 * deleteComment
	 * 
	 * @method DELETE
	 * @uri /api/comments/{commentId}
	 */
	@RequestMapping(value = "/{commentId}", method = RequestMethod.DELETE)
	public Result<Integer> deleteComment(@PathVariable("commentId") Long commentId) {
		try {
			commentService.deleteComment(commentId);
			return Result.createResult(HttpStatus.OK);
		} catch (Exception e) {
			if (e instanceof ECommerceException) {
				return Result.createResult(HttpStatus.FORBIDDEN, ((ECommerceException) e).getError());
			} else {
				return Result.createResult(HttpStatus.FORBIDDEN, "Method failed");
			}
		}
	}
}
