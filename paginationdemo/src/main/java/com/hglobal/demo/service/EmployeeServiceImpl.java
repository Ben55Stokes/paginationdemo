package com.hglobal.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.hglobal.demo.entity.EmployeeEntity;
import com.hglobal.demo.repository.EmployeeRepository;
import com.hglobal.demo.requestbody.EmployeeRequestBody;
import com.hglobal.demo.utility.Result;
import com.hglobal.demo.utility.Utility;

@Service
public class EmployeeServiceImpl {

	@Autowired
	EmployeeRepository employeeRepository;

	public Result getDetails(EmployeeRequestBody employeeRequestBody) {
		Result successResult = null;
		List<EmployeeEntity> employeesList = null;
		try {
			if (employeeRequestBody.isExport()) {
				employeesList = employeeRepository.findAll();
				successResult= Utility.createResultFromList(employeesList);
			} else {
				Pageable pageable = PageRequest.of(employeeRequestBody.getPageNo(), employeeRequestBody.getPageSize(),
						Sort.by(employeeRequestBody.getSort()).descending());
				Page<EmployeeEntity> page = employeeRepository.findAll(pageable);
				employeesList = page.getContent();
				successResult= Utility.createResultFromList(employeesList);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return successResult;
	}
}
