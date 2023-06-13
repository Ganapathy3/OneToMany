package com.fa.serviceimpl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import com.fa.dto.CommonDto;
import com.fa.dto.NewDto;
import com.fa.dto.RoleDto;
import com.fa.entity.NewEntity;
import com.fa.entity.RoleEntity;
import com.fa.repository.RoleRepository;
import com.fa.service.RoleService;

@Service
public class RoleServiceimpl implements RoleService {

	@Autowired
	RoleRepository roleRepository;

	@Override
	public CommonDto<?> save(RoleDto dto) {

		CommonDto<?> response = new CommonDto<>();

		List<RoleEntity> roles = new ArrayList<RoleEntity>();
		RoleEntity r = new RoleEntity();
		r.setRole(dto.getRole());
		RoleEntity save = roleRepository.save(r);
        
		return response;
	}

	@Override
	public CommonDto<?> view() {
		
		CommonDto<?> response = new CommonDto<>();

		List<RoleEntity> list = roleRepository.findAll();
		response.setStatus("Success");
		//response.setResponseDto(list);
		
		return response;
	}

	@Override
	public CommonDto view(String id) {
	
		CommonDto<?> response = new CommonDto<>();
		roleRepository.deleteById(Long.valueOf(id));
		response.setStatus("Success");
		return response;
	}
	

}
