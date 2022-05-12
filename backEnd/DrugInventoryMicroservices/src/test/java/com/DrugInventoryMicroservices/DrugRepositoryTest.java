package com.DrugInventoryMicroservices;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class DrugRepositoryTest {

	@Autowired
	private DrugRepository drugRepo;
	
	 @BeforeEach
	    void initUseCase() {
		 Drug drug = new Drug(201L, "xyz", 45);
		 drugRepo.save(drug);
	    }

	    @AfterEach
	    public void destroyAll(){
	    	drugRepo.deleteById(201L);
	    }
	


}
