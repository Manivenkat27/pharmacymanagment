package com.DoctorMicroservices.Controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.DoctorMicroservices.Repository.DoctorRepository;
import com.DoctorMicroservices.model.DoctorModel;
import com.DoctorMicroservices.model.Orders;

@RestController
@RequestMapping("/doctor")
public class Controller {
	
	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private DoctorRepository doctorrepo;
	
	@PostMapping("/addDoctor")
	public DoctorModel addDoctor(@RequestBody DoctorModel doctorModel)
	{
		return doctorrepo.save(doctorModel);
	}
	@GetMapping("/viewDoctors")
	public List<DoctorModel> viewDoctor() {
		return doctorrepo.findAll();
	}
	
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
	
	
	//Orders
	
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
	
	@PostMapping("/addOrders")
	public Orders addOrdersInventoryInfo(@RequestBody Orders orders ) {

		 return restTemplate.postForObject("http://localhost:8085/orders/addOrders", orders, Orders.class);
	}
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
	
}


	
	
	
	
	


