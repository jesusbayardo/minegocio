package com.backend.sistema;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.client.RestTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import io.github.cdimascio.dotenv.Dotenv;
@SpringBootApplication
public class DemoApplication implements CommandLineRunner {
	
	 
	 
	 @Bean
	    public RestTemplate getresttemplat() {
	        return new RestTemplate();
	    }
	 
	 
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		
		
		
		
		
		
		
		
	}

	@Autowired
		private BCryptPasswordEncoder passwordEncoder;
	
	@Override
	public void run(String ...args)throws Exception{
		String Passs="12345";
		for(int i=0;i<4;i++) {
			String ecriptada =passwordEncoder.encode(Passs);
			
			System.out.println(ecriptada);
			
		}
	}
}
