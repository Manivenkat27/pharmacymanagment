package com.SupplierMicroservices;

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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import SupplierMicroservices.exceptions.SupplierAlreadyExistException;
import SupplierMicroservices.exceptions.SupplierNotFoundException;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/supplier")
public class SupplierController {
		
		@Autowired
		private SupplierRepository supplierrepo;
		
		@PostMapping("/addSupplier")
		public Supplier addsupplier(@RequestBody Supplier supplierrequest) {
		Optional<Supplier>supplier = supplierrepo.findById(supplierrequest.getId());
		
		if(!supplier.isPresent()) {
			return supplierrepo.save(supplierrequest);
			}
		else {
			throw new SupplierAlreadyExistException("Supplier Already exist");
			}
		}
		@GetMapping("/viewSupplier")
		public List<Supplier> viewSupplier() {
			return supplierrepo.findAll();
		}
		@GetMapping("/viewSupplier/{id}")
		public Optional<Supplier> viewSupplierById(@PathVariable(value="id") String id) {
			Optional<Supplier> drug= supplierrepo.findById(id);
			if(!drug.isPresent()) {
				throw new SupplierNotFoundException(" Supplier doesnot exist");
				
			}
			else {
				return supplierrepo.findById(id);
			}
			}
		
		@DeleteMapping("/deleteSupplier/{id}")
		public Optional<Supplier> deleteSupplier(@PathVariable(value="id") String id)
		{
			Optional<Supplier> supplier = supplierrepo.findById(id);
			supplierrepo.deleteById(id);
			Map<String,Supplier> response = new HashMap<>();
			response.put("Deleted", supplier.get());
			if(!supplier.isPresent()) {
				throw new SupplierNotFoundException("Supplier doesnot exist");
				
			}
			else {
				return supplierrepo.findById(id);
			}
			
			}
}
		
		

