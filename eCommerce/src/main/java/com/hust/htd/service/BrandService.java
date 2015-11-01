package com.hust.htd.service;

import java.util.List;

import com.hust.htd.common.ECommerceException;
import com.hust.htd.common.Page;
import com.hust.htd.persistence.model.Brand;

/**
 * @author HuyTaDuc 
 */

public interface BrandService {
	
	/**
	 * getListBrand
	 * 
	 * @exception ECommerceException
	 *                (SQL Exception)
	 */
	public Page<List<Brand>> getListBrand(Integer offset, Integer limit) throws ECommerceException;
	
	
	/**
	 * getBrandById
	 * 
	 * @exception ECommerceException
	 *                (Brand doesn't exists, SQL Exception)
	 */
	public Brand getBrandById(Long brandId) throws ECommerceException;

	/**
	 * getBrandByBrandname
	 * 
	 * @exception ECommerceException
	 *                (SQL Exception)
	 */
	public Brand getBrandByBrandname(String brandname) throws ECommerceException;

	/**
	 * updateBrand
	 * 
	 * @exception ECommerceException
	 *                (Brand doesn't exists, Update failed, SQL Exception)
	 */
	public Brand updateBrand(Long brandId, Brand brand) throws ECommerceException;

	/**
	 * addBrand
	 * 
	 * @exception ECommerceException
	 *                (Brand existing, Add failed, SQL Exception)
	 */
	public Brand addBrand(Brand brand) throws ECommerceException;
	
	/**
	 * deleteBrand
	 * 
	 * @exception ECommerceException
	 *                (Brand doesn't exists, Delete failed, SQL Exception)
	 */
	public Integer deleteBrand(Long brandId) throws ECommerceException;
}
