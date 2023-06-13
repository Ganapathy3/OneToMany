package com.fa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fa.entity.BranchEntity;

@Repository
public interface BranchRepository extends JpaRepository<BranchEntity, Long>{

}
