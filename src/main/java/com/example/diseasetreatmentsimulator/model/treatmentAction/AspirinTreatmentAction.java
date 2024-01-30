package com.example.diseasetreatmentsimulator.model.treatmentAction;

import com.example.diseasetreatmentsimulator.model.DrugType;
import com.example.diseasetreatmentsimulator.model.PatientState;
import com.example.diseasetreatmentsimulator.model.TreatmentResult;
import com.example.diseasetreatmentsimulator.model.TreatmentTask;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class AspirinTreatmentAction extends DrugTreatmentAction {

    private final DrugType drugType;

    public AspirinTreatmentAction(DrugType drugType) {
        this.drugType = drugType;
    }

    /**
     * Aspirin cures Fever
     * Paracetamol kills subjects if mixed with Aspirin
     */
    @Override
    public TreatmentResult treat(TreatmentTask task) {
        String newPatientState;
        if (task.getPatientState().equalsIgnoreCase(PatientState.FEVER.getState())) {
            newPatientState = PatientState.HEALTHY.getState();
        } else if (task.getAlreadyUsedDrugs().contains(DrugType.PARACETAMOL)) {
            newPatientState = PatientState.DEAD.getState();
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
        return TreatmentActionType.ASPIRIN;
    }

}
