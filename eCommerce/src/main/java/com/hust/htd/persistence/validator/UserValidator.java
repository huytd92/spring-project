package com.hust.htd.persistence.validator;

import java.util.Date;

import com.hust.htd.common.ECommerceException;
import com.hust.htd.persistence.model.User;

/**
 * @author HuyTaDuc
 */

public class UserValidator {

	/**
	 * Validate fields must not null
	 * 
	 * @exception ECommerceException
	 *                (Invalid user)
	 */
	public static void validateNotNull(User user) throws ECommerceException {
		if (user.getUserCreatedDatetime() == null) {
			user.setUserCreatedDatetime(new Date(System.currentTimeMillis()));
		}
		if (user.getUsername() == null || user.getPassword() == null || user.getUserDisplayName() == null
				|| user.getRoleId() == null)
			throw new ECommerceException("Invalid user");
	}

	/**
	 * Validate roleId before add OR update User <br>
	 * SUPER ADMIN > ADMIN > PUBLISHER > USER > ANONYMOUS <br>
	 * 1 > 2 > 3 > 4 > 5
	 * 
	 * @exception ECommerceException
	 *                (Access denied)
	 */
	public static void validateRoleofUser(User user, Long roleId) throws ECommerceException {
		if (user.getRoleId() <= roleId)
			throw new ECommerceException("Access denied");
	}

	/**
	 * Validate query parameters <br>
	 * offset >= 0 AND limit > 0 AND limit <= 50
	 * 
	 * @exception ECommerceException
	 *                (Invalid parameter)
	 */
	public static void validateQueryParameter(Integer offset, Integer limit) throws ECommerceException {
		if (offset == null || limit == null)
			throw new ECommerceException("Invalid parameter");
		if (offset < 0 || limit <= 0 || limit > 50)
			throw new ECommerceException("Invalid parameter");
	}
}
