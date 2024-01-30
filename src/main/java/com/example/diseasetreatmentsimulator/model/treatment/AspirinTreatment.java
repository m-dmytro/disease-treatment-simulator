package com.example.diseasetreatmentsimulator.model.treatment;

import com.example.diseasetreatmentsimulator.model.DrugType;
import lombok.Data;

@Data
public class AspirinTreatment extends DrugTreatment {
    //TODO - use this class to specify special parameters/etc. for this treatment

    public AspirinTreatment() {
        super.type = DrugType.ASPIRIN;
    }
}
