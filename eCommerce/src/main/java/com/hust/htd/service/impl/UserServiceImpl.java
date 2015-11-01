package com.hust.htd.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hust.htd.common.ECommerceException;
import com.hust.htd.common.Page;
import com.hust.htd.config.AuthenticatedUser;
import com.hust.htd.persistence.mapper.UserMapper;
import com.hust.htd.persistence.model.User;
import com.hust.htd.persistence.model.UserExample;
import com.hust.htd.persistence.validator.UserValidator;
import com.hust.htd.service.UserService;

/**
 * @author HuyTaDuc
 */

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;

	/**
	 * getListUser
	 * 
	 * @exception ECommerceException
	 *                (SQL Exception)
	 */
	@Override
	@Transactional(readOnly = true, rollbackFor = ECommerceException.class, propagation = Propagation.REQUIRED)
	public Page<List<User>> getListUser(Integer offset, Integer limit) throws ECommerceException {
		try {
			UserValidator.validateQueryParameter(offset, limit);

			AuthenticatedUser authenticatedUser = (AuthenticatedUser) SecurityContextHolder.getContext()
					.getAuthentication().getPrincipal();
			UserExample userExample = new UserExample();
			userExample.createCriteria().andRoleIdGreaterThan(authenticatedUser.getRoleId());
			int count = userMapper.countByExample(userExample);
			userExample.setOrderByClause(
					"role_id ASC LIMIT " + String.valueOf(offset * limit) + ", " + String.valueOf(limit));

			List<User> users = userMapper.selectByExample(userExample);
			Page<List<User>> result = new Page<List<User>>();
			result.setContent(users);
			result.setSizeofList(count);
			result.setSizeofPage(users.size());
			result.setTotalPage(count % limit == 0 ? count / limit : count / limit + 1);
			result.setCurrentPage(offset + 1);
			return result;
		} catch (Exception e) {
			if (e instanceof ECommerceException)
				throw (ECommerceException) e;
			throw new ECommerceException("SQL Exception");
		}
	}

	/**
	 * getUserById
	 * 
	 * @exception ECommerceException
	 *                (User doesn't exists, Access denied, SQL Exception)
	 */
	@Override
	@Transactional(readOnly = true, rollbackFor = ECommerceException.class, propagation = Propagation.REQUIRED)
	public User getUserById(Long userId) throws ECommerceException {
		try {
			AuthenticatedUser authenticatedUser = (AuthenticatedUser) SecurityContextHolder.getContext()
					.getAuthentication().getPrincipal();
			User user = userMapper.selectByPrimaryKey(userId);
			if(user == null) {
				throw new ECommerceException("User doesn't exists");
			}
			if (user.getRoleId() <= authenticatedUser.getRoleId()) {
				throw new ECommerceException("Access denied");
			}
			return user;
		} catch (Exception e) {
			if (e instanceof ECommerceException)
				throw (ECommerceException) e;
			throw new ECommerceException("SQL Exception");
		}
	}

	/**
	 * getUserByUsername
	 * 
	 * @exception ECommerceException
	 *                (SQL Exception)
	 */
	@Override
	@Transactional(readOnly = true, rollbackFor = ECommerceException.class, propagation = Propagation.REQUIRED)
	public User getUserByUsername(String username) throws ECommerceException {
		try {
			AuthenticatedUser authenticatedUser = (AuthenticatedUser) SecurityContextHolder.getContext()
					.getAuthentication().getPrincipal();
			UserExample userExample = new UserExample();
			userExample.createCriteria().andRoleIdGreaterThan(authenticatedUser.getRoleId());
			User user = userMapper.selectByExample(userExample).get(0);
			return user;
		} catch (Exception e) {
			if (e instanceof ECommerceException)
				throw (ECommerceException) e;
			throw new ECommerceException("SQL Exception");
		}
	}

	/**
	 * updateUser
	 * 
	 * @exception ECommerceException
	 *                (User doesn't exists, Update failed, SQL Exception)
	 */
	@Override
	@Transactional(readOnly = false, rollbackFor = ECommerceException.class, propagation = Propagation.REQUIRED)
	public User updateUser(Long userId, User user) throws ECommerceException {
		try {
			AuthenticatedUser authenticatedUser = (AuthenticatedUser) SecurityContextHolder.getContext()
					.getAuthentication().getPrincipal();
			User existingUser = userMapper.selectByPrimaryKey(userId);
			if (existingUser == null) {
				throw new ECommerceException("User doesn't exists");
			}

			if (user.getPassword() != null) {
				existingUser.setPassword(user.getPassword());
			}
			if (user.getRoleId() != null) {
				existingUser.setRoleId(user.getRoleId());
			}
			if (user.getUserDisplayName() != null) {
				existingUser.setUserDisplayName(user.getUserDisplayName());
			}
			UserValidator.validateRoleofUser(existingUser, authenticatedUser.getRoleId());
			Integer resultCode = userMapper.updateByPrimaryKey(existingUser);
			if (resultCode <= 0) {
				throw new ECommerceException("Update failed");
			}
			return existingUser;
		} catch (Exception e) {
			if (e instanceof ECommerceException)
				throw (ECommerceException) e;
			throw new ECommerceException("SQL Exception");
		}
	}

	/**
	 * addUser
	 * 
	 * @exception ECommerceException
	 *                (User existing, Add failed, SQL Exception)
	 */
	@Override
	@Transactional(readOnly = false, rollbackFor = ECommerceException.class, propagation = Propagation.REQUIRED)
	public User addUser(User user) throws ECommerceException {
		try {
			UserValidator.validateNotNull(user);

			UserExample userExample = new UserExample();
			userExample.setDistinct(true);
			userExample.createCriteria().andUsernameEqualTo(user.getUsername());
			List<User> users = userMapper.selectByExample(userExample);
			if (users.size() != 0) {
				throw new ECommerceException("User existing");
			}

			AuthenticatedUser authenticatedUser = (AuthenticatedUser) SecurityContextHolder.getContext()
					.getAuthentication().getPrincipal();
			UserValidator.validateRoleofUser(user, authenticatedUser.getRoleId());
			Integer resultCode = userMapper.insert(user);
			if (resultCode <= 0) {
				throw new ECommerceException("Add failed");
			}
			users = userMapper.selectByExample(userExample);
			return users.get(0);
		} catch (Exception e) {
			if (e instanceof ECommerceException)
				throw (ECommerceException) e;
			throw new ECommerceException("SQL Exception");
		}
	}
	
	
	/**
	 * deleteUser
	 * 
	 * @exception ECommerceException
	 *                (User doesn't exists, Delete failed, SQL Exception)
	 */
	@Override
	@Transactional(readOnly = false, rollbackFor = ECommerceException.class, propagation = Propagation.REQUIRED)
	public Integer deleteUser(Long userId) throws ECommerceException {
		try {
			User existingUser = userMapper.selectByPrimaryKey(userId);
			if (existingUser == null) {
				throw new ECommerceException("User doesn't exists");
			}
			AuthenticatedUser authenticatedUser = (AuthenticatedUser) SecurityContextHolder.getContext()
					.getAuthentication().getPrincipal();
			UserValidator.validateRoleofUser(existingUser, authenticatedUser.getRoleId());
			Integer resultCode = userMapper.deleteByPrimaryKey(userId);
			if(resultCode <= 0) {
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
