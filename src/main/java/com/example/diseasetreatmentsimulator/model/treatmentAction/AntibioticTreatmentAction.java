package com.example.diseasetreatmentsimulator.model.treatmentAction;

import com.example.diseasetreatmentsimulator.model.DrugType;
import com.example.diseasetreatmentsimulator.model.PatientState;
import com.example.diseasetreatmentsimulator.model.TreatmentResult;
import com.example.diseasetreatmentsimulator.model.TreatmentTask;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class AntibioticTreatmentAction extends DrugTreatmentAction {

    private final DrugType drugType;

    public AntibioticTreatmentAction(DrugType drugType) {
        this.drugType = drugType;
    }

    /**
     * Antibiotic cures Tuberculosis
     * Insulin mixed with Antibiotic causes Healthy people to catch Fever
     */
    @Override
    public TreatmentResult treat(TreatmentTask task) {
        PatientState newPatientState;
        if (task.getPatientState().equals(PatientState.TUBERCULOSIS)) {
            newPatientState = PatientState.HEALTHY;
        } else if (task.getPatientState().equals(PatientState.HEALTHY) && task.getAlreadyUsedDrugs().contains(DrugType.INSULIN)) {
            newPatientState = PatientState.FEVER;
        } else {
            newPatientState = task.getPatientState();
        }

        List<DrugType> newListOfUsedDrugs = new ArrayList<>(task.getAlreadyUsedDrugs());
        newListOfUsedDrugs.add(this.drugType);
        return new TreatmentResult(newPatientState, newListOfUsedDrugs);

    }

    @Override
    public TreatmentActionType getType() {
        return TreatmentActionType.ANTIBIOTIC;
    }

}
