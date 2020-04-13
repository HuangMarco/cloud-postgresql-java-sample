package com.sap.cp.core.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sap.cp.core.dto.ExampleModelEntityDTO;
import com.sap.cp.core.service.ExampleModelService;
import com.sap.cp.core.util.Constants;

@RestController
@RequestMapping(Constants.Root_API)
public class WebController {
	
	private ExampleModelService modelService;
	
	
	@Autowired
	public WebController( ExampleModelService modelService ){
		this.modelService = modelService;
	}
	
	@GetMapping( "/all/constant" )
	public List<String> getAllConstants(){
		List<String> newList = new ArrayList<>();
		newList.add("test");
		newList.add("test1");
		newList.add("test2");
		newList.add("test3");
		return newList;
	}
	
	@PostMapping(path = "/model_add", consumes = "application/json", produces = "application/json")
	public void addMember(@RequestBody ExampleModelEntityDTO dto) {
		
		modelService.addExampleModel(dto);
		
	}
	
	@GetMapping( "/all/models" )
	public List<ExampleModelEntityDTO> getAllExampleModel(){
		
		return modelService.getAllExampleModels();
		
	}
	
	@GetMapping( "/add/model/{groupName}" )
	public List<ExampleModelEntityDTO> addExampleModel( @PathVariable String groupName ){
		
		return modelService.addExampleModel(groupName);
		
	}
	
}
