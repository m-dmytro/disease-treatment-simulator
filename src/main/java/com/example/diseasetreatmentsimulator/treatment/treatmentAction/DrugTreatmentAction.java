package com.example.diseasetreatmentsimulator.treatment.treatmentAction;

import com.example.diseasetreatmentsimulator.treatment.model.TreatmentResult;
import com.example.diseasetreatmentsimulator.treatment.model.TreatmentTask;

public abstract class DrugTreatmentAction {

    public abstract TreatmentResult treat(TreatmentTask task);

    public abstract TreatmentActionType getType();

}
