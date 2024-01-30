package com.example.diseasetreatmentsimulator.model.treatment;

import com.example.diseasetreatmentsimulator.model.DrugType;
import lombok.Data;

@Data
public class AntibioticTreatment extends DrugTreatment {
    //TODO - use this class to specify special parameters/etc. for this treatment

    public AntibioticTreatment() {
        super.type = DrugType.ANTIBIOTIC;
    }
}
