package com.example.diseasetreatmentsimulator.treatment.treatmentAction;

import com.example.diseasetreatmentsimulator.treatment.model.DrugType;
import com.example.diseasetreatmentsimulator.treatment.model.PatientState;
import com.example.diseasetreatmentsimulator.treatment.model.TreatmentResult;
import com.example.diseasetreatmentsimulator.treatment.model.TreatmentTask;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class GeneralTreatmentCaseActionTest {

    private GeneralTreatmentCaseAction sut;

    @BeforeEach
    void warmUp() {
        sut = new GeneralTreatmentCaseAction(DrugType.GENERAL_CASE);
    }

    @Test
    void treat_patientDead_whenDiabetesWithoutInsulin() {
        //Given
        TreatmentTask task = new TreatmentTask(PatientState.DIABETES, List.of(DrugType.PARACETAMOL, DrugType.ANTIBIOTIC));

        //When
        TreatmentResult actualResult = sut.treat(task);

        //Then
        Assertions.assertEquals(PatientState.DEAD, actualResult.getPatientState());
        Assertions.assertEquals(2, actualResult.getAlreadyUsedDrugs().size());
        Assertions.assertTrue(actualResult.getAlreadyUsedDrugs().contains(DrugType.PARACETAMOL));
        Assertions.assertTrue(actualResult.getAlreadyUsedDrugs().contains(DrugType.ANTIBIOTIC));
    }

}
