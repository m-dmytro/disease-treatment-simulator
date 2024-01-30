package com.example.diseasetreatmentsimulator.model.treatmentAction;

public enum TreatmentActionType {

    ASPIRIN(1, AspirinTreatmentAction.class),
    ANTIBIOTIC(2, AntibioticTreatmentAction.class),
    INSULIN(3, InsulinTreatmentAction.class),
    PARACETAMOL(4, ParacetamolTreatmentAction.class),
    GENERAL_CASE(100, GeneralTreatmentCaseAction.class);

    private final int typeId;
    private final Class<? extends DrugTreatmentAction> actionClass;

    TreatmentActionType(int typeId, Class<? extends DrugTreatmentAction> actionClass) {
        this.typeId = typeId;
        this.actionClass = actionClass;
    }

    public int getTypeId() {
        return typeId;
    }

    public Class<? extends DrugTreatmentAction> getActionClass() {
        return actionClass;
    }
}
