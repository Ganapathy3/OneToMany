package com.fa.controller;

import java.util.List;

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
import com.fa.entity.NewEntity;
import com.fa.service.NewService;

@RestController
public class NewController {

	@Autowired
	NewService newService;

	@PostMapping(value = "/save")
	public ResponseEntity<CommonDto<?>> save(@RequestBody NewDto dto) {

		CommonDto<?> response = newService.save(dto);
		return new ResponseEntity<CommonDto<?>>(response, HttpStatus.OK);
	}

	@GetMapping(value = "/view")
	public ResponseEntity<CommonDto<List<NewDto>>> view(@RequestBody NewDto dto) {

		CommonDto<List<NewDto>> response = newService.view(dto);
		return new ResponseEntity<CommonDto<List<NewDto>>>(response, HttpStatus.OK);
	}

	@PostMapping(value = "/updatePassword")
	public ResponseEntity<CommonDto<?>> updatePassword(@RequestBody NewDto dto) {
		CommonDto<?> response = newService.updatePassword(dto);
		return new ResponseEntity<CommonDto<?>>(response, HttpStatus.OK);
	}

}
