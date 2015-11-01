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
import com.hust.htd.persistence.model.Brand;
import com.hust.htd.service.BrandService;

/**
 * @author HuyTaDuc
 * @category /api/brands
 */

@RestController
@RequestMapping("/api/brands")
public class BrandController {

	@Autowired
	private BrandService brandService;

	/**
	 * getListBrand
	 * 
	 * @method GET
	 * @uri /api/brands?offset=0&limit=10
	 */
	@RequestMapping(value = "", method = RequestMethod.GET)
	public Result<Page<List<Brand>>> getListBrand(@RequestParam(defaultValue = "0") Integer offset,
			@RequestParam(defaultValue = "15") Integer limit) {
		try {
			Page<List<Brand>> page = brandService.getListBrand(offset, limit);
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
	 * getBrandById
	 * 
	 * @method GET
	 * @uri /api/brands/{brandId}
	 */
	@RequestMapping(value = "/{brandId}", method = RequestMethod.GET)
	public Result<Brand> getBrandById(@PathVariable("brandId") Long brandId) {
		try {
			Brand brand = brandService.getBrandById(brandId);
			return Result.createResult(HttpStatus.OK, brand);
		} catch (Exception e) {
			if (e instanceof ECommerceException) {
				return Result.createResult(HttpStatus.FORBIDDEN, ((ECommerceException) e).getError());
			} else {
				return Result.createResult(HttpStatus.FORBIDDEN, "Method failed");
			}
		}
	}

	/**
	 * addNewBrand
	 * 
	 * @method POST
	 * @uri /api/brands
	 */
	@RequestMapping(value = "", method = RequestMethod.POST)
	public Result<Brand> addNewBrand(@RequestBody Brand brand) {
		try {
			brand = brandService.addBrand(brand);
			return Result.createResult(HttpStatus.OK, brand);
		} catch (Exception e) {
			if (e instanceof ECommerceException) {
				return Result.createResult(HttpStatus.FORBIDDEN, ((ECommerceException) e).getError());
			} else {
				return Result.createResult(HttpStatus.FORBIDDEN, "Method failed");
			}
		}
	}

	/**
	 * updateBrand
	 * 
	 * @method PUT
	 * @uri /api/brands/{brandId}
	 */
	@RequestMapping(value = "/{brandId}", method = RequestMethod.PUT)
	public Result<Brand> updateBrand(@PathVariable("brandId") Long brandId, @RequestBody Brand brand) {
		try {
			brand = brandService.updateBrand(brandId, brand);
			return Result.createResult(HttpStatus.OK, brand);
		} catch (Exception e) {
			if (e instanceof ECommerceException) {
				return Result.createResult(HttpStatus.FORBIDDEN, ((ECommerceException) e).getError());
			} else {
				return Result.createResult(HttpStatus.FORBIDDEN, "Method failed");
			}
		}
	}

	/**
	 * deleteBrand
	 * 
	 * @method DELETE
	 * @uri /api/brands/{brandId}
	 */
	@RequestMapping(value = "/{brandId}", method = RequestMethod.DELETE)
	public Result<Integer> deleteBrand(@PathVariable("brandId") Long brandId) {
		try {
			brandService.deleteBrand(brandId);
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
