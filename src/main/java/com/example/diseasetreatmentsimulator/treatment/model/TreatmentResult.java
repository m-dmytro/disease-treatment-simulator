package com.example.diseasetreatmentsimulator.treatment.model;

import java.util.ArrayList;
import java.util.List;

public class TreatmentResult {

    private PatientState patientState;
    private List<DrugType> alreadyUsedDrugs;

    public TreatmentResult(PatientState patientState) {
        this.patientState = patientState;
        this.alreadyUsedDrugs = new ArrayList<>();
    }

    public TreatmentResult(PatientState patientState, List<DrugType> alreadyUsedDrugs) {
        this.patientState = patientState;
        this.alreadyUsedDrugs = alreadyUsedDrugs;
    }

    public PatientState getPatientState() {
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
