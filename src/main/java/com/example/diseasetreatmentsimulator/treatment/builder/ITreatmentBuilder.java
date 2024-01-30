package com.example.diseasetreatmentsimulator.treatment.builder;

import com.example.diseasetreatmentsimulator.treatment.treatmentAction.DrugTreatmentAction;

public interface ITreatmentBuilder<T> {

    DrugTreatmentAction buildTreatment(T obj);

}
