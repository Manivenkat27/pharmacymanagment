package com.DrugInventoryMicroservices;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.DrugInventoryMicroservices.exceptions.DrugAlreadyExistException;
import com.DrugInventoryMicroservices.exceptions.DrugNotFoundException;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/drug")
public class DrugController {
	
	@Autowired
	private DrugService drugService;

	@PostMapping("/addDrug")
	public Drug addDrug(@RequestBody Drug drugrequest) {
	Optional<Drug> drug = drugService.findByid(drugrequest.getId());
	if(!drug.isPresent()) {
		return drugService.saveDrug(drugrequest);
	}
	else {
		throw new DrugAlreadyExistException("Drug Already exists");
	}
}


	@GetMapping("/viewDrugs")
	public List<Drug> viewDrug() {
		return drugService.showDrugs();
	}
	
	
	@GetMapping("/viewDrug/{id}")
	public Optional<Drug> viewDrugById(@PathVariable(value="id") long id) {
		Optional<Drug> drug= drugService.findByid(id);
		
		if(!drug.isPresent()) {
			throw new DrugNotFoundException("Drug doesnot exist");		
		}
		else {
			return drugService.findByid(id);
		}
	}

	@PutMapping("/updateDrug/{id}")
	public Optional<Drug> updateDrug(@PathVariable(value="id")long id,@RequestBody Drug drug){
		Optional<Drug> olddrug = drugService.findByid(id);
		olddrug=Optional.ofNullable(drug);
		olddrug.get().setId(id);
		drugService.saveDrug(olddrug.get());
		if(!olddrug.isPresent()) {
			throw new DrugNotFoundException("Drug doesnot exist");
			
		}
		else {
			return drugService.findByid(id);
		}
		
	}
	
	
	@DeleteMapping("/deleteDrug/{id}")
	public Optional<Drug> deleteDrug(@PathVariable(value="id") long id)
	{
		Optional<Drug> drug = drugService.findByid(id);
		drugService.deleteDrug(id);
		Map<String,Drug> response = new HashMap<>();
		response.put("Deleted", drug.get());
		if(!drug.isPresent()) {
			throw new DrugNotFoundException("Drug doesnot exist");
			
		}
		else {
			return drugService.findByid(id);
		}
		
	}
	} 
	
	
	

	

