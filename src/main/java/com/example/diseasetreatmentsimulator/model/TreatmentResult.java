package com.example.diseasetreatmentsimulator.model;

import java.util.ArrayList;
import java.util.List;

public class TreatmentResult {

    private String patientState;
    private List<DrugType> alreadyUsedDrugs;

    public TreatmentResult(String patientState) {
        this.patientState = patientState;
        this.alreadyUsedDrugs = new ArrayList<>();
    }

    public TreatmentResult(String patientState, List<DrugType> alreadyUsedDrugs) {
        this.patientState = patientState;
        this.alreadyUsedDrugs = alreadyUsedDrugs;
    }

    public String getPatientState() {
        return patientState;
    }

    public List<DrugType> getAlreadyUsedDrugs() {
        return alreadyUsedDrugs;
    }

    public void merge(TreatmentResult patientDrugTreatmentResult) {
        this.patientState = patientDrugTreatmentResult.getPatientState();
        this.alreadyUsedDrugs = new ArrayList<>(patientDrugTreatmentResult.getAlreadyUsedDrugs());
    }

}
