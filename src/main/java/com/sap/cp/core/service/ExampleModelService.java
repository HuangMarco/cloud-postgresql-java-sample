package com.sap.cp.core.service;

import java.util.List;

import com.sap.cp.core.dto.ExampleModelEntityDTO;

public interface ExampleModelService {
	
	public ExampleModelEntityDTO addExampleModel(ExampleModelEntityDTO model);
	
	public List<ExampleModelEntityDTO> getAllExampleModels();
	
	public List<ExampleModelEntityDTO> addExampleModel( String groupName );
	
}
