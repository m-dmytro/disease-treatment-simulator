package com.example.diseasetreatmentsimulator.model.treatmentAction;

import com.example.diseasetreatmentsimulator.model.DrugType;
import com.example.diseasetreatmentsimulator.model.PatientState;
import com.example.diseasetreatmentsimulator.model.TreatmentResult;
import com.example.diseasetreatmentsimulator.model.TreatmentTask;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class InsulinTreatmentAction extends DrugTreatmentAction {

    private final DrugType drugType;

    public InsulinTreatmentAction(DrugType drugType) {
        this.drugType = drugType;
    }

    /**
     * Insulin mixed with Antibiotic causes Healthy people to catch Fever
     */
    @Override
    public TreatmentResult treat(TreatmentTask task) {
        String newPatientState;
        if (task.getPatientState().equalsIgnoreCase(PatientState.HEALTHY.getState())
                && task.getAlreadyUsedDrugs().contains(DrugType.ANTIBIOTIC)) {
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
        return TreatmentActionType.INSULIN;
    }

}
