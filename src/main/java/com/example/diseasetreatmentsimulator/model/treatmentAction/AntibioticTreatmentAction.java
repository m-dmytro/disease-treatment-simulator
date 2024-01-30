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
        String newPatientState;
        if (task.getPatientState().equalsIgnoreCase(PatientState.TUBERCULOSIS.getState())) {
            newPatientState = PatientState.HEALTHY.getState();
        } else if (task.getPatientState().equalsIgnoreCase(PatientState.HEALTHY.getState())
                && task.getAlreadyUsedDrugs().contains(DrugType.INSULIN)) {
            newPatientState = PatientState.FEVER.getState();
        } else {
            newPatientState = task.getPatientState();
        }

        List<DrugType> newListOfUsedDrugs = new ArrayList<>();
        newListOfUsedDrugs.addAll(task.getAlreadyUsedDrugs());
        newListOfUsedDrugs.add(this.drugType);
        return new TreatmentResult(newPatientState, newListOfUsedDrugs);

    }

    @Override
    public TreatmentActionType getType() {
        return TreatmentActionType.ANTIBIOTIC;
    }

}
