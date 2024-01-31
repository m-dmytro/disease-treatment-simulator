package com.example.diseasetreatmentsimulator.service;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ScannerTaskReaderImpl implements CommandLineRunner, ITaskReader {
    private static final Logger LOG = LoggerFactory.getLogger(ScannerTaskReaderImpl.class);

    private final MedicineTreatmentTaskExecutor treatmentTaskExecutor;

    public ScannerTaskReaderImpl(MedicineTreatmentTaskExecutor treatmentTaskExecutor) {
        this.treatmentTaskExecutor = treatmentTaskExecutor;
    }

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
        processRequestedTreatment(args);
    }

    public void processRequestedTreatment(String[] inputArgs) {
        List<String> patients = Arrays.stream(inputArgs[0].split(","))
                .filter(StringUtils::isNotBlank).toList();

        if (2 < inputArgs.length || patients.isEmpty()) {
            LOG.error("Wrong request. Request should contains two parts with separation by space, e.g.: \"T,F,D An,I\"");
            return;
        }

        List<String> drugs = new ArrayList<>();
        if (inputArgs.length == 2) {
            drugs = List.of(inputArgs[1].split(","));
        }
        String resultOfTreatments = treatmentTaskExecutor.runAllRequestedTreatments(patients, drugs);
        LOG.info("Treatment result: " + resultOfTreatments);
    }

    private static boolean isAllCasesProcessed(Scanner scanner, boolean isFinished) {
        LOG.info("Is all cases processed? Y / N");
        String yesOrNo = scanner.nextLine();
        if (yesOrNo.equalsIgnoreCase("y")) {
            isFinished = true;
        }
        return isFinished;
    }

}
