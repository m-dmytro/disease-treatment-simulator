package com.example.diseasetreatmentsimulator.treatment.builder;

import com.example.diseasetreatmentsimulator.treatment.treatment.DrugTreatment;
import com.example.diseasetreatmentsimulator.treatment.model.DrugType;
import lombok.NonNull;

public abstract class DrugTreatmentBuilder<T extends DrugTreatment> implements ITreatmentBuilder<T> {

    @NonNull
    public abstract DrugType getDrugTreatmentType();

}
