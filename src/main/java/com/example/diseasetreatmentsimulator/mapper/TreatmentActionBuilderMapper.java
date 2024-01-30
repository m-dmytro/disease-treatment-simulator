package com.example.diseasetreatmentsimulator.mapper;

import com.example.diseasetreatmentsimulator.treatment.treatment.DrugTreatment;
import com.example.diseasetreatmentsimulator.treatment.treatmentAction.DrugTreatmentAction;
import org.springframework.stereotype.Component;

import java.util.LinkedList;

@Component
public class TreatmentActionBuilderMapper {

    private final TreatmentBuilderMapper treatmentBuilderMapper;

    public TreatmentActionBuilderMapper(TreatmentBuilderMapper treatmentBuilderMapper) {
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
