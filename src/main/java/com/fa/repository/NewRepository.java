package com.fa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.fa.entity.NewEntity;

@Repository
public interface NewRepository extends JpaRepository<NewEntity, Long> {

	@Modifying
	@Query(value = "update new.user set password =:password where id =:id",nativeQuery = true)
	void updatePassword(String password,Long id);
	
//	@Query(value="Select * from user where id=?1",nativeQuery = true)
//	NewEntity updatePassword(String id);
	
}
