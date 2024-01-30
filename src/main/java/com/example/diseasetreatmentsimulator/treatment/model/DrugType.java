package com.example.diseasetreatmentsimulator.treatment.model;

import java.util.Arrays;

public enum DrugType {

    ASPIRIN("As"),
    ANTIBIOTIC("An"),
    INSULIN("I"),
    PARACETAMOL("P"),
    GENERAL_CASE("GeneralCase");

    private final String name;

    DrugType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static DrugType getDrugType(String requestedType) {
        return Arrays.stream(DrugType.values())
                .filter(type -> type.getName().equalsIgnoreCase(requestedType))
                .findAny()
                .orElseThrow(() -> new UnsupportedOperationException("Unsupported drug type"));
    }

}
