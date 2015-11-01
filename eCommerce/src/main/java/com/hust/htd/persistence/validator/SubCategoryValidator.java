package com.hust.htd.persistence.validator;

import com.hust.htd.common.ECommerceException;
import com.hust.htd.persistence.model.SubCategory;

/**
 * @author HuyTaDuc
 */

public class SubCategoryValidator {
	/**
	 * Validate fields must not null
	 * 
	 * @exception ECommerceException
	 *                (Invalid brand)
	 */
	public static void validateNotNull(SubCategory subCategory) throws ECommerceException {
		if (subCategory.getSubcategoryName() == null)
			throw new ECommerceException("Invalid subCategory");
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
