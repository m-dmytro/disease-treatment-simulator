package com.example.diseasetreatmentsimulator.mapper;

import com.example.diseasetreatmentsimulator.treatment.model.DrugType;
import com.example.diseasetreatmentsimulator.treatment.treatment.*;
import org.springframework.stereotype.Component;

import java.util.EnumMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Component
public class DrugTreatmentMapper {

    private final Map<DrugType, DrugTreatment> mappings;

    public DrugTreatmentMapper() {
        this.mappings = new EnumMap<>(DrugType.class);
        this.mappings.put(DrugType.ASPIRIN, new AspirinTreatment());
        this.mappings.put(DrugType.ANTIBIOTIC, new AntibioticTreatment());
        this.mappings.put(DrugType.INSULIN, new InsulinTreatment());
        this.mappings.put(DrugType.PARACETAMOL, new ParacetamolTreatment());
        this.mappings.put(DrugType.GENERAL_CASE, new GeneralTreatmentCases());
    }

    public LinkedList<DrugTreatment> getDrugTreatments(List<String> drugs) {
        LinkedList<DrugTreatment> result = new LinkedList<>();
        for (String drug: drugs) {
            result.add(this.mappings.get(DrugType.getDrugType(drug)));
        }
        result.add(this.mappings.get(DrugType.GENERAL_CASE));
        return result;
    }

}
