package com.fa.service;

import com.fa.dto.CommonDto;
import com.fa.dto.NewDto;
import com.fa.dto.RoleDto;

public interface RoleService {

	CommonDto<?> save(RoleDto dto);

	CommonDto<?> view();

	CommonDto view(String id);

}
