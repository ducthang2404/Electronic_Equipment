package com.electronic.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.electronic.entity.Staff;
import com.electronic.service.StaffService;

@Controller
public class StaffAdminController {

	@Autowired
	private StaffService staffService;

	@RequestMapping("admin/staff")
	public String listStaff(Model model){
		List<Staff> listStaffs = staffService.listStaff();
		model.addAttribute("listStaff", listStaffs);
		return "Staff";
		
	}

}
