package com.example.diseasetreatmentsimulator.mapper;

import com.example.diseasetreatmentsimulator.model.DrugType;
import com.example.diseasetreatmentsimulator.model.builder.DrugTreatmentBuilder;
import com.example.diseasetreatmentsimulator.model.treatment.DrugTreatment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class TreatmentBuilderMapper {

    private final Map<DrugType, DrugTreatmentBuilder<? extends DrugTreatment>> map;

    public TreatmentBuilderMapper(List<DrugTreatmentBuilder<? extends DrugTreatment>> drugTreats) {
        map = drugTreats.stream()
                .collect(Collectors.toMap(DrugTreatmentBuilder::getDrugTreatmentType, Function.identity()));
    }

    public DrugTreatmentBuilder<DrugTreatment> fromDrugTreatmentType(DrugType drugType) {
        return (DrugTreatmentBuilder<DrugTreatment>) Optional.ofNullable(map.get(drugType))
                .orElseThrow(() -> new UnsupportedOperationException("Unsupported drug treatment type"));
    }

}
