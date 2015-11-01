package com.hust.htd.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hust.htd.common.ECommerceException;
import com.hust.htd.config.AuthenticatedUser;
import com.hust.htd.persistence.mapper.RoleMapper;
import com.hust.htd.persistence.model.Role;
import com.hust.htd.persistence.model.RoleExample;
import com.hust.htd.service.RoleService;

/**
 * @author HuyTaDuc
 */

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleMapper roleMapper;

	@Override
	@Transactional(readOnly = true, rollbackFor = ECommerceException.class, propagation = Propagation.REQUIRED)
	public List<Role> getListRole() throws ECommerceException {
		try {
			AuthenticatedUser authenticatedUser = (AuthenticatedUser) SecurityContextHolder.getContext()
					.getAuthentication().getPrincipal();
			RoleExample roleExample = new RoleExample();
			roleExample.createCriteria().andRoleIdGreaterThan(authenticatedUser.getRoleId());
			List<Role> result = roleMapper.selectByExample(roleExample);
			return result;
		} catch (Exception e) {
			if (e instanceof ECommerceException)
				throw (ECommerceException) e;
			throw new ECommerceException("SQL Exception");
		}
	}

	@Override
	@Transactional(readOnly = true, rollbackFor = ECommerceException.class, propagation = Propagation.REQUIRED)
	public Role getRoleById(Long roleId) throws ECommerceException {
		try {
			AuthenticatedUser authenticatedUser = (AuthenticatedUser) SecurityContextHolder.getContext()
					.getAuthentication().getPrincipal();
			if (roleId <= authenticatedUser.getRoleId())
				throw new ECommerceException("Access denied");
			Role result = roleMapper.selectByPrimaryKey(roleId);
			return result;
		} catch (Exception e) {
			if (e instanceof ECommerceException)
				throw (ECommerceException) e;
			throw new ECommerceException("SQL Exception");
		}
	}

}
