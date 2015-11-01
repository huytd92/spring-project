package com.hust.htd.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hust.htd.common.ECommerceException;
import com.hust.htd.common.Page;
import com.hust.htd.persistence.mapper.CategoryMapper;
import com.hust.htd.persistence.model.Category;
import com.hust.htd.persistence.model.CategoryExample;
import com.hust.htd.persistence.validator.UserValidator;
import com.hust.htd.service.CategoryService;

/**
 * @author HuyTaDuc
 */

@Service
public class CategoryServiceImpl implements CategoryService {
	@Autowired
	private CategoryMapper categoryMapper;

	@Override
	@Transactional(readOnly = true, rollbackFor = ECommerceException.class, propagation = Propagation.REQUIRED)
	public Page<List<Category>> getListCategory(Integer offset, Integer limit) throws ECommerceException {
		try {
			UserValidator.validateQueryParameter(offset, limit);
			CategoryExample categoryExample = new CategoryExample();

			int count = categoryMapper.countByExample(categoryExample);

			categoryExample.setOrderByClause(
					"category_name ASC LIMIT " + String.valueOf(offset * limit) + ", " + String.valueOf(limit));
			List<Category> categorys = categoryMapper.selectByExample(categoryExample);
			Page<List<Category>> result = new Page<List<Category>>();
			result.setContent(categorys);
			result.setSizeofList(count);
			result.setSizeofPage(categorys.size());
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
	public Category getCategoryById(Long categoryId) throws ECommerceException {
		try {
			Category category = categoryMapper.selectByPrimaryKey(categoryId);
			if (category == null) {
				throw new ECommerceException("category doesn't exists");
			}
			return category;
		} catch (Exception e) {
			if (e instanceof ECommerceException)
				throw (ECommerceException) e;
			throw new ECommerceException("SQL Exception");
		}
	}

}
