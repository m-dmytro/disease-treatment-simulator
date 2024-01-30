package com.example.diseasetreatmentsimulator.treatment.builder;

import com.example.diseasetreatmentsimulator.treatment.model.DrugType;
import com.example.diseasetreatmentsimulator.treatment.treatment.InsulinTreatment;
import com.example.diseasetreatmentsimulator.treatment.treatmentAction.DrugTreatmentAction;
import com.example.diseasetreatmentsimulator.treatment.treatmentAction.InsulinTreatmentAction;
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
