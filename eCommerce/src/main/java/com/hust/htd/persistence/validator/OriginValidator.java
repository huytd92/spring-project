package com.hust.htd.persistence.validator;

import com.hust.htd.common.ECommerceException;
import com.hust.htd.persistence.model.Origin;

/**
 * @author HuyTaDuc
 */

public class OriginValidator {
	/**
	 * Validate fields must not null
	 * 
	 * @exception ECommerceException
	 *                (Invalid origin)
	 */
	public static void validateNotNull(Origin origin) throws ECommerceException {
		if (origin.getOriginName() == null)
			throw new ECommerceException("Invalid origin");
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
