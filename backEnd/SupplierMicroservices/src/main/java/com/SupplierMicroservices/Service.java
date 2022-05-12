package com.SupplierMicroservices;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;



	@Component
	public class Service {
		
		@Autowired
		private SupplierRepository supplierRepo;

		public List<Supplier> viewSupplier() {
			return supplierRepo.findAll();
		}

		
		public Supplier viewById(String id) {
			return supplierRepo.findById(id).get();
		}
		

		public void addSupplierInfo(Supplier supplier) {
			supplierRepo.save(supplier);
		}
		
		public void updateSupplier(Supplier supplier) {
			supplierRepo.save(supplier);
		}
			
		public void deleteById( String id) {
			 supplierRepo.deleteById(id);
		}

	    
	     

}
