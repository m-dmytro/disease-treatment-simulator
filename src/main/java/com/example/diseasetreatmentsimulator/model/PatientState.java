package com.example.diseasetreatmentsimulator.model;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public enum PatientState {

    FEVER(1, "F"),
    HEALTHY(2, "H"),
    DIABETES(3, "D"),
    TUBERCULOSIS(4, "T"),
    DEAD(5, "X");

    private final int id;
    private final String state;

    PatientState(int id, String state) {
        this.id = id;
        this.state = state;
    }

    public int getId() {
        return id;
    }

    public String getState() {
        return state;
    }

    public static PatientState getPatientState(String patientState) {
        return Arrays.stream(PatientState.values())
                .filter(type -> type.getState().equalsIgnoreCase(patientState))
                .findAny()
                .orElseThrow(() -> new UnsupportedOperationException("Unsupported state type"));
    }

    public static List<PatientState> getOrderedValues() {
        return Arrays.stream(PatientState.values())
                .sorted(Comparator.comparingInt(PatientState::getId))
                .collect(Collectors.toList());
    }
}
