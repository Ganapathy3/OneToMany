package com.fa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fa.dto.CommonDto;
import com.fa.dto.NewDto;
import com.fa.dto.RoleDto;
import com.fa.service.RoleService;

@RestController
public class RoleController {

	@Autowired
	RoleService roleService;
	
	@PostMapping(value="/roleSave")
	public ResponseEntity<CommonDto<?>>save(@RequestBody RoleDto dto){
		
		CommonDto<?> response = roleService.save(dto);
		return new ResponseEntity<CommonDto<?>>(response,HttpStatus.OK);
	}
	
	@GetMapping(value="/roleView")
	public ResponseEntity<CommonDto<?>>view() {
		CommonDto<?> response = roleService.view();
		return new ResponseEntity<CommonDto<?>>(response,HttpStatus.OK);
	}
	
	@PostMapping(value="/roleDelete")
	public ResponseEntity<CommonDto> view(@RequestParam(name = "id") String id) {
		CommonDto commonDto = roleService.view(id);
		return new ResponseEntity<CommonDto>(commonDto, HttpStatus.OK);
	}
	}
