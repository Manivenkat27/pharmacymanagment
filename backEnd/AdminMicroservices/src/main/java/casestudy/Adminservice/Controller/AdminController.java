package casestudy.Adminservice.Controller;

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

import casestudy.Adminservice.Repository.AdminRepository;
import casestudy.Adminservice.Services.AdminService;
import casestudy.Adminservice.Services.JwtUtils;
import casestudy.Adminservice.model.AdminModel;
import casestudy.Adminservice.model.AuthenticationRequest;
import casestudy.Adminservice.model.AuthenticationResponse;
@CrossOrigin(origins = "*")
@RestController
public class AdminController {
	
@Autowired
private AdminRepository adminRepository;

@Autowired
private AdminService adminService;

@Autowired
private JwtUtils jwtUtils;

@Autowired
private AuthenticationManager authenticationManager;
//---------------------------Registration and Login -------------------------------//

@GetMapping("/test")
private String testingToken()
{
	return "running";
	
}
@GetMapping("/findadmin")
public List<AdminModel> getadmin() {
	return adminRepository.findAll();
}
	
@PostMapping("/reg")
	private ResponseEntity<?> subscribeClient(@RequestBody AuthenticationRequest authenticationRequest)
	{
		String Adminname = authenticationRequest.getAdminname();
		String password = authenticationRequest.getPassword();
		String emailid = authenticationRequest.getEmailid();
		String contactno = authenticationRequest.getContactno();
		AdminModel adminModel = new AdminModel();
        adminModel.setAdminname(Adminname);
        adminModel.setPassword(password);
        adminModel.setContactno(contactno);
        adminModel.setEmailid(emailid);
        try {
        	adminRepository.save(adminModel);
		}


		catch (Exception e)
		{
			return ResponseEntity.ok(new AuthenticationResponse("Error During Auth for Admin "+ Adminname));
		}
		return ResponseEntity.ok(new AuthenticationResponse("Successful Auth " + Adminname));
	}
	@PostMapping("/auth")
	private ResponseEntity<?> authenticateClient(@RequestBody AuthenticationRequest authenticationRequest)
	{
		String Adminname = authenticationRequest.getAdminname();
		String password = authenticationRequest.getPassword();

//--------------------------------CRUD Operations----------------------//
	try {
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(Adminname, password));
	} catch (Exception e) {
		return ResponseEntity.ok(new AuthenticationResponse("Error while authenticating " + Adminname));
	}
	//return ResponseEntity.ok(new AuthenticationResponse("Succesfull authentication for user " + username));
	UserDetails loadedUser = adminService.loadUserByUsername(Adminname);
	String generatedToken = jwtUtils.generateToken(loadedUser);
	return ResponseEntity.ok(new AuthenticationResponse(generatedToken));
}

}