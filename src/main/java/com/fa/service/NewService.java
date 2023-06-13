package com.fa.service;

import java.util.List;

import com.fa.dto.CommonDto;
import com.fa.dto.NewDto;
import com.fa.entity.NewEntity;

public interface NewService {

	CommonDto<?> save(NewDto dto);

	CommonDto<List<NewDto>> view(NewDto dto);

	CommonDto<?> updatePassword(NewDto dto);

}
