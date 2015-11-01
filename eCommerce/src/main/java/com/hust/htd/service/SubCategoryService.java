package com.hust.htd.service;

import java.util.List;

import com.hust.htd.common.ECommerceException;
import com.hust.htd.common.Page;
import com.hust.htd.persistence.model.SubCategory;

/**
 * @author HuyTaDuc 
 */

public interface SubCategoryService {
	/**
	 * getListSubCategory
	 * 
	 * @exception ECommerceException
	 *                (SQL Exception)
	 */
	public Page<List<SubCategory>> getListSubCategory(Integer offset, Integer limit) throws ECommerceException;
	
	
	/**
	 * getSubCategoryById
	 * 
	 * @exception ECommerceException
	 *                (SubCategory doesn't exists, SQL Exception)
	 */
	public SubCategory getSubCategoryById(Long subCategoryId) throws ECommerceException;

	/**
	 * getSubCategoryBySubCategoryname
	 * 
	 * @exception ECommerceException
	 *                (SQL Exception)
	 */
	public SubCategory getSubCategoryBySubCategoryname(String subCategoryname) throws ECommerceException;

	/**
	 * updateSubCategory
	 * 
	 * @exception ECommerceException
	 *                (SubCategory doesn't exists, Update failed, SQL Exception)
	 */
	public SubCategory updateSubCategory(Long subCategoryId, SubCategory subCategory) throws ECommerceException;

	/**
	 * addSubCategory
	 * 
	 * @exception ECommerceException
	 *                (SubCategory existing, Add failed, SQL Exception)
	 */
	public SubCategory addSubCategory(SubCategory subCategory) throws ECommerceException;
	
	/**
	 * deleteSubCategory
	 * 
	 * @exception ECommerceException
	 *                (SubCategory doesn't exists, Delete failed, SQL Exception)
	 */
	public Integer deleteSubCategory(Long subCategoryId) throws ECommerceException;
}
