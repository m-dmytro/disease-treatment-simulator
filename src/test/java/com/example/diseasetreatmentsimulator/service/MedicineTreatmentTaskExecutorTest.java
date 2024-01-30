package com.example.diseasetreatmentsimulator.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static com.example.diseasetreatmentsimulator.service.MedicineTreatmentTaskExecutor.UNSUPPORTED_DRUG_TYPE_ERROR;
import static com.example.diseasetreatmentsimulator.service.MedicineTreatmentTaskExecutor.UNSUPPORTED_PATIENT_TYPE_ERROR;

@SpringBootTest
public class MedicineTreatmentTaskExecutorTest {

    @Autowired
    MedicineTreatmentTaskExecutor sut;

    @Test
    void runAllRequestedTreatments_returnCorrectResult_when2DiabeticsWithoutDrugsWereRequested() {
        //Given
        List<String> patients = List.of("D", "D");
        List<String> drugs = List.of();

        //When
        String result = sut.runAllRequestedTreatments(patients, drugs);

        //Then
        Assertions.assertEquals("F:0,H:0,D:0,T:0,X:2", result);
    }

    @Test
    void runAllRequestedTreatments_returnCorrectResult_whenFeverWithParacetamolWasRequested() {
        //Given
        List<String> patients = List.of("F");
        List<String> drugs = List.of("P");

        //When
        String result = sut.runAllRequestedTreatments(patients, drugs);

        //Then
        Assertions.assertEquals("F:0,H:1,D:0,T:0,X:0", result);
    }

    @Test
    void runAllRequestedTreatments_returnCorrectResult_whenTuberculosisNFeverNDiabetesWithAntibioticNInsulinWereRequested() {
        //Given
        List<String> patients = List.of("T","F","D");
        List<String> drugs = List.of("An","I");

        //When
        String result = sut.runAllRequestedTreatments(patients, drugs);

        //Then
        Assertions.assertEquals("F:2,H:0,D:1,T:0,X:0", result);
    }

    @Test
    void runAllRequestedTreatments_returnErrorMessage_whenWrongPatientWasRequested() {
        //Given
        List<String> patients = List.of("T","F","De");
        List<String> drugs = List.of("An","I");

        //When
        String result = sut.runAllRequestedTreatments(patients, drugs);

        //Then
        Assertions.assertEquals(UNSUPPORTED_PATIENT_TYPE_ERROR, result);
    }

    @Test
    void runAllRequestedTreatments_returnErrorMessage_whenWrongDrugWasRequested() {
        //Given
        List<String> patients = List.of("T","F","D");
        List<String> drugs = List.of("An","In");

        //When
        String result = sut.runAllRequestedTreatments(patients, drugs);

        //Then
        Assertions.assertEquals(UNSUPPORTED_DRUG_TYPE_ERROR, result);
    }

}
