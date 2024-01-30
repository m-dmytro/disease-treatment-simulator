package com.example.diseasetreatmentsimulator.treatment.treatment;

import com.example.diseasetreatmentsimulator.treatment.model.DrugType;
import lombok.Data;

@Data
public class ParacetamolTreatment extends DrugTreatment {
    //TODO - use this class to specify special parameters/etc. for this treatment

    public ParacetamolTreatment() {
        type = DrugType.PARACETAMOL;
    }

}
