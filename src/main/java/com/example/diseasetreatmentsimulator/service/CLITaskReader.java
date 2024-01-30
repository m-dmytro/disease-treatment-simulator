package com.example.diseasetreatmentsimulator.service;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

@Service
public class CLITaskReader implements CommandLineRunner {
    private static final Logger LOG = LoggerFactory.getLogger(CLITaskReader.class);

    @Autowired
    private MedicineTreatmentTaskExecutor treatmentTaskExecutor;

    @Override
    public void run(String... args) {
        boolean isFinished = false;
        Scanner scanner = new Scanner(System.in);
        while (!isFinished) {
            scanInputLine(scanner);
            isFinished = isAllCasesProcessed(scanner, isFinished);
        }
        scanner.close();
    }

    private void scanInputLine(Scanner scanner) {
        LOG.info("Please specify patients and medicine: ");
        String inputArgs = scanner.nextLine();

        String[] args = inputArgs.split(" ");
        List<String> patients = Arrays.stream(args[0].split(","))
                .filter(StringUtils::isNotBlank).toList();

        if (2 < args.length || patients.isEmpty()) {
            LOG.error("Wrong request. Request should contains two parts with separation by space, e.g.: \"T,F,D An,I\"");
            return;
        }

        List<String> drugs = new ArrayList<>();
        if (args.length == 2) {
            drugs = List.of(args[1].split(","));
        }
        String resultOfTreatments = treatmentTaskExecutor.runAllRequestedTreatments(patients, drugs);
        if (StringUtils.isNotBlank(resultOfTreatments)) {
            LOG.info(resultOfTreatments);
        }
    }

    private static boolean isAllCasesProcessed(Scanner scanner, boolean isFinished) {
        LOG.info("Is all cases processed? Y / N");
        String yesOrNo = scanner.nextLine();
        if (yesOrNo.toLowerCase().equals("y")) {
            isFinished = true;
        }
        return isFinished;
    }

}
