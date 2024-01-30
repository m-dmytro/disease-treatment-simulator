package com.example.diseasetreatmentsimulator.model.builder;

import com.example.diseasetreatmentsimulator.model.DrugType;
import com.example.diseasetreatmentsimulator.model.treatment.ParacetamolTreatment;
import com.example.diseasetreatmentsimulator.model.treatmentAction.DrugTreatmentAction;
import com.example.diseasetreatmentsimulator.model.treatmentAction.ParacetamolTreatmentAction;
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
