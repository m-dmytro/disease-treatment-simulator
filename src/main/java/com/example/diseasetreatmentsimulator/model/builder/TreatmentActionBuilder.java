package com.example.diseasetreatmentsimulator.model.builder;

import com.example.diseasetreatmentsimulator.mapper.TreatmentBuilderMapper;
import com.example.diseasetreatmentsimulator.model.treatment.DrugTreatment;
import com.example.diseasetreatmentsimulator.model.treatmentAction.DrugTreatmentAction;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;

@Component
public class TreatmentActionBuilder {

    private final TreatmentBuilderMapper treatmentBuilderMapper;

    public TreatmentActionBuilder(TreatmentBuilderMapper treatmentBuilderMapper) {
        this.treatmentBuilderMapper = treatmentBuilderMapper;
    }

    public LinkedList<DrugTreatmentAction> getGeneralTreatmentActions(LinkedList<DrugTreatment> prescribedDrugs) {
        LinkedList<DrugTreatmentAction> result = new LinkedList<>();
        for (DrugTreatment treatment: prescribedDrugs) {
            result.add(treatmentBuilderMapper
                    .fromDrugTreatmentType(treatment.getType())
                    .buildTreatment(treatment));
        }
        return result;
    }

}
