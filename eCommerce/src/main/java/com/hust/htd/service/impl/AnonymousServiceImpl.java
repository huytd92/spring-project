package com.hust.htd.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hust.htd.common.ECommerceException;
import com.hust.htd.common.Page;
import com.hust.htd.persistence.mapper.AnonymousMapper;
import com.hust.htd.persistence.model.Anonymous;
import com.hust.htd.persistence.model.AnonymousExample;
import com.hust.htd.persistence.model.Product;
import com.hust.htd.persistence.model.ProductExample;
import com.hust.htd.persistence.validator.UserValidator;
import com.hust.htd.service.AnonymousService;

/**
 * @author HuyTaDuc
 */

@Service
public class AnonymousServiceImpl implements AnonymousService {

	@Autowired
	private AnonymousMapper anonymousMapper;

	@Override
	@Transactional(readOnly = true, rollbackFor = ECommerceException.class, propagation = Propagation.REQUIRED)
	public Page<List<Anonymous>> getListAnonymous(Integer offset, Integer limit) throws ECommerceException {
		try {
			UserValidator.validateQueryParameter(offset, limit);
			AnonymousExample anonymousExample = new AnonymousExample();

			int count = anonymousMapper.countByExample(anonymousExample);

			anonymousExample.setOrderByClause(
					"anonymous_name ASC LIMIT " + String.valueOf(offset * limit) + ", " + String.valueOf(limit));
			List<Anonymous> anonymouss = anonymousMapper.selectByExample(anonymousExample);
			Page<List<Anonymous>> result = new Page<List<Anonymous>>();
			result.setContent(anonymouss);
			result.setSizeofList(count);
			result.setSizeofPage(anonymouss.size());
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
	public Anonymous getAnonymousById(Long anonymousId) throws ECommerceException {
		try {
			Anonymous anonymous = anonymousMapper.selectByPrimaryKey(anonymousId);
			if (anonymous == null) {
				throw new ECommerceException("anonymous doesn't exists");
			}
			return anonymous;
		} catch (Exception e) {
			if (e instanceof ECommerceException)
				throw (ECommerceException) e;
			throw new ECommerceException("SQL Exception");
		}
	}

	@Override
	@Transactional(readOnly = true, rollbackFor = ECommerceException.class, propagation = Propagation.REQUIRED)
	public Anonymous getAnonymousByAnonymousname(String anonymousname) throws ECommerceException {
		try {
			AnonymousExample anonymousExample = new AnonymousExample();
			anonymousExample.setDistinct(true);
			anonymousExample.createCriteria().andAnonymousNameEqualTo(anonymousname);
			List<Anonymous> anonymouss = anonymousMapper.selectByExample(anonymousExample);
			if (anonymouss.isEmpty()) {
				throw new ECommerceException("Anonymous doesn't exists");
			}
			return anonymouss.get(0);
		} catch (Exception e) {
			if (e instanceof ECommerceException)
				throw (ECommerceException) e;
			throw new ECommerceException("SQL Exception");
		}
	}

	@Override
	@Transactional(readOnly = false, rollbackFor = ECommerceException.class, propagation = Propagation.REQUIRED)
	public Anonymous updateAnonymous(Long anonymousId, Anonymous anonymous) throws ECommerceException {
		try {
			Anonymous existingAnonymous = anonymousMapper.selectByPrimaryKey(anonymousId);
			if (existingAnonymous == null) {
				throw new ECommerceException("Anonymous doesn't exists");
			}
			if (anonymous.getAnonymousName() != null) {
				existingAnonymous.setAnonymousName(anonymous.getAnonymousName());
			}
			Integer resultCode = anonymousMapper.updateByPrimaryKey(existingAnonymous);

			if (resultCode <= 0) {
				throw new ECommerceException("Update failed");
			}

			return existingAnonymous;
		} catch (Exception e) {
			if (e instanceof ECommerceException)
				throw (ECommerceException) e;
			throw new ECommerceException("SQL Exception");
		}
	}

	@Override
	@Transactional(readOnly = false, rollbackFor = ECommerceException.class, propagation = Propagation.REQUIRED)
	public Anonymous addAnonymous(Anonymous anonymous) throws ECommerceException {
		try {
			AnonymousExample anonymousExample = new AnonymousExample();
			anonymousExample.setDistinct(true);
			anonymousExample.createCriteria().andAnonymousNameEqualTo(anonymous.getAnonymousName());
			List<Anonymous> anonymouss = anonymousMapper.selectByExample(anonymousExample);
			if (!anonymouss.isEmpty()) {
				throw new ECommerceException("Anonymous existing");
			}
			Integer resultCode = anonymousMapper.insert(anonymous);
			if (resultCode <= 0) {
				throw new ECommerceException("Add failed");
			}
			anonymouss = anonymousMapper.selectByExample(anonymousExample);
			return anonymouss.get(0);
		} catch (Exception e) {
			if (e instanceof ECommerceException)
				throw (ECommerceException) e;
			throw new ECommerceException("SQL Exception");
		}
	}

	@Override
	@Transactional(readOnly = false, rollbackFor = ECommerceException.class, propagation = Propagation.REQUIRED)
	public Integer deleteAnonymous(Long anonymousId) throws ECommerceException {
		try {
			Anonymous anonymous = anonymousMapper.selectByPrimaryKey(anonymousId);
			if (anonymous == null) {
				throw new ECommerceException("Anonymous doesn't exists");
			}

			Integer resultCode = anonymousMapper.deleteByPrimaryKey(anonymousId);
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
