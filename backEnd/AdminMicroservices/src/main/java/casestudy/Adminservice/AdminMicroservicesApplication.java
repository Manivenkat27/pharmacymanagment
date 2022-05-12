package casestudy.Adminservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class AdminMicroservicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdminMicroservicesApplication.class, args);
	}
	@Bean
	public RestTemplate  getRestTemplate() {
		return new RestTemplate();
	}
	

}

	