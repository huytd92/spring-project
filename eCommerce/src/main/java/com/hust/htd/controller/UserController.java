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
import com.hust.htd.persistence.model.User;
import com.hust.htd.service.UserService;

/**
 * @author HuyTaDuc
 * @category /api/users
 */

@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	private UserService userService;

	/**
	 * getListUser
	 * 
	 * @method GET
	 * @uri /api/users?offset=0&limit=30
	 */
	@RequestMapping(value = "", method = RequestMethod.GET)
	public Result<Page<List<User>>> getListUser(@RequestParam(defaultValue = "0") Integer offset,
			@RequestParam(defaultValue = "50") Integer limit) {
		try {
			Page<List<User>> page = userService.getListUser(offset, limit);
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
	 * getUserById
	 * 
	 * @method GET
	 * @uri /api/users/{userId}
	 */
	@RequestMapping(value = "/{userId}", method = RequestMethod.GET)
	public Result<User> getUserById(@PathVariable("userId") Long userId) {
		try {
			User user = userService.getUserById(userId);
			return Result.createResult(HttpStatus.OK, user);
		} catch (Exception e) {
			if (e instanceof ECommerceException) {
				return Result.createResult(HttpStatus.FORBIDDEN, ((ECommerceException) e).getError());
			} else {
				return Result.createResult(HttpStatus.FORBIDDEN, "Method failed");
			}
		}
	}

	/**
	 * addNewUser
	 * 
	 * @method POST
	 * @uri /api/users
	 */
	@RequestMapping(value = "", method = RequestMethod.POST)
	public Result<User> addNewUser(@RequestBody User user) {
		try {
			user = userService.addUser(user);
			return Result.createResult(HttpStatus.OK, user);
		} catch (Exception e) {
			if (e instanceof ECommerceException) {
				return Result.createResult(HttpStatus.FORBIDDEN, ((ECommerceException) e).getError());
			} else {
				return Result.createResult(HttpStatus.FORBIDDEN, "Method failed");
			}
		}
	}

	/**
	 * updateUser
	 * 
	 * @method PUT
	 * @uri /api/users/{userId}
	 */
	@RequestMapping(value = "/{userId}", method = RequestMethod.PUT)
	public Result<User> updateUser(@PathVariable("userId") Long userId, @RequestBody User user) {
		try {
			user = userService.updateUser(userId, user);
			return Result.createResult(HttpStatus.OK, user);
		} catch (Exception e) {
			if (e instanceof ECommerceException) {
				return Result.createResult(HttpStatus.FORBIDDEN, ((ECommerceException) e).getError());
			} else {
				return Result.createResult(HttpStatus.FORBIDDEN, "Method failed");
			}
		}
	}

	/**
	 * deleteUser
	 * 
	 * @method DELETE
	 * @uri /api/users/{userId}
	 */
	@RequestMapping(value = "/{userId}", method = RequestMethod.DELETE)
	public Result<Integer> deleteUser(@PathVariable("userId") Long userId) {
		try {
			userService.deleteUser(userId);
			return Result.createResult(HttpStatus.OK);
		} catch (Exception e) {
			return Result.createResult(HttpStatus.FORBIDDEN);
		}
	}
}
