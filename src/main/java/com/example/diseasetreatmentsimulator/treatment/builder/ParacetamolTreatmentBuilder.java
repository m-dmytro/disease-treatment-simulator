package com.example.diseasetreatmentsimulator.treatment.builder;

import com.example.diseasetreatmentsimulator.treatment.model.DrugType;
import com.example.diseasetreatmentsimulator.treatment.treatment.ParacetamolTreatment;
import com.example.diseasetreatmentsimulator.treatment.treatmentAction.DrugTreatmentAction;
import com.example.diseasetreatmentsimulator.treatment.treatmentAction.ParacetamolTreatmentAction;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ParacetamolTreatmentBuilder extends DrugTreatmentBuilder<ParacetamolTreatment> {

    @Override
    public DrugType getDrugTreatmentType() {
        return DrugType.PARACETAMOL;
    }

    @Override
    public DrugTreatmentAction buildTreatment(ParacetamolTreatment obj) {
        //TODO - update this method if you need to add extra data/references/etc. to *Action class
        return new ParacetamolTreatmentAction(obj.getType());
    }
}
