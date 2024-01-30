package com.example.diseasetreatmentsimulator.model.builder;

import com.example.diseasetreatmentsimulator.model.DrugType;
import com.example.diseasetreatmentsimulator.model.treatment.GeneralTreatmentCases;
import com.example.diseasetreatmentsimulator.model.treatmentAction.DrugTreatmentAction;
import com.example.diseasetreatmentsimulator.model.treatmentAction.GeneralTreatmentCaseAction;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GeneralTreatmentCaseBuilder extends DrugTreatmentBuilder<GeneralTreatmentCases> {

    @Override
    public DrugType getDrugTreatmentType() {
        return DrugType.GENERAL_CASE;
    }

    @Override
    public DrugTreatmentAction buildTreatment(GeneralTreatmentCases obj) {
        //TODO - update this method if you need to add extra data/references/etc. to *Action class
        return new GeneralTreatmentCaseAction(obj.getType());
    }
}
