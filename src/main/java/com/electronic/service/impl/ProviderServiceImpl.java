package com.electronic.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.electronic.dao.ProviderDAO;
import com.electronic.entity.Provider;
import com.electronic.service.ProviderService;

@Service
public class ProviderServiceImpl implements ProviderService {

	@Autowired
	private ProviderDAO providerDao;

	@Override
	public List<Provider> listAll() {
		return providerDao.findAll();
	}

}
