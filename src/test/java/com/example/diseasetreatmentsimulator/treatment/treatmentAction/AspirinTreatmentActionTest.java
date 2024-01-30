package com.example.diseasetreatmentsimulator.treatment.treatmentAction;

import com.example.diseasetreatmentsimulator.treatment.model.DrugType;
import com.example.diseasetreatmentsimulator.treatment.model.PatientState;
import com.example.diseasetreatmentsimulator.treatment.model.TreatmentResult;
import com.example.diseasetreatmentsimulator.treatment.model.TreatmentTask;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class AspirinTreatmentActionTest {


    private AspirinTreatmentAction sut;

    @BeforeEach
    void warmUp() {
        sut = new AspirinTreatmentAction(DrugType.ASPIRIN);
    }

    @Test
    void treat_patientHealthy_whenFever() {
        //Given
        TreatmentTask task = new TreatmentTask(PatientState.FEVER, List.of());

        //When
        TreatmentResult actualResult = sut.treat(task);

        //Then
        Assertions.assertEquals(PatientState.HEALTHY, actualResult.getPatientState());
        Assertions.assertEquals(1, actualResult.getAlreadyUsedDrugs().size());
        Assertions.assertTrue(actualResult.getAlreadyUsedDrugs().contains(DrugType.ASPIRIN));
    }

    @Test
    void treat_patientDead_whenAspirinAndParacetamol() {
        //Given
        TreatmentTask task = new TreatmentTask(PatientState.FEVER, List.of(DrugType.PARACETAMOL));

        //When
        TreatmentResult actualResult = sut.treat(task);

        //Then
        Assertions.assertEquals(PatientState.DEAD, actualResult.getPatientState());
        Assertions.assertEquals(2, actualResult.getAlreadyUsedDrugs().size());
        Assertions.assertTrue(actualResult.getAlreadyUsedDrugs().contains(DrugType.ASPIRIN));
        Assertions.assertTrue(actualResult.getAlreadyUsedDrugs().contains(DrugType.PARACETAMOL));
    }

    @Test
    void treat_patientStateNotChanged_whenNotFever() {
        //Given
        TreatmentTask task = new TreatmentTask(PatientState.TUBERCULOSIS, List.of());

        //When
        TreatmentResult actualResult = sut.treat(task);

        //Then
        Assertions.assertEquals(PatientState.TUBERCULOSIS, actualResult.getPatientState());
        Assertions.assertEquals(1, actualResult.getAlreadyUsedDrugs().size());
        Assertions.assertTrue(actualResult.getAlreadyUsedDrugs().contains(DrugType.ASPIRIN));
    }


}
