package com.hust.htd.service;

import java.util.List;

import com.hust.htd.common.ECommerceException;
import com.hust.htd.common.Page;
import com.hust.htd.persistence.model.Anonymous;

/**
 * @author HuyTaDuc
 */

public interface AnonymousService {

	/**
	 * getListAnonymous
	 * 
	 * @exception ECommerceException
	 *                (SQL Exception)
	 */
	public Page<List<Anonymous>> getListAnonymous(Integer offset, Integer limit) throws ECommerceException;
	
	
	/**
	 * getAnonymousById
	 * 
	 * @exception ECommerceException
	 *                (Anonymous doesn't exists, SQL Exception)
	 */
	public Anonymous getAnonymousById(Long anonymousId) throws ECommerceException;

	/**
	 * getAnonymousByAnonymousname
	 * 
	 * @exception ECommerceException
	 *                (SQL Exception)
	 */
	public Anonymous getAnonymousByAnonymousname(String anonymousname) throws ECommerceException;

	/**
	 * updateAnonymous
	 * 
	 * @exception ECommerceException
	 *                (Anonymous doesn't exists, Update failed, SQL Exception)
	 */
	public Anonymous updateAnonymous(Long anonymousId, Anonymous anonymous) throws ECommerceException;

	/**
	 * addAnonymous
	 * 
	 * @exception ECommerceException
	 *                (Anonymous existing, Add failed, SQL Exception)
	 */
	public Anonymous addAnonymous(Anonymous anonymous) throws ECommerceException;
	
	/**
	 * deleteAnonymous
	 * 
	 * @exception ECommerceException
	 *                (Anonymous doesn't exists, Delete failed, SQL Exception)
	 */
	public Integer deleteAnonymous(Long anonymousId) throws ECommerceException;
}
