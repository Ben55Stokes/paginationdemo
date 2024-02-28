package com.hglobal.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hglobal.demo.requestbody.EmployeeRequestBody;
import com.hglobal.demo.service.EmployeeServiceImpl;
import com.hglobal.demo.utility.Result;

@RestController
public class EmployeeController {

	@Autowired
	EmployeeServiceImpl employeeServiceImpl;
	
	@PostMapping("/find-all-employees")
	public Result getEmployees(@RequestBody EmployeeRequestBody employeeRequestBody) {
		return employeeServiceImpl.getDetails(employeeRequestBody);
	}
}
