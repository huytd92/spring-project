package com.hust.htd.service;

import java.util.List;

import com.hust.htd.common.ECommerceException;
import com.hust.htd.common.Page;
import com.hust.htd.persistence.model.Origin;

/**
 * @author HuyTaDuc
 */

public interface OriginService {
	/**
	 * getListOrigin
	 * 
	 * @exception ECommerceException
	 *                (SQL Exception)
	 */
	public Page<List<Origin>> getListOrigin(Integer offset, Integer limit) throws ECommerceException;

	/**
	 * getOriginById
	 * 
	 * @exception ECommerceException
	 *                (Origin doesn't exists, SQL Exception)
	 */
	public Origin getOriginById(Long originId) throws ECommerceException;

	/**
	 * getOriginByOriginname
	 * 
	 * @exception ECommerceException
	 *                (SQL Exception)
	 */
	public Origin getOriginByOriginname(String originname) throws ECommerceException;

	/**
	 * updateOrigin
	 * 
	 * @exception ECommerceException
	 *                (Origin doesn't exists, Update failed, SQL Exception)
	 */
	public Origin updateOrigin(Long originId, Origin origin) throws ECommerceException;

	/**
	 * addOrigin
	 * 
	 * @exception ECommerceException
	 *                (Origin existing, Add failed, SQL Exception)
	 */
	public Origin addOrigin(Origin origin) throws ECommerceException;

	/**
	 * deleteOrigin
	 * 
	 * @exception ECommerceException
	 *                (Origin doesn't exists, Delete failed, SQL Exception)
	 */
	public Integer deleteOrigin(Long originId) throws ECommerceException;
}
