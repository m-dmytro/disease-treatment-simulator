package com.example.diseasetreatmentsimulator.model.treatment;

import com.example.diseasetreatmentsimulator.model.DrugType;
import lombok.Getter;

/**
 * Aspirin cures Fever
 * Antibiotic cures Tuberculosis
 * Insulin prevents diabetic subjects from dying, does not cure Diabetes
 * Insulin mixed with Antibiotic causes Healthy people to catch Fever
 * Paracetamol cures Fever
 * Paracetamol kills subjects if mixed with Aspirin
 * One time in a million the Flying Spaghetti Monster shows his noodly power and resurrects a Dead patient, the patient becomes Healthy
 */
public abstract class DrugTreatment {

    protected DrugType type;

    public DrugType getType() {
        return this.type;
    }

}

