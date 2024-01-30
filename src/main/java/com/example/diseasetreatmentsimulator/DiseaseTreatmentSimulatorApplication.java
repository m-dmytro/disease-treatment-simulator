package com.example.diseasetreatmentsimulator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.util.Scanner;

@SpringBootApplication
public class DiseaseTreatmentSimulatorApplication {

	private static Logger LOG = LoggerFactory.getLogger(DiseaseTreatmentSimulatorApplication.class);

	public static void main(String[] args) {
		LOG.info("App has been started");
		SpringApplication.run(DiseaseTreatmentSimulatorApplication.class, args);
		LOG.info("App finished");
	}

}
