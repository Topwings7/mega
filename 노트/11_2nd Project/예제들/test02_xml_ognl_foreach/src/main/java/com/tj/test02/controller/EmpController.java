package com.tj.test02.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tj.test02.service.IService;

@Controller
public class EmpController {
	@Autowired
	private IService service;
	@RequestMapping(value="selection", method = RequestMethod.GET)
	public String selection(Model model) {
		model.addAttribute("deptList", service.deptList());
		return "selection";
	}
	@RequestMapping(value="list", method = RequestMethod.GET)
	public String test(String[] deptno, Model model) {
		model.addAttribute("empList", service.empList(deptno));
		return "empList";
	}
}
