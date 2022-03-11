package com.electronic.service;

import java.util.List;

import com.electronic.entity.Staff;

public interface StaffService {

	public List<Staff> listStaff();

	public void addStaff(Staff staff);
	
	public void delStaff(Integer id);

}
