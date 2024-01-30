package com.example.diseasetreatmentsimulator.model;

import com.example.diseasetreatmentsimulator.model.treatmentAction.DrugTreatmentAction;

import java.util.LinkedList;
import java.util.List;

public record RequestedTask(LinkedList<DrugTreatmentAction> drugTreatmentActions, List<PatientState> patientStates) {
}
