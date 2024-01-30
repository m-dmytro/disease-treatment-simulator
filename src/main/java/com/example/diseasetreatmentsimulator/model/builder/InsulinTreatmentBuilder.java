package com.example.diseasetreatmentsimulator.model.builder;

import com.example.diseasetreatmentsimulator.model.DrugType;
import com.example.diseasetreatmentsimulator.model.treatment.InsulinTreatment;
import com.example.diseasetreatmentsimulator.model.treatmentAction.DrugTreatmentAction;
import com.example.diseasetreatmentsimulator.model.treatmentAction.InsulinTreatmentAction;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class InsulinTreatmentBuilder extends DrugTreatmentBuilder<InsulinTreatment> {

    @Override
    public DrugType getDrugTreatmentType() {
        return DrugType.INSULIN;
    }

    @Override
    public DrugTreatmentAction buildTreatment(InsulinTreatment obj) {
        //TODO - update this method if you need to add extra data/references/etc. to *Action class
        return new InsulinTreatmentAction(obj.getType());
    }
}
