package com.example.diseasetreatmentsimulator.model.treatment;

import com.example.diseasetreatmentsimulator.model.DrugType;
import lombok.Data;

@Data
public class InsulinTreatment extends DrugTreatment {
    //TODO - use this class to specify special parameters/etc. for this treatment

    public InsulinTreatment() {
        super.type = DrugType.INSULIN;
    }
}
