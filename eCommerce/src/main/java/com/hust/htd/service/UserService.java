package com.hust.htd.service;

import java.util.List;

import com.hust.htd.common.ECommerceException;
import com.hust.htd.common.Page;
import com.hust.htd.persistence.model.User;

/**
 * @author HuyTaDuc
 */

public interface UserService {

	/**
	 * getListUser
	 * 
	 * @exception ECommerceException
	 *                (SQL Exception)
	 */
	public Page<List<User>> getListUser(Integer offset, Integer limit) throws ECommerceException;
	
	
	/**
	 * getUserById
	 * 
	 * @exception ECommerceException
	 *                (User doesn't exists, Access denied, SQL Exception)
	 */
	public User getUserById(Long userId) throws ECommerceException;

	/**
	 * getUserByUsername
	 * 
	 * @exception ECommerceException
	 *                (SQL Exception)
	 */
	public User getUserByUsername(String username) throws ECommerceException;

	/**
	 * updateUser
	 * 
	 * @exception ECommerceException
	 *                (User doesn't exists, Update failed, SQL Exception)
	 */
	public User updateUser(Long userId, User user) throws ECommerceException;

	/**
	 * addUser
	 * 
	 * @exception ECommerceException
	 *                (User existing, Add failed, SQL Exception)
	 */
	public User addUser(User user) throws ECommerceException;
	
	/**
	 * deleteUser
	 * 
	 * @exception ECommerceException
	 *                (User doesn't exists, Delete failed, SQL Exception)
	 */
	public Integer deleteUser(Long userId) throws ECommerceException;

}
