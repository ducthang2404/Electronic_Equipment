package com.electronic.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.electronic.dao.StaffDAO;
import com.electronic.entity.Staff;
import com.electronic.service.StaffService;

@Service
public class StaffServiceImpl implements StaffService {

	@Autowired
	private StaffDAO staffDAO;

	@Override
	public List<Staff> listStaff() {

		return staffDAO.findAll();
	}

	@Override
	public void addStaff(Staff staff) {
		staffDAO.save(staff);
	}

}
