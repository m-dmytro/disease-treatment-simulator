package com.example.diseasetreatmentsimulator.treatment.treatmentAction;

import com.example.diseasetreatmentsimulator.treatment.model.DrugType;
import com.example.diseasetreatmentsimulator.treatment.model.PatientState;
import com.example.diseasetreatmentsimulator.treatment.model.TreatmentResult;
import com.example.diseasetreatmentsimulator.treatment.model.TreatmentTask;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class ParacetamolTreatmentAction extends DrugTreatmentAction {

    private final DrugType drugType;

    public ParacetamolTreatmentAction(DrugType drugType) {
        this.drugType = drugType;
    }

    /**
     * Paracetamol cures Fever
     * Paracetamol kills subjects if mixed with Aspirin
     */
    @Override
    public TreatmentResult treat(TreatmentTask task) {
        PatientState newPatientState;
        if (task.getAlreadyUsedDrugs().contains(DrugType.ASPIRIN)) {
            newPatientState = PatientState.DEAD;
        } else if (task.getPatientState().equals(PatientState.FEVER)) {
            newPatientState = PatientState.HEALTHY;
        } else {
            newPatientState = task.getPatientState();
        }

        List<DrugType> newListOfUsedDrugs = new ArrayList<>(task.getAlreadyUsedDrugs());
        newListOfUsedDrugs.add(this.drugType);
        return new TreatmentResult(newPatientState, newListOfUsedDrugs);
    }

    @Override
    public TreatmentActionType getType() {
        return TreatmentActionType.PARACETAMOL;
    }

}
