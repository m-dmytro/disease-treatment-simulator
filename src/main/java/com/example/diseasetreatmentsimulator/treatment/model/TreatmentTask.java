package com.example.diseasetreatmentsimulator.treatment.model;

import java.util.List;

public class TreatmentTask {

    private PatientState patientState;
    private List<DrugType> alreadyUsedDrugs;

    public TreatmentTask(PatientState patientState, List<DrugType> alreadyUsedDrugs) {
        this.patientState = patientState;
        this.alreadyUsedDrugs = alreadyUsedDrugs;
    }

    public PatientState getPatientState() {
        return patientState;
    }

    public List<DrugType> getAlreadyUsedDrugs() {
        return alreadyUsedDrugs;
    }
}
