package com.example.diseasetreatmentsimulator.treatment.treatmentAction;

import com.example.diseasetreatmentsimulator.treatment.model.DrugType;
import com.example.diseasetreatmentsimulator.treatment.model.PatientState;
import com.example.diseasetreatmentsimulator.treatment.model.TreatmentResult;
import com.example.diseasetreatmentsimulator.treatment.model.TreatmentTask;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class AntibioticTreatmentActionTest {

    private AntibioticTreatmentAction sut;

    @BeforeEach
    void warmUp() {
        sut = new AntibioticTreatmentAction(DrugType.ANTIBIOTIC);
    }

    @Test
    void treat_patientHealthy_whenTuberculosis() {
        //Given
        TreatmentTask task = new TreatmentTask(PatientState.TUBERCULOSIS, List.of());

        //When
        TreatmentResult actualResult = sut.treat(task);

        //Then
        Assertions.assertEquals(PatientState.HEALTHY, actualResult.getPatientState());
        Assertions.assertEquals(1, actualResult.getAlreadyUsedDrugs().size());
        Assertions.assertTrue(actualResult.getAlreadyUsedDrugs().contains(DrugType.ANTIBIOTIC));
    }

    @Test
    void treat_patientFever_whenHealthyPatientTakeInsulinAndAntibiotic() {
        //Given
        TreatmentTask task = new TreatmentTask(PatientState.HEALTHY, List.of(DrugType.INSULIN));

        //When
        TreatmentResult actualResult = sut.treat(task);

        //Then
        Assertions.assertEquals(PatientState.FEVER, actualResult.getPatientState());
        Assertions.assertEquals(2, actualResult.getAlreadyUsedDrugs().size());
        Assertions.assertTrue(actualResult.getAlreadyUsedDrugs().contains(DrugType.INSULIN));
        Assertions.assertTrue(actualResult.getAlreadyUsedDrugs().contains(DrugType.ANTIBIOTIC));
    }

    @Test
    void treat_patientStateNotChanged_whenNotTuberculosis() {
        //Given
        TreatmentTask task = new TreatmentTask(PatientState.FEVER, List.of());

        //When
        TreatmentResult actualResult = sut.treat(task);

        //Then
        Assertions.assertEquals(PatientState.FEVER, actualResult.getPatientState());
        Assertions.assertEquals(1, actualResult.getAlreadyUsedDrugs().size());
        Assertions.assertTrue(actualResult.getAlreadyUsedDrugs().contains(DrugType.ANTIBIOTIC));
    }

}
