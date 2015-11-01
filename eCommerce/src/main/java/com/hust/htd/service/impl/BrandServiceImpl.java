package com.hust.htd.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hust.htd.common.ECommerceException;
import com.hust.htd.common.Page;
import com.hust.htd.persistence.mapper.BrandMapper;
import com.hust.htd.persistence.mapper.ProductMapper;
import com.hust.htd.persistence.model.Brand;
import com.hust.htd.persistence.model.BrandExample;
import com.hust.htd.persistence.model.Product;
import com.hust.htd.persistence.model.ProductExample;
import com.hust.htd.persistence.validator.BrandValidator;
import com.hust.htd.persistence.validator.UserValidator;
import com.hust.htd.service.BrandService;

/**
 * @author HuyTaDuc
 */

@Service
public class BrandServiceImpl implements BrandService {

	@Autowired
	private BrandMapper brandMapper;

	@Autowired
	private ProductMapper productMapper;

	@Override
	@Transactional(readOnly = true, rollbackFor = ECommerceException.class, propagation = Propagation.REQUIRED)
	public Page<List<Brand>> getListBrand(Integer offset, Integer limit) throws ECommerceException {
		try {
			UserValidator.validateQueryParameter(offset, limit);
			BrandExample brandExample = new BrandExample();

			int count = brandMapper.countByExample(brandExample);

			brandExample.setOrderByClause(
					"brand_name ASC LIMIT " + String.valueOf(offset * limit) + ", " + String.valueOf(limit));
			List<Brand> brands = brandMapper.selectByExample(brandExample);
			Page<List<Brand>> result = new Page<List<Brand>>();
			result.setContent(brands);
			result.setSizeofList(count);
			result.setSizeofPage(brands.size());
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
	public Brand getBrandById(Long brandId) throws ECommerceException {
		try {
			Brand brand = brandMapper.selectByPrimaryKey(brandId);
			if (brand == null) {
				throw new ECommerceException("brand doesn't exists");
			}
			return brand;
		} catch (Exception e) {
			if (e instanceof ECommerceException)
				throw (ECommerceException) e;
			throw new ECommerceException("SQL Exception");
		}
	}

	@Override
	@Transactional(readOnly = true, rollbackFor = ECommerceException.class, propagation = Propagation.REQUIRED)
	public Brand getBrandByBrandname(String brandname) throws ECommerceException {
		try {
			BrandExample brandExample = new BrandExample();
			brandExample.setDistinct(true);
			brandExample.createCriteria().andBrandNameEqualTo(brandname);
			List<Brand> brands = brandMapper.selectByExample(brandExample);
			if (brands.isEmpty()) {
				throw new ECommerceException("Brand doesn't exists");
			}
			return brands.get(0);
		} catch (Exception e) {
			if (e instanceof ECommerceException)
				throw (ECommerceException) e;
			throw new ECommerceException("SQL Exception");
		}
	}

	@Override
	@Transactional(readOnly = false, rollbackFor = ECommerceException.class, propagation = Propagation.REQUIRED)
	public Brand updateBrand(Long brandId, Brand brand) throws ECommerceException {
		try {
			Brand existingBrand = brandMapper.selectByPrimaryKey(brandId);
			if (existingBrand == null) {
				throw new ECommerceException("Brand doesn't exists");
			}
			if (brand.getBrandName() != null) {
				existingBrand.setBrandName(brand.getBrandName());
			}
			if (brand.getBrandInfo() != null) {
				existingBrand.setBrandInfo(brand.getBrandInfo());
			}
			BrandValidator.validateNotNull(existingBrand);
			Integer resultCode = brandMapper.updateByPrimaryKey(existingBrand);

			if (resultCode <= 0) {
				throw new ECommerceException("Update failed");
			}

			ProductExample productExample = new ProductExample();
			productExample.createCriteria().andBrandIdEqualTo(brandId);
			Product product = new Product();
			product.setBrandName(existingBrand.getBrandName());
			productMapper.updateByExampleSelective(product, productExample);

			return existingBrand;
		} catch (Exception e) {
			if (e instanceof ECommerceException)
				throw (ECommerceException) e;
			throw new ECommerceException("SQL Exception");
		}
	}

	@Override
	@Transactional(readOnly = false, rollbackFor = ECommerceException.class, propagation = Propagation.REQUIRED)
	public Brand addBrand(Brand brand) throws ECommerceException {
		try {
			BrandExample brandExample = new BrandExample();
			brandExample.setDistinct(true);
			brandExample.createCriteria().andBrandNameEqualTo(brand.getBrandName());
			List<Brand> brands = brandMapper.selectByExample(brandExample);
			if (!brands.isEmpty()) {
				throw new ECommerceException("Brand existing");
			}
			BrandValidator.validateNotNull(brand);
			Integer resultCode = brandMapper.insert(brand);
			if (resultCode <= 0) {
				throw new ECommerceException("Add failed");
			}
			brands = brandMapper.selectByExample(brandExample);
			return brands.get(0);
		} catch (Exception e) {
			if (e instanceof ECommerceException)
				throw (ECommerceException) e;
			throw new ECommerceException("SQL Exception");
		}
	}

	@Override
	@Transactional(readOnly = false, rollbackFor = ECommerceException.class, propagation = Propagation.REQUIRED)
	public Integer deleteBrand(Long brandId) throws ECommerceException {
		try {
			Brand brand = brandMapper.selectByPrimaryKey(brandId);
			if (brand == null) {
				throw new ECommerceException("Brand doesn't exists");
			}

			ProductExample productExample = new ProductExample();
			productExample.createCriteria().andBrandIdEqualTo(brandId);
			int count = productMapper.countByExample(productExample);
			if (count > 0) {
				throw new ECommerceException("Brand in use");
			}

			Integer resultCode = brandMapper.deleteByPrimaryKey(brandId);
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
