package com.example.diseasetreatmentsimulator.model.builder;

import com.example.diseasetreatmentsimulator.model.treatment.DrugTreatment;
import com.example.diseasetreatmentsimulator.model.treatmentAction.DrugTreatmentAction;

public interface TreatmentBuilder<T> {

    DrugTreatmentAction buildTreatment(T obj);

}
