package com.example.diseasetreatmentsimulator.treatment.builder;

import com.example.diseasetreatmentsimulator.treatment.model.DrugType;
import com.example.diseasetreatmentsimulator.treatment.treatment.GeneralTreatmentCases;
import com.example.diseasetreatmentsimulator.treatment.treatmentAction.DrugTreatmentAction;
import com.example.diseasetreatmentsimulator.treatment.treatmentAction.GeneralTreatmentCaseAction;
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
