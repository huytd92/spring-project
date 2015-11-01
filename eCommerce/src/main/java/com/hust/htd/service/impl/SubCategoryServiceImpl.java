package com.hust.htd.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hust.htd.common.ECommerceException;
import com.hust.htd.common.Page;
import com.hust.htd.persistence.mapper.ProductMapper;
import com.hust.htd.persistence.mapper.SubCategoryMapper;
import com.hust.htd.persistence.model.Product;
import com.hust.htd.persistence.model.ProductExample;
import com.hust.htd.persistence.model.SubCategory;
import com.hust.htd.persistence.model.SubCategoryExample;
import com.hust.htd.persistence.validator.SubCategoryValidator;
import com.hust.htd.persistence.validator.UserValidator;
import com.hust.htd.service.SubCategoryService;

/**
 * @author HuyTaDuc
 */

@Service
public class SubCategoryServiceImpl implements SubCategoryService {

	@Autowired
	private SubCategoryMapper subCategoryMapper;

	@Autowired
	private ProductMapper productMapper;

	@Override
	@Transactional(readOnly = true, rollbackFor = ECommerceException.class, propagation = Propagation.REQUIRED)
	public Page<List<SubCategory>> getListSubCategory(Integer offset, Integer limit) throws ECommerceException {
		try {
			UserValidator.validateQueryParameter(offset, limit);
			SubCategoryExample subCategoryExample = new SubCategoryExample();

			int count = subCategoryMapper.countByExample(subCategoryExample);

			subCategoryExample.setOrderByClause(
					"subCategory_name ASC LIMIT " + String.valueOf(offset * limit) + ", " + String.valueOf(limit));
			List<SubCategory> subCategorys = subCategoryMapper.selectByExample(subCategoryExample);
			Page<List<SubCategory>> result = new Page<List<SubCategory>>();
			result.setContent(subCategorys);
			result.setSizeofList(count);
			result.setSizeofPage(subCategorys.size());
			result.setTotalPage(count % limit == 0 ? count / limit : count / limit + 1);
			result.setCurrentPage(offset + 1);
			return result;
		} catch (Exception e) {
			if (e instanceof ECommerceException)
				throw (ECommerceException) e;
			throw new ECommerceException("SQL Exception");
		}
	}

	@Override
	@Transactional(readOnly = true, rollbackFor = ECommerceException.class, propagation = Propagation.REQUIRED)
	public SubCategory getSubCategoryById(Long subCategoryId) throws ECommerceException {
		try {
			SubCategory subCategory = subCategoryMapper.selectByPrimaryKey(subCategoryId);
			if (subCategory == null) {
				throw new ECommerceException("subCategory doesn't exists");
			}
			return subCategory;
		} catch (Exception e) {
			if (e instanceof ECommerceException)
				throw (ECommerceException) e;
			throw new ECommerceException("SQL Exception");
		}
	}

	@Override
	@Transactional(readOnly = true, rollbackFor = ECommerceException.class, propagation = Propagation.REQUIRED)
	public SubCategory getSubCategoryBySubCategoryname(String subCategoryname) throws ECommerceException {
		try {
			SubCategoryExample subCategoryExample = new SubCategoryExample();
			subCategoryExample.setDistinct(true);
			subCategoryExample.createCriteria().andSubcategoryNameEqualTo(subCategoryname);
			List<SubCategory> subCategorys = subCategoryMapper.selectByExample(subCategoryExample);
			if (subCategorys.isEmpty()) {
				throw new ECommerceException("SubCategory doesn't exists");
			}
			return subCategorys.get(0);
		} catch (Exception e) {
			if (e instanceof ECommerceException)
				throw (ECommerceException) e;
			throw new ECommerceException("SQL Exception");
		}
	}

	@Override
	@Transactional(readOnly = false, rollbackFor = ECommerceException.class, propagation = Propagation.REQUIRED)
	public SubCategory updateSubCategory(Long subCategoryId, SubCategory subCategory) throws ECommerceException {
		try {
			SubCategory existingSubCategory = subCategoryMapper.selectByPrimaryKey(subCategoryId);
			if (existingSubCategory == null) {
				throw new ECommerceException("SubCategory doesn't exists");
			}
			if (subCategory.getSubcategoryName() != null) {
				existingSubCategory.setSubcategoryName(subCategory.getSubcategoryName());
			}
			if (subCategory.getSubcategoryInfo() != null) {
				existingSubCategory.setSubcategoryInfo(subCategory.getSubcategoryInfo());
			}
			SubCategoryValidator.validateNotNull(existingSubCategory);
			Integer resultCode = subCategoryMapper.updateByPrimaryKey(existingSubCategory);

			if (resultCode <= 0) {
				throw new ECommerceException("Update failed");
			}

			ProductExample productExample = new ProductExample();
			productExample.createCriteria().andSubcategoryIdEqualTo(subCategoryId);
			Product product = new Product();
			product.setSubcategoryName(existingSubCategory.getSubcategoryName());
			productMapper.updateByExampleSelective(product, productExample);

			return existingSubCategory;
		} catch (Exception e) {
			if (e instanceof ECommerceException)
				throw (ECommerceException) e;
			throw new ECommerceException("SQL Exception");
		}
	}

	@Override
	@Transactional(readOnly = false, rollbackFor = ECommerceException.class, propagation = Propagation.REQUIRED)
	public SubCategory addSubCategory(SubCategory subCategory) throws ECommerceException {
		try {
			SubCategoryExample subCategoryExample = new SubCategoryExample();
			subCategoryExample.setDistinct(true);
			subCategoryExample.createCriteria().andSubcategoryNameEqualTo(subCategory.getSubcategoryName());
			List<SubCategory> subCategorys = subCategoryMapper.selectByExample(subCategoryExample);
			if (!subCategorys.isEmpty()) {
				throw new ECommerceException("SubCategory existing");
			}
			SubCategoryValidator.validateNotNull(subCategory);
			Integer resultCode = subCategoryMapper.insert(subCategory);
			if (resultCode <= 0) {
				throw new ECommerceException("Add failed");
			}
			subCategorys = subCategoryMapper.selectByExample(subCategoryExample);
			return subCategorys.get(0);
		} catch (Exception e) {
			if (e instanceof ECommerceException)
				throw (ECommerceException) e;
			throw new ECommerceException("SQL Exception");
		}
	}

	@Override
	@Transactional(readOnly = false, rollbackFor = ECommerceException.class, propagation = Propagation.REQUIRED)
	public Integer deleteSubCategory(Long subCategoryId) throws ECommerceException {
		try {
			SubCategory subCategory = subCategoryMapper.selectByPrimaryKey(subCategoryId);
			if (subCategory == null) {
				throw new ECommerceException("SubCategory doesn't exists");
			}

			ProductExample productExample = new ProductExample();
			productExample.createCriteria().andSubcategoryIdEqualTo(subCategoryId);
			int count = productMapper.countByExample(productExample);
			if (count > 0) {
				throw new ECommerceException("SubCategory in use");
			}

			Integer resultCode = subCategoryMapper.deleteByPrimaryKey(subCategoryId);
			if (resultCode <= 0) {
				throw new ECommerceException("Delete failed");
			}
			return resultCode;
		} catch (Exception e) {
			if (e instanceof ECommerceException)
				throw (ECommerceException) e;
			throw new ECommerceException("SQL Exception");
		}
	}
}
