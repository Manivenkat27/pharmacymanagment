package com.DrugInventoryMicroservices;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface DrugRepository extends MongoRepository<Drug, Long>{



}
