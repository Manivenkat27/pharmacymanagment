
package com.DrugInventoryMicroservices;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class DrugService {
	
	@Autowired
	private DrugRepository drugRepo;
	
	public List<Drug> showDrugs() {
		return drugRepo.findAll();
	}

	public Drug saveDrug(Drug drug) {
		
			return drugRepo.save(drug);
	}

	public Drug updateDrug(Drug drug) {
		return drugRepo.save(drug);
	}

	public void deleteDrug(long id) {
		
		drugRepo.deleteById(id);
		
	}

//	public Drug searchByName(String name) {
//		Drug drug1 = drugRepo.findByName(name);
//	
//			return drug1;
//	}

	public Optional<Drug> findByid(long id) {
			return drugRepo.findById(id);
		
	}

		
	}
	    
	     
	

