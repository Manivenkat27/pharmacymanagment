package com.DoctorMicroservices.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.DoctorMicroservices.Repository.DoctorRepository;
import com.DoctorMicroservices.Services.DoctorService;
import com.DoctorMicroservices.Services.JwtUtils;
import com.DoctorMicroservices.model.AuthenticationRequest;
import com.DoctorMicroservices.model.AuthenticationResponse;
import com.DoctorMicroservices.model.DoctorModel;


@CrossOrigin(origins = "*")
@RestController
public class DoctorController {
	
@Autowired
private DoctorRepository doctorRepository;

@Autowired
private DoctorService doctorService;

@Autowired
private JwtUtils jwtUtils;

@Autowired
private AuthenticationManager authenticationManager;
//---------------------------Registration and Login -------------------------------//

@GetMapping("/test")
private String testingToken()
{
	return "chal gya";
	
}
@CrossOrigin(origins = "*")
@GetMapping("/finddoctor")
public List<DoctorModel> getdoctor() {
	return doctorRepository.findAll();
}
	
@PostMapping("/reg")
	private ResponseEntity<?> subscribeClient(@RequestBody AuthenticationRequest authenticationRequest)
	{
		String Doctorname = authenticationRequest.getDoctorname();
		String password = authenticationRequest.getPassword();
		String emailid = authenticationRequest.getEmailid();
		String contactno = authenticationRequest.getContactno();
		DoctorModel doctorModel = new DoctorModel();
        doctorModel.setDoctorname(Doctorname);
        doctorModel.setPassword(password);
        doctorModel.setContactno(contactno);
        doctorModel.setEmailid(emailid);
        try {
        	doctorRepository.save(doctorModel);
		}


		catch (Exception e)
		{
			return ResponseEntity.ok(new AuthenticationResponse("Error During Auth for Doctor "+ Doctorname));
		}
		return ResponseEntity.ok(new AuthenticationResponse("Successful Auth " + Doctorname));
	}
	@PostMapping("/auth")
	private ResponseEntity<?> authenticateClient(@RequestBody AuthenticationRequest authenticationRequest)
	{
		String Doctorname = authenticationRequest.getDoctorname();
		String password = authenticationRequest.getPassword();

//--------------------------------CRUD Operations----------------------//
	try {
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(Doctorname, password));
	} catch (Exception e) {
		return ResponseEntity.ok(new AuthenticationResponse("Error while authenticating " + Doctorname));
	}
	//return ResponseEntity.ok(new AuthenticationResponse("Succesfull authentication for user " + username));
	UserDetails loadedUser = doctorService.loadUserByUsername(Doctorname);
	String generatedToken = jwtUtils.generateToken(loadedUser);
	return ResponseEntity.ok(new AuthenticationResponse(generatedToken));
}

}