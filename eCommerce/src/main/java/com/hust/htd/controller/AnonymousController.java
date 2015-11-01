package com.hust.htd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hust.htd.common.ECommerceException;
import com.hust.htd.common.Page;
import com.hust.htd.common.Result;
import com.hust.htd.persistence.model.Anonymous;
import com.hust.htd.service.AnonymousService;

/**
 * @author HuyTaDuc
 * @category /api/anonymous
 */

@RestController
@RequestMapping("/api/anonymous")
public class AnonymousController {
	
	@Autowired
	private AnonymousService anonymousService;

	/**
	 * getListAnonymous
	 * 
	 * @method GET
	 * @uri /api/anonymouss?offset=0&limit=10
	 */
	@RequestMapping(value = "", method = RequestMethod.GET)
	public Result<Page<List<Anonymous>>> getListAnonymous(@RequestParam(defaultValue = "0") Integer offset,
			@RequestParam(defaultValue = "15") Integer limit) {
		try {
			Page<List<Anonymous>> page = anonymousService.getListAnonymous(offset, limit);
			return Result.createResult(HttpStatus.OK, page);
		} catch (Exception e) {
			if (e instanceof ECommerceException) {
				return Result.createResult(HttpStatus.FORBIDDEN, ((ECommerceException) e).getError());
			} else {
				return Result.createResult(HttpStatus.FORBIDDEN, "Method failed");
			}
		}
	}

	/**
	 * getAnonymousById
	 * 
	 * @method GET
	 * @uri /api/anonymouss/{anonymousId}
	 */
	@RequestMapping(value = "/{anonymousId}", method = RequestMethod.GET)
	public Result<Anonymous> getAnonymousById(@PathVariable("anonymousId") Long anonymousId) {
		try {
			Anonymous anonymous = anonymousService.getAnonymousById(anonymousId);
			return Result.createResult(HttpStatus.OK, anonymous);
		} catch (Exception e) {
			if (e instanceof ECommerceException) {
				return Result.createResult(HttpStatus.FORBIDDEN, ((ECommerceException) e).getError());
			} else {
				return Result.createResult(HttpStatus.FORBIDDEN, "Method failed");
			}
		}
	}

	/**
	 * addNewAnonymous
	 * 
	 * @method POST
	 * @uri /api/anonymouss
	 */
	@RequestMapping(value = "", method = RequestMethod.POST)
	public Result<Anonymous> addNewAnonymous(@RequestBody Anonymous anonymous) {
		try {
			anonymous = anonymousService.addAnonymous(anonymous);
			return Result.createResult(HttpStatus.OK, anonymous);
		} catch (Exception e) {
			if (e instanceof ECommerceException) {
				return Result.createResult(HttpStatus.FORBIDDEN, ((ECommerceException) e).getError());
			} else {
				return Result.createResult(HttpStatus.FORBIDDEN, "Method failed");
			}
		}
	}

	/**
	 * updateAnonymous
	 * 
	 * @method PUT
	 * @uri /api/anonymouss/{anonymousId}
	 */
	@RequestMapping(value = "/{anonymousId}", method = RequestMethod.PUT)
	public Result<Anonymous> updateAnonymous(@PathVariable("anonymousId") Long anonymousId, @RequestBody Anonymous anonymous) {
		try {
			anonymous = anonymousService.updateAnonymous(anonymousId, anonymous);
			return Result.createResult(HttpStatus.OK, anonymous);
		} catch (Exception e) {
			if (e instanceof ECommerceException) {
				return Result.createResult(HttpStatus.FORBIDDEN, ((ECommerceException) e).getError());
			} else {
				return Result.createResult(HttpStatus.FORBIDDEN, "Method failed");
			}
		}
	}

	/**
	 * deleteAnonymous
	 * 
	 * @method DELETE
	 * @uri /api/anonymouss/{anonymousId}
	 */
	@RequestMapping(value = "/{anonymousId}", method = RequestMethod.DELETE)
	public Result<Integer> deleteAnonymous(@PathVariable("anonymousId") Long anonymousId) {
		try {
			anonymousService.deleteAnonymous(anonymousId);
			return Result.createResult(HttpStatus.OK);
		} catch (Exception e) {
			if (e instanceof ECommerceException) {
				return Result.createResult(HttpStatus.FORBIDDEN, ((ECommerceException) e).getError());
			} else {
				return Result.createResult(HttpStatus.FORBIDDEN, "Method failed");
			}
		}
	}
}
