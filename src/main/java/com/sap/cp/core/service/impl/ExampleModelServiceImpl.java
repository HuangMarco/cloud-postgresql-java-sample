package com.sap.cp.core.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sap.cp.core.dto.ExampleModelEntityDTO;
import com.sap.cp.core.model.ExampleModelEntity;
import com.sap.cp.core.repository.ExampleModelEntityRepo;
import com.sap.cp.core.service.ExampleModelService;

@Service
public class ExampleModelServiceImpl implements ExampleModelService {
	
	private ExampleModelEntityRepo repo;
	
	@Autowired
	public ExampleModelServiceImpl( ExampleModelEntityRepo repo ){
		this.repo = repo;
	}

	@Override
	public ExampleModelEntityDTO addExampleModel(ExampleModelEntityDTO model) {
		
		ExampleModelEntity entity = new ExampleModelEntity();
		
		entity.setGroupName(model.getEntityName());
		
		return ExampleModelEntityDTO.convertToModel(repo.save(entity));
	}

	@Override
	public List<ExampleModelEntityDTO> getAllExampleModels() {
		
		List<ExampleModelEntityDTO> dtoList = new ArrayList<>();
		
		repo.findAll().forEach( item->dtoList.add(ExampleModelEntityDTO.convertToModel(item)) );
		
		return dtoList;
	}

	@Override
	public List<ExampleModelEntityDTO> addExampleModel( String groupName ) {
		ExampleModelEntity entity = new ExampleModelEntity();
		entity.setGroupName(groupName);
		repo.save(entity);
		
		return this.getAllExampleModels();
	}

}
