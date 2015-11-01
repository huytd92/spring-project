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
import com.hust.htd.persistence.model.SubCategory;
import com.hust.htd.service.SubCategoryService;

/**
 * @author HuyTaDuc
 * @subCategory /api/subcategories
 */

@RestController
@RequestMapping("/api/subcategories")
public class SubCategoryController {
	
	@Autowired
	private SubCategoryService subCategoryService;

	/**
	 * getListSubCategory
	 * 
	 * @method GET
	 * @uri /api/subCategorys?offset=0&limit=10
	 */
	@RequestMapping(value = "", method = RequestMethod.GET)
	public Result<Page<List<SubCategory>>> getListSubCategory(@RequestParam(defaultValue = "0") Integer offset,
			@RequestParam(defaultValue = "15") Integer limit) {
		try {
			Page<List<SubCategory>> page = subCategoryService.getListSubCategory(offset, limit);
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
	 * getSubCategoryById
	 * 
	 * @method GET
	 * @uri /api/subCategorys/{subCategoryId}
	 */
	@RequestMapping(value = "/{subCategoryId}", method = RequestMethod.GET)
	public Result<SubCategory> getSubCategoryById(@PathVariable("subCategoryId") Long subCategoryId) {
		try {
			SubCategory subCategory = subCategoryService.getSubCategoryById(subCategoryId);
			return Result.createResult(HttpStatus.OK, subCategory);
		} catch (Exception e) {
			if (e instanceof ECommerceException) {
				return Result.createResult(HttpStatus.FORBIDDEN, ((ECommerceException) e).getError());
			} else {
				return Result.createResult(HttpStatus.FORBIDDEN, "Method failed");
			}
		}
	}

	/**
	 * addNewSubCategory
	 * 
	 * @method POST
	 * @uri /api/subCategorys
	 */
	@RequestMapping(value = "", method = RequestMethod.POST)
	public Result<SubCategory> addNewSubCategory(@RequestBody SubCategory subCategory) {
		try {
			subCategory = subCategoryService.addSubCategory(subCategory);
			return Result.createResult(HttpStatus.OK, subCategory);
		} catch (Exception e) {
			if (e instanceof ECommerceException) {
				return Result.createResult(HttpStatus.FORBIDDEN, ((ECommerceException) e).getError());
			} else {
				return Result.createResult(HttpStatus.FORBIDDEN, "Method failed");
			}
		}
	}

	/**
	 * updateSubCategory
	 * 
	 * @method PUT
	 * @uri /api/subCategorys/{subCategoryId}
	 */
	@RequestMapping(value = "/{subCategoryId}", method = RequestMethod.PUT)
	public Result<SubCategory> updateSubCategory(@PathVariable("subCategoryId") Long subCategoryId, @RequestBody SubCategory subCategory) {
		try {
			subCategory = subCategoryService.updateSubCategory(subCategoryId, subCategory);
			return Result.createResult(HttpStatus.OK, subCategory);
		} catch (Exception e) {
			if (e instanceof ECommerceException) {
				return Result.createResult(HttpStatus.FORBIDDEN, ((ECommerceException) e).getError());
			} else {
				return Result.createResult(HttpStatus.FORBIDDEN, "Method failed");
			}
		}
	}

	/**
	 * deleteSubCategory
	 * 
	 * @method DELETE
	 * @uri /api/subCategorys/{subCategoryId}
	 */
	@RequestMapping(value = "/{subCategoryId}", method = RequestMethod.DELETE)
	public Result<Integer> deleteSubCategory(@PathVariable("subCategoryId") Long subCategoryId) {
		try {
			subCategoryService.deleteSubCategory(subCategoryId);
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
