package com.hust.htd.service;

import java.util.List;

import com.hust.htd.common.ECommerceException;
import com.hust.htd.common.Page;
import com.hust.htd.persistence.model.Category;

/**
 * @author HuyTaDuc 
 */

public interface CategoryService {

	/**
	 * getListCategory
	 * 
	 * @exception ECommerceException
	 *                (SQL Exception)
	 */
	public Page<List<Category>> getListCategory(Integer offset, Integer limit) throws ECommerceException;
	
	
	/**
	 * getCategoryById
	 * 
	 * @exception ECommerceException
	 *                (Category doesn't exists, SQL Exception)
	 */
	public Category getCategoryById(Long categoryId) throws ECommerceException;
}
