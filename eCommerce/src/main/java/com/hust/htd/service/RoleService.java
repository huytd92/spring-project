package com.hust.htd.service;

import java.util.List;

import com.hust.htd.common.ECommerceException;
import com.hust.htd.persistence.model.Role;

/**
 * @author HuyTaDuc
 */

public interface RoleService {
	/**
	 * getListRole
	 * 
	 * @exception ECommerceException
	 *                (SQL Exception)
	 */
	public List<Role> getListRole() throws ECommerceException;

	/**
	 * getRoleById
	 * 
	 * @exception ECommerceException
	 *                (Role doesn't exists, Access denied, SQL Exception)
	 */
	public Role getRoleById(Long roleId) throws ECommerceException;
}
