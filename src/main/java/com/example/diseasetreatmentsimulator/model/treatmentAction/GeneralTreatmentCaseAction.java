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
     *      Diabetes without Insulin treatments cause Death
     * One time in a million the Flying Spaghetti Monster shows his noodly power and resurrects a Dead patient, the patient becomes Healthy
     */
    @Override
    public TreatmentResult treat(TreatmentTask task) {
        PatientState newPatientState;
        if (task.getPatientState().equals(PatientState.DIABETES) && !task.getAlreadyUsedDrugs().contains(DrugType.INSULIN)) {
            newPatientState = PatientState.DEAD;
        } else {
            newPatientState = task.getPatientState();
        }

        if (isDeadPersonAliveByFlyingSpaghettiMonster(task)) {
            newPatientState = PatientState.HEALTHY;
        }

        List<DrugType> newListOfUsedDrugs = new ArrayList<>(task.getAlreadyUsedDrugs());
        newListOfUsedDrugs.add(this.drugType);
        return new TreatmentResult(newPatientState, newListOfUsedDrugs);
    }

    private static boolean isDeadPersonAliveByFlyingSpaghettiMonster(TreatmentTask task) {
        return task.getPatientState().equals(PatientState.DEAD) && isOneInMillionPossibility();
    }

    private static boolean isOneInMillionPossibility() {
        return new SplittableRandom().nextInt(1, 1_000_000) == 1;
    }

    @Override
    public TreatmentActionType getType() {
        return TreatmentActionType.GENERAL_CASE;
    }

}
