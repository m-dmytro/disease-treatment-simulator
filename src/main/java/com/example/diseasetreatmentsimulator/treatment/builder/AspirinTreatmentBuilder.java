package com.example.diseasetreatmentsimulator.treatment.builder;

import com.example.diseasetreatmentsimulator.treatment.model.DrugType;
import com.example.diseasetreatmentsimulator.treatment.treatment.AspirinTreatment;
import com.example.diseasetreatmentsimulator.treatment.treatmentAction.AspirinTreatmentAction;
import com.example.diseasetreatmentsimulator.treatment.treatmentAction.DrugTreatmentAction;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AspirinTreatmentBuilder extends DrugTreatmentBuilder<AspirinTreatment> {

    @Override
    public DrugType getDrugTreatmentType() {
        return DrugType.ASPIRIN;
    }

    @Override
    public DrugTreatmentAction buildTreatment(AspirinTreatment obj) {
        //TODO - update this method if you need to add extra data/references/etc. to *Action class
        return new AspirinTreatmentAction(obj.getType());
    }
}
