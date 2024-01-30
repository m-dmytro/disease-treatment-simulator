package com.example.diseasetreatmentsimulator.model.treatmentAction;

import com.example.diseasetreatmentsimulator.model.DrugType;
import com.example.diseasetreatmentsimulator.model.PatientState;
import com.example.diseasetreatmentsimulator.model.TreatmentResult;
import com.example.diseasetreatmentsimulator.model.TreatmentTask;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.SplittableRandom;

@Getter
public class GeneralTreatmentCaseAction extends DrugTreatmentAction {

    private final DrugType drugType;

    public GeneralTreatmentCaseAction(DrugType drugType) {
        this.drugType = drugType;
    }

    /**
     * Insulin prevents diabetic subjects from dying, does not cure Diabetes
     * One time in a million the Flying Spaghetti Monster shows his noodly power and resurrects a Dead patient, the patient becomes Healthy
     */
    @Override
    public TreatmentResult treat(TreatmentTask task) {
        String newPatientState;
        if (task.getPatientState().equalsIgnoreCase(PatientState.DIABETES.getState())
                && !task.getAlreadyUsedDrugs().contains(DrugType.INSULIN)) {
            newPatientState = PatientState.DEAD.getState();
        } else {
            newPatientState = task.getPatientState();
        }

        if (task.getPatientState().equalsIgnoreCase(PatientState.DEAD.getState())
                && new SplittableRandom().nextInt(1, 1_000_000) == 1) {
            newPatientState = PatientState.HEALTHY.getState();
        }

        List<DrugType> newListOfUsedDrugs = new ArrayList<>();
        newListOfUsedDrugs.addAll(task.getAlreadyUsedDrugs());
        newListOfUsedDrugs.add(this.drugType);
        return new TreatmentResult(newPatientState, newListOfUsedDrugs);
    }

    @Override
    public TreatmentActionType getType() {
        return TreatmentActionType.GENERAL_CASE;
    }

}
