package com.example.diseasetreatmentsimulator.model;

import java.util.ArrayList;
import java.util.List;

public class TreatmentTask {

    private String patientState;
    private List<DrugType> alreadyUsedDrugs;

    public TreatmentTask(String patientState) {
        this.patientState = patientState;
        this.alreadyUsedDrugs = new ArrayList<>();
    }

    public TreatmentTask(String patientState, List<DrugType> alreadyUsedDrugs) {
        this.patientState = patientState;
        this.alreadyUsedDrugs = alreadyUsedDrugs;
    }

    public void setPatientState(String patientState) {
        this.patientState = patientState;
    }

    public void setAlreadyUsedDrugs(List<DrugType> alreadyUsedDrugs) {
        this.alreadyUsedDrugs = alreadyUsedDrugs;
    }

    public String getPatientState() {
        return patientState;
    }

    public List<DrugType> getAlreadyUsedDrugs() {
        return alreadyUsedDrugs;
    }
}
