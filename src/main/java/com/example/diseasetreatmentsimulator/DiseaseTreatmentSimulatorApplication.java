package com.example.diseasetreatmentsimulator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DiseaseTreatmentSimulatorApplication {

	private static final Logger LOG = LoggerFactory.getLogger(DiseaseTreatmentSimulatorApplication.class);

	public static void main(String[] args) {
		LOG.info("App has been started");
		SpringApplication.run(DiseaseTreatmentSimulatorApplication.class, args);
		LOG.info("App finished");
	}

}
