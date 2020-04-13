package com.sap.cp.core.dto;

import com.sap.cp.core.model.ExampleModelEntity;

public class ExampleModelEntityDTO {
	private String entityName;

	public String getEntityName() {
		return entityName;
	}

	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}
	
	public static ExampleModelEntityDTO convertToModel(ExampleModelEntity entity){
		
		ExampleModelEntityDTO dto = new ExampleModelEntityDTO();
		
		dto.setEntityName(entity.getGroupName());
		
		return dto;
	}
	
}
