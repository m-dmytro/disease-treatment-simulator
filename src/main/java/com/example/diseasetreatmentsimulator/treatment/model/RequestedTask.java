package com.example.diseasetreatmentsimulator.treatment.model;

import com.example.diseasetreatmentsimulator.treatment.treatmentAction.DrugTreatmentAction;

import java.util.LinkedList;
import java.util.List;

public record RequestedTask(LinkedList<DrugTreatmentAction> drugTreatmentActions, List<PatientState> patientStates, String error) {
    public RequestedTask(String error) {
        this(null, null, error);
    }

    public RequestedTask(LinkedList<DrugTreatmentAction> drugTreatmentActions, List<PatientState> patientStates) {
        this(drugTreatmentActions, patientStates, null);
    }
}
