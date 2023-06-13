package com.fa.service;

import com.fa.dto.BranchDto;
import com.fa.dto.CommonDto;

public interface BranchService {

	CommonDto<?> save(BranchDto dto);

}
