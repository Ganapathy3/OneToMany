package com.fa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fa.dto.BranchDto;
import com.fa.dto.CommonDto;
import com.fa.dto.RoleDto;
import com.fa.service.BranchService;

@RestController
public class BranchController {

	@Autowired
	BranchService branchService; 
	
	@PostMapping(value="/branchSave")
	public ResponseEntity<CommonDto<?>>save(@RequestBody BranchDto dto){
		
		CommonDto<?> response = branchService.save(dto);
		return new ResponseEntity<CommonDto<?>>(response,HttpStatus.OK);
	}
}
