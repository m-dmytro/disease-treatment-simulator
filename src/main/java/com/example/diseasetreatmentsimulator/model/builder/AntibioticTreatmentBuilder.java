package com.example.diseasetreatmentsimulator.model.builder;

import com.example.diseasetreatmentsimulator.model.DrugType;
import com.example.diseasetreatmentsimulator.model.treatment.AntibioticTreatment;
import com.example.diseasetreatmentsimulator.model.treatmentAction.AntibioticTreatmentAction;
import com.example.diseasetreatmentsimulator.model.treatmentAction.DrugTreatmentAction;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AntibioticTreatmentBuilder extends DrugTreatmentBuilder<AntibioticTreatment> {

    @Override
    public DrugType getDrugTreatmentType() {
        return DrugType.ANTIBIOTIC;
    }

    @Override
    public DrugTreatmentAction buildTreatment(AntibioticTreatment obj) {
        //TODO - update this method if you need to add extra data/references/etc. to *Action class
        return new AntibioticTreatmentAction(obj.getType());
    }
}
