package com.sap.cp.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sap.cp.core.model.ExampleModelEntity;

@Repository
public interface ExampleModelEntityRepo extends JpaRepository<ExampleModelEntity, String>{
	
}
