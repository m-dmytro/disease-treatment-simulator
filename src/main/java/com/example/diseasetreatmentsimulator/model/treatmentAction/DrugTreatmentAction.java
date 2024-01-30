package com.example.diseasetreatmentsimulator.model.treatmentAction;

import com.example.diseasetreatmentsimulator.model.TreatmentResult;
import com.example.diseasetreatmentsimulator.model.TreatmentTask;

public abstract class DrugTreatmentAction {

    public abstract TreatmentResult treat(TreatmentTask task);

    public abstract TreatmentActionType getType();

}
