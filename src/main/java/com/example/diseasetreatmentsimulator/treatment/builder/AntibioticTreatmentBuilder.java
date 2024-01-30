package com.example.diseasetreatmentsimulator.treatment.builder;

import com.example.diseasetreatmentsimulator.treatment.model.DrugType;
import com.example.diseasetreatmentsimulator.treatment.treatment.AntibioticTreatment;
import com.example.diseasetreatmentsimulator.treatment.treatmentAction.AntibioticTreatmentAction;
import com.example.diseasetreatmentsimulator.treatment.treatmentAction.DrugTreatmentAction;
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
