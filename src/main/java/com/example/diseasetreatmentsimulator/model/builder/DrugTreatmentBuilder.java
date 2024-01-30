package com.example.diseasetreatmentsimulator.model.builder;

import com.example.diseasetreatmentsimulator.model.treatment.DrugTreatment;
import com.example.diseasetreatmentsimulator.model.DrugType;
import lombok.NonNull;

public abstract class DrugTreatmentBuilder<T extends DrugTreatment> implements TreatmentBuilder<T> {

    @NonNull
    public abstract DrugType getDrugTreatmentType();

}
