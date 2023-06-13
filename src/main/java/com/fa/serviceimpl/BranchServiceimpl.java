package com.fa.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fa.dto.BranchDto;
import com.fa.dto.CommonDto;
import com.fa.entity.BranchEntity;
import com.fa.repository.BranchRepository;
import com.fa.service.BranchService;

@Service
public class BranchServiceimpl implements BranchService{
	
	@Autowired
	BranchRepository branchRepository;

	@Override
	public CommonDto<?> save(BranchDto dto) {
		CommonDto<?> response = new CommonDto<>();
		
		BranchEntity  branch = new BranchEntity();
		branch.setBranch(dto.getBranch());
		branchRepository.save(branch);
		
		return response;
	}
	
	

}
