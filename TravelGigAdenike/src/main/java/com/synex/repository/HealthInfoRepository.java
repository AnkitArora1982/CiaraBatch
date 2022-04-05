package com.synex.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.synex.domain.FamMem;
import com.synex.domain.HealthInfo;
import com.synex.domain.Role;


@Repository
public interface HealthInfoRepository extends JpaRepository<HealthInfo, Long>  {
	
}
