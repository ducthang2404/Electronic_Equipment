package com.electronic.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.electronic.entity.Category;
import com.electronic.entity.Product;
import com.electronic.entity.Provider;
import com.electronic.entity.Staff;
import com.electronic.service.StaffService;
import com.electronic.until.EncrytedPasswordUtils;

@Controller
public class StaffAdminController {

	@Autowired
	private StaffService staffService;

	@RequestMapping("user/staff")
	public String listStaff(Model model) {
		List<Staff> listStaffs = staffService.listStaff();
		model.addAttribute("listStaff", listStaffs);
		return "Staff";

	}

	@RequestMapping("user/createStaff")
	public String createStaff(Model model) {
		Staff staff = new Staff();
		model.addAttribute("staff", staff);
		return "CreateStaff";
	}

	@RequestMapping("user/addStaff")
	public String createStaff(Model model, @ModelAttribute("staff") Staff staff) {
		Staff staff2 = staff;
		
		//ma hoa mat khau
		staff2.setPassword(EncrytedPasswordUtils.encrytePassword(staff.getPassword()));
		
		//luu vao db
		staffService.addStaff(staff2);
		return "redirect:/user/staff";
	}
	
	@RequestMapping("user/delStaff{id}")
	public String delStaff(@PathVariable("id") Integer id) {
		staffService.delStaff(id);
		return "redirect:/user/staff";
	}
	
	
}
