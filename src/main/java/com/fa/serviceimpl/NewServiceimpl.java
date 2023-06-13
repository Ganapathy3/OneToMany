package com.fa.serviceimpl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fa.dto.AddressDto;
import com.fa.dto.BranchDto;
import com.fa.dto.CommonDto;
import com.fa.dto.NewDto;
import com.fa.dto.RoleDto;
import com.fa.entity.AddressEntity;
import com.fa.entity.BranchEntity;
import com.fa.entity.NewEntity;
import com.fa.entity.RoleEntity;
import com.fa.repository.AddressRepository;
import com.fa.repository.BranchRepository;
import com.fa.repository.NewRepository;
import com.fa.repository.RoleRepository;
import com.fa.service.NewService;

@Service
public class NewServiceimpl implements NewService {

	@Autowired
	NewRepository newRepository;

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	BranchRepository branchRepository;

	@Autowired
	AddressRepository addressRepository;

	@Override
	public CommonDto<?> save(NewDto dto) {

		CommonDto<?> response = new CommonDto<>();

		// Update the Data
		if (null != dto.getId() && !dto.getId().isEmpty()) {
			Optional<NewEntity> en = newRepository.findById(Long.valueOf(dto.getId()));
			if (en.isPresent()) {
				NewEntity users = en.get();
				users.setUserName(dto.getUserName());
				users.setPassword(dto.getPassword());
				List<RoleDto> rdto = dto.getRole();
				List<RoleEntity> roles = new ArrayList<RoleEntity>();
				for (RoleDto rd : rdto) {
					Optional<RoleEntity> role = roleRepository.findById(Long.valueOf(rd.getId()));
					if (role.isPresent()) {
						RoleEntity rol = role.get();
						rol.setRole(rd.getRole());
						roles.add(rol);
					}
				}
				users.setRole(roles);
				List<BranchDto> rdt = dto.getBranch();
				List<BranchEntity> branch = new ArrayList<BranchEntity>();
				for (BranchDto b : rdt) {
					Optional<BranchEntity> br = branchRepository.findById(Long.valueOf(b.getId()));
					if (br.isPresent()) {
						BranchEntity brc = br.get();
						brc.setBranch(b.getBranch());
						branch.add(brc);
					}
					users.setBranch(branch);
					List<AddressDto> ad = dto.getAddress();
					List<AddressEntity> address = new ArrayList<AddressEntity>();
					for (AddressDto a : ad) {
						Optional<AddressEntity> addr = addressRepository.findById(Long.valueOf(a.getId()));
						if (addr.isPresent()) {
							AddressEntity add = addr.get();
							add.setAddress(a.getAddress());
							address.add(add);
						}
					}
					users.setAddress(address);
					newRepository.save(users);
					response.setStatus("Data Updated Successfully For Id-" + dto.getId());
					response.setMessage("Updated");
				}
			} else {
				response.setStatus("Not Found");
			}

		} else {

			try {
				// To Save The Data
				NewEntity users = new NewEntity();
				users.setUserName(dto.getUserName());
				users.setPassword(dto.getPassword());
				List<RoleEntity> role = new ArrayList<RoleEntity>();
				List<NewEntity> user = new ArrayList<NewEntity>();
				user.add(users);
				List<RoleDto> dt = dto.getRole();
				for (RoleDto r : dt) {
					Optional<RoleEntity> roles = roleRepository.findById(Long.valueOf(r.getId()));
					RoleEntity roleEntity = roles.get();
					role.add(roleEntity);
				}
				users.setRole(role);
				List<BranchEntity> branch = new ArrayList<BranchEntity>();
				List<BranchDto> branchDto = dto.getBranch();
				for (BranchDto b : branchDto) {
					Optional<BranchEntity> p = branchRepository.findById(Long.valueOf(b.getId()));
					BranchEntity branchEntity = p.get();
					branch.add(branchEntity);
				}
				users.setBranch(branch);
				List<AddressEntity> address = new ArrayList<AddressEntity>();
				List<AddressDto> list = dto.getAddress();
				for (AddressDto add : list) {
					AddressEntity address1 = new AddressEntity();
					address1.setAddress(add.getAddress());
					address1.setUser(users);
					address.add(address1);
				}
				users.setAddress(address);
				NewEntity save = newRepository.save(users);
				response.setStatus("Saved Successfully");
				response.setMessage("User Data Saved Successfully");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return response;
	}

	// To View The Data
	@Override
	public CommonDto<List<NewDto>> view(NewDto dto) {
		CommonDto<List<NewDto>> response = new CommonDto<>();
		List<NewDto> dt = new ArrayList<NewDto>();
		List<NewEntity> list = newRepository.findAll();

		if (null != list) {
			for (NewEntity e : list) {
				Optional<NewEntity> li = newRepository.findById(Long.valueOf(e.getId()));
				NewEntity entity = li.get();
				NewDto to = new NewDto();
				to.setId(String.valueOf(entity.getId()));
				to.setUserName(entity.getUserName());
				to.setPassword(entity.getPassword());
				List<RoleDto> rdto = new ArrayList<RoleDto>();
				List<RoleEntity> roles = entity.getRole();
				for (RoleEntity r : roles) {
					RoleDto rd = new RoleDto();
					rd.setId(String.valueOf(r.getId()));
					rd.setRole(r.getRole());
					rd.setUser(to);
					rdto.add(rd);
				}
				to.setRole(rdto);
				List<BranchDto> branch = new ArrayList<BranchDto>();
				List<BranchEntity> br = entity.getBranch();
				for (BranchEntity b : br) {
					BranchDto bdto = new BranchDto();
					bdto.setId(String.valueOf(b.getId()));
					bdto.setBranch(b.getBranch());
					bdto.setUser(to);
					branch.add(bdto);
				}
				to.setBranch(branch);
				List<AddressDto> address = new ArrayList<AddressDto>();
				List<AddressEntity> add = entity.getAddress();
				for (AddressEntity a : add) {
					AddressDto ad = new AddressDto();
					ad.setId(String.valueOf(a.getId()));
					ad.setAddress(a.getAddress());
					ad.setUser(to);
					address.add(ad);
				}
				to.setAddress(address);
				dt.add(to);
			}
		}
		response.setStatus("Data Fetched Successfully");
		response.setResponseData(dt);
		return response;
	}

	// Password Update
	@Transactional
	@Override
	public CommonDto<?> updatePassword(NewDto dto) {
		CommonDto<?> response = new CommonDto<>();

		if (null != dto.getId() && !dto.getId().isEmpty()) {

			newRepository.updatePassword(dto.getPassword(), Long.valueOf(dto.getId()));
			response.setStatus("Password Updated Successfully For Id-" + dto.getId());
			response.setMessage("SuccessFully Updated");
		} else {
			response.setStatus("Id-" + dto.getId() + "Not Found");
			response.setMessage("Not Valid");
		}

		return response;
	}
}
