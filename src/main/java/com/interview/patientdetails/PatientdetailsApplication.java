package com.interview.patientdetails;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class PatientdetailsApplication {

	public static void main(String[] args) {
		SpringApplication.run(PatientdetailsApplication.class, args);
	}

}
