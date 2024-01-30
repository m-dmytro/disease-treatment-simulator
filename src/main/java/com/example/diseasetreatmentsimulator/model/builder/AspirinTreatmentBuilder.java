package com.example.diseasetreatmentsimulator.model.builder;

import com.example.diseasetreatmentsimulator.model.DrugType;
import com.example.diseasetreatmentsimulator.model.treatment.AspirinTreatment;
import com.example.diseasetreatmentsimulator.model.treatmentAction.AspirinTreatmentAction;
import com.example.diseasetreatmentsimulator.model.treatmentAction.DrugTreatmentAction;
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
