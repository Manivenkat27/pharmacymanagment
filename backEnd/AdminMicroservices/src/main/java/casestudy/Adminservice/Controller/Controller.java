package casestudy.Adminservice.Controller;


import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import casestudy.Adminservice.model.Drug;
import casestudy.Adminservice.model.Pickup;
import casestudy.Adminservice.model.Supplier;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/admin")
public class Controller {
	
	@Autowired
	private RestTemplate restTemplate;

	
	//Drugs 
	
	@GetMapping("/viewDrugs")
	public List<Object> getAllDrugInventoryInfo(){
		
		String url="http://localhost:8084/drug/viewDrugs";
		Object[] objects= restTemplate.getForObject(url, Object[].class);
		return Arrays.asList(objects);
	}


	@GetMapping("/viewDrug/{id}")
	public Object getDrugInventoryById(@RequestParam long id){
		
		String url="http://localhost:8084/drug/viewDrug/"+id;
		return restTemplate.getForObject(url, Object.class);
		}
	

	@PostMapping("/addDrug")
	public Drug addDrugInventoryInfo(@RequestBody Drug drug ) {

		 return restTemplate.postForObject("http://localhost:8084/drug/addDrug", drug, Drug.class);
	}
	

	//error
	@PutMapping("/updateDrug")
	public void updateDrugInventoryInfo(@RequestBody Drug drug) {
		restTemplate.put("http://localhost:8084/drug/updateDrug", drug);
	}

	@DeleteMapping("/deleteDrug/{id}")
	public String deleteDrugInventoryInfoById(@RequestParam long id){
		
		String url="http://localhost:8084/drug/deleteDrug/"+id;
		 restTemplate.delete(url);
		 return "Data with id '"+id+"' succesfully deleted";
	}

	//supplier

	@GetMapping("/viewSuppliers")
	public List<Object> getAllSuppliersInventoryInfo(){
		
		String url="http://localhost:8083/supplier/viewSuppliers";
		Object[] objects= restTemplate.getForObject(url, Object[].class);
		return Arrays.asList(objects);
	}


	@GetMapping("/viewSupplier/{id}")
	public Object getSupplierInventoryById(@RequestParam long id){
		
		String url="http://localhost:8083/supplier/viewSupplier/"+id;
		return restTemplate.getForObject(url, Object.class);
		}



	@PostMapping("/addSupplier")
	public Supplier addSupplierInventoryInfo(@RequestBody Supplier supplier ) {

		 return restTemplate.postForObject("http://localhost:8083/supplier/addSupplier", supplier, Supplier.class);
	}
	
	//error
	
	@PutMapping("/updateSupplier/{id}")
	public void updateSupplierInventoryInfo(@RequestBody Supplier supplier) {
		restTemplate.put("http://localhost:8083/supplier/updateSupplier/", supplier);
	}


	@DeleteMapping("/deleteSupplier/{id}")
	public String deleteSupplierInventoryInfoById(@RequestParam long id){
		
		String url="http://localhost:8083/supplier/deleteSupplier/"+id;
		 restTemplate.delete(url);
		 return "Data with id '"+id+"' succesfully deleted";
	}

	//orders

	@GetMapping("/viewOrders")
	public List<Object> getAllOrdersInventoryInfo(){
		
		String url="http://localhost:8085/orders/viewOrders";
		Object[] objects= restTemplate.getForObject(url, Object[].class);
		return Arrays.asList(objects);
	}


	@GetMapping("/viewOrders/{id}")
	public Object getOrdersInventoryById(@RequestParam long id){
		
		String url="http://localhost:8085/orders/viewOrders/"+id;
		return restTemplate.getForObject(url, Object.class);
		}
	//Pickup
	@GetMapping("/viewPickup")
	public List<Object> getAllPickupInfo(){
		
		String url="http://localhost:9091/pickup/viewPickup";
		Object[] objects= restTemplate.getForObject(url, Object[].class);
		return Arrays.asList(objects);
	}


	@GetMapping("/viewPickup/{id}")
	public Object getPickupById(@RequestParam long id){
		
		String url="http://localhost:9091/pickup/viewPickup/"+id;
		return restTemplate.getForObject(url, Object.class);
		}
	
	@PostMapping("/addPickup")
	public Pickup addPickupInfo(@RequestBody Pickup pickup ) {

		 return restTemplate.postForObject("http://localhost:9091/pickup/addPickup", pickup, Pickup.class);
	}
	

	
	
	

	@DeleteMapping("/deletePickup/{id}")
	public String deletePickupInfoById(@RequestParam long id){
		
		String url="http://localhost:9091/pickup/deletePickup/"+id;
		 restTemplate.delete(url);
		 return "Data with id '"+id+"' succesfully deleted";
	}
	
	

		
}




	


