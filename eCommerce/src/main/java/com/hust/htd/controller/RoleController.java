package com.hust.htd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hust.htd.common.ECommerceException;
import com.hust.htd.common.Result;
import com.hust.htd.persistence.model.Role;
import com.hust.htd.service.RoleService;

/**
 * @author HuyTaDuc
 * @category /api/roles
 */

@RestController
@RequestMapping("/api/roles")
public class RoleController {

	@Autowired
	private RoleService roleService;

	/**
	 * getListRole
	 * 
	 * @method GET
	 * @uri /api/roles
	 */
	@RequestMapping(value = "", method = RequestMethod.GET)
	public Result<List<Role>> getListRole() {
		try {
			List<Role> result = roleService.getListRole();
			return Result.createResult(HttpStatus.OK, result);
		} catch (Exception e) {
			if (e instanceof ECommerceException) {
				return Result.createResult(HttpStatus.FORBIDDEN, ((ECommerceException) e).getError());
			} else {
				return Result.createResult(HttpStatus.FORBIDDEN, "Method failed");
			}
		}
	}

	/**
	 * getRoleById
	 * 
	 * @method GET
	 * @uri /api/roles/{roleId}
	 */
	@RequestMapping(value = "/{roleId}", method = RequestMethod.GET)
	public Result<Role> getRoleById(@PathVariable("roleId") Long roleId) {
		try {
			Role result = roleService.getRoleById(roleId);
			return Result.createResult(HttpStatus.OK, result);
		} catch (Exception e) {
			if (e instanceof ECommerceException) {
				return Result.createResult(HttpStatus.FORBIDDEN, ((ECommerceException) e).getError());
			} else {
				return Result.createResult(HttpStatus.FORBIDDEN, "Method failed");
			}
		}
	}
}
