package com.example.diseasetreatmentsimulator.service;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CLITaskReaderImpl implements CommandLineRunner, ITaskReader {
    private static final Logger LOG = LoggerFactory.getLogger(CLITaskReaderImpl.class);

    private final MedicineTreatmentTaskExecutor treatmentTaskExecutor;

    public CLITaskReaderImpl(MedicineTreatmentTaskExecutor treatmentTaskExecutor) {
        this.treatmentTaskExecutor = treatmentTaskExecutor;
    }

    @Override
    public void run(String... args) {
        if (args.length != 0) {
            processRequestedTreatment(args);
        }
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

}
