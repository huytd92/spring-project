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
import com.hust.htd.persistence.model.Origin;
import com.hust.htd.service.OriginService;

/**
 * @author HuyTaDuc
 * @category /api/origins
 */

@RestController
@RequestMapping("/api/origins")
public class OriginController {

	@Autowired
	private OriginService originService;

	/**
	 * getListOrigin
	 * 
	 * @method GET
	 * @uri /api/origins?offset=0&limit=10
	 */
	@RequestMapping(value = "", method = RequestMethod.GET)
	public Result<Page<List<Origin>>> getListOrigin(@RequestParam(defaultValue = "0") Integer offset,
			@RequestParam(defaultValue = "15") Integer limit) {
		try {
			Page<List<Origin>> page = originService.getListOrigin(offset, limit);
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
	 * getOriginById
	 * 
	 * @method GET
	 * @uri /api/origins/{originId}
	 */
	@RequestMapping(value = "/{originId}", method = RequestMethod.GET)
	public Result<Origin> getOriginById(@PathVariable("originId") Long originId) {
		try {
			Origin origin = originService.getOriginById(originId);
			return Result.createResult(HttpStatus.OK, origin);
		} catch (Exception e) {
			if (e instanceof ECommerceException) {
				return Result.createResult(HttpStatus.FORBIDDEN, ((ECommerceException) e).getError());
			} else {
				return Result.createResult(HttpStatus.FORBIDDEN, "Method failed");
			}
		}
	}

	/**
	 * addNewOrigin
	 * 
	 * @method POST
	 * @uri /api/origins
	 */
	@RequestMapping(value = "", method = RequestMethod.POST)
	public Result<Origin> addNewOrigin(@RequestBody Origin origin) {
		try {
			origin = originService.addOrigin(origin);
			return Result.createResult(HttpStatus.OK, origin);
		} catch (Exception e) {
			if (e instanceof ECommerceException) {
				return Result.createResult(HttpStatus.FORBIDDEN, ((ECommerceException) e).getError());
			} else {
				return Result.createResult(HttpStatus.FORBIDDEN, "Method failed");
			}
		}
	}

	/**
	 * updateOrigin
	 * 
	 * @method PUT
	 * @uri /api/origins/{originId}
	 */
	@RequestMapping(value = "/{originId}", method = RequestMethod.PUT)
	public Result<Origin> updateOrigin(@PathVariable("originId") Long originId, @RequestBody Origin origin) {
		try {
			origin = originService.updateOrigin(originId, origin);
			return Result.createResult(HttpStatus.OK, origin);
		} catch (Exception e) {
			if (e instanceof ECommerceException) {
				return Result.createResult(HttpStatus.FORBIDDEN, ((ECommerceException) e).getError());
			} else {
				return Result.createResult(HttpStatus.FORBIDDEN, "Method failed");
			}
		}
	}

	/**
	 * deleteOrigin
	 * 
	 * @method DELETE
	 * @uri /api/origins/{originId}
	 */
	@RequestMapping(value = "/{originId}", method = RequestMethod.DELETE)
	public Result<Integer> deleteOrigin(@PathVariable("originId") Long originId) {
		try {
			originService.deleteOrigin(originId);
			return Result.createResult(HttpStatus.OK);
		} catch (Exception e) {
			return Result.createResult(HttpStatus.FORBIDDEN);
		}
	}
}
