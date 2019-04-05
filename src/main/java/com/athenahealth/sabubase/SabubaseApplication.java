package com.athenahealth.sabubase;

import com.athenahealth.schema.Measure;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SabubaseApplication {

	static Measure measure;

	public static void main(String[] args) {

		SpringApplication.run(SabubaseApplication.class, args);
		measure = Measure.newBuilder().build();
		measure.setTest("hi");
	}

}
