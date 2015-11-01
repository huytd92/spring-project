package com.hust.htd.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hust.htd.common.ECommerceException;
import com.hust.htd.common.Page;
import com.hust.htd.persistence.mapper.OriginMapper;
import com.hust.htd.persistence.mapper.ProductMapper;
import com.hust.htd.persistence.model.Origin;
import com.hust.htd.persistence.model.OriginExample;
import com.hust.htd.persistence.model.Product;
import com.hust.htd.persistence.model.ProductExample;
import com.hust.htd.persistence.validator.OriginValidator;
import com.hust.htd.persistence.validator.UserValidator;
import com.hust.htd.service.OriginService;

/**
 * @author HuyTaDuc
 */

@Service
public class OriginServiceImpl implements OriginService {

	@Autowired
	private OriginMapper originMapper;

	@Autowired
	private ProductMapper productMapper;

	@Override
	@Transactional(readOnly = true, rollbackFor = ECommerceException.class, propagation = Propagation.REQUIRED)
	public Page<List<Origin>> getListOrigin(Integer offset, Integer limit) throws ECommerceException {
		try {
			UserValidator.validateQueryParameter(offset, limit);
			OriginExample originExample = new OriginExample();

			int count = originMapper.countByExample(originExample);

			originExample.setOrderByClause("origin_name collate utf8_unicode_ci LIMIT " + String.valueOf(offset * limit)
					+ ", " + String.valueOf(limit));
			List<Origin> origins = originMapper.selectByExample(originExample);
			Page<List<Origin>> result = new Page<List<Origin>>();
			result.setContent(origins);
			result.setSizeofList(count);
			result.setSizeofPage(origins.size());
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
	public Origin getOriginById(Long originId) throws ECommerceException {
		try {
			Origin origin = originMapper.selectByPrimaryKey(originId);
			if (origin == null) {
				throw new ECommerceException("Origin doesn't exists");
			}
			return origin;
		} catch (Exception e) {
			if (e instanceof ECommerceException)
				throw (ECommerceException) e;
			throw new ECommerceException("SQL Exception");
		}
	}

	@Override
	@Transactional(readOnly = true, rollbackFor = ECommerceException.class, propagation = Propagation.REQUIRED)
	public Origin getOriginByOriginname(String originname) throws ECommerceException {
		try {
			OriginExample originExample = new OriginExample();
			originExample.setDistinct(true);
			originExample.createCriteria().andOriginNameEqualTo(originname);
			List<Origin> origins = originMapper.selectByExample(originExample);
			if (origins.isEmpty()) {
				throw new ECommerceException("Origin doesn't exists");
			}
			return origins.get(0);
		} catch (Exception e) {
			if (e instanceof ECommerceException)
				throw (ECommerceException) e;
			throw new ECommerceException("SQL Exception");
		}
	}

	@Override
	@Transactional(readOnly = false, rollbackFor = ECommerceException.class, propagation = Propagation.REQUIRED)
	public Origin updateOrigin(Long originId, Origin origin) throws ECommerceException {
		try {
			Origin existingOrigin = originMapper.selectByPrimaryKey(originId);
			if (existingOrigin == null) {
				throw new ECommerceException("Origin doesn't exists");
			}
			if (origin.getOriginName() != null) {
				existingOrigin.setOriginName(origin.getOriginName());
			}
			OriginValidator.validateNotNull(existingOrigin);
			Integer resultCode = originMapper.updateByPrimaryKey(existingOrigin);
			if (resultCode <= 0) {
				throw new ECommerceException("Update failed");
			}

			ProductExample productExample = new ProductExample();
			productExample.createCriteria().andOriginIdEqualTo(originId);
			Product product = new Product();
			product.setOriginName(existingOrigin.getOriginName());
			productMapper.updateByExampleSelective(product, productExample);

			return existingOrigin;
		} catch (Exception e) {
			if (e instanceof ECommerceException)
				throw (ECommerceException) e;
			throw new ECommerceException("SQL Exception");
		}
	}

	@Override
	@Transactional(readOnly = false, rollbackFor = ECommerceException.class, propagation = Propagation.REQUIRED)
	public Origin addOrigin(Origin origin) throws ECommerceException {
		try {
			OriginExample originExample = new OriginExample();
			originExample.setDistinct(true);
			originExample.createCriteria().andOriginNameEqualTo(origin.getOriginName());
			List<Origin> origins = originMapper.selectByExample(originExample);
			if (!origins.isEmpty()) {
				throw new ECommerceException("Origin existing");
			}
			OriginValidator.validateNotNull(origin);
			Integer resultCode = originMapper.insert(origin);
			if (resultCode <= 0) {
				throw new ECommerceException("Add failed");
			}
			origins = originMapper.selectByExample(originExample);
			return origins.get(0);
		} catch (Exception e) {
			if (e instanceof ECommerceException)
				throw (ECommerceException) e;
			throw new ECommerceException("SQL Exception");
		}
	}

	@Override
	@Transactional(readOnly = false, rollbackFor = ECommerceException.class, propagation = Propagation.REQUIRED)
	public Integer deleteOrigin(Long originId) throws ECommerceException {
		try {
			Origin origin = originMapper.selectByPrimaryKey(originId);
			if (origin == null) {
				throw new ECommerceException("Origin doesn't exists");
			}

			ProductExample productExample = new ProductExample();
			productExample.createCriteria().andOriginIdEqualTo(originId);
			int count = productMapper.countByExample(productExample);
			if (count > 0) {
				throw new ECommerceException("Origin in use");
			}

			Integer resultCode = originMapper.deleteByPrimaryKey(originId);
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
