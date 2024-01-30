package com.example.diseasetreatmentsimulator.service;

import com.example.diseasetreatmentsimulator.mapper.DrugTreatmentMapper;
import com.example.diseasetreatmentsimulator.model.PatientState;
import com.example.diseasetreatmentsimulator.model.TreatmentResult;
import com.example.diseasetreatmentsimulator.model.TreatmentTask;
import com.example.diseasetreatmentsimulator.model.builder.TreatmentActionBuilder;
import com.example.diseasetreatmentsimulator.model.treatment.DrugTreatment;
import com.example.diseasetreatmentsimulator.model.treatmentAction.DrugTreatmentAction;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class MedicineTreatmentTaskExecutor {

    @Autowired
    private DrugTreatmentMapper drugTreatmentMapper;
    @Autowired
    private TreatmentActionBuilder treatmentActionBuilder;

    public String runAllRequestedTreatments(List<String> patients, List<String> drugs) {
        LinkedList<DrugTreatment> drugTreatments = drugTreatmentMapper.getDrugTreatments(drugs);
        LinkedList<DrugTreatmentAction> drugTreatmentActions = treatmentActionBuilder.getGeneralTreatmentActions(drugTreatments);

        Map<PatientState, Integer> resultOfAllTreatmentsMap = new HashMap<>();
        for (String patient: patients) {
            TreatmentResult patientGenerallTreatmentResult = new TreatmentResult(patient);
            for (DrugTreatmentAction treatmentAction: drugTreatmentActions) {
                TreatmentTask task = new TreatmentTask(patientGenerallTreatmentResult.getPatientState(), patientGenerallTreatmentResult.getAlreadyUsedDrugs());
                TreatmentResult patientDrugTreatmentResult = treatmentAction.treat(task);
                patientGenerallTreatmentResult.merge(patientDrugTreatmentResult);
            }

            resultOfAllTreatmentsMap
                    .compute(PatientState.getPatientState(patientGenerallTreatmentResult.getPatientState()),
                            (k, v) -> (v != null ? v : 0) + 1);
        }

        StringBuilder resultOfAllTreatments = new StringBuilder();
        for (PatientState patientState: PatientState.getOrderedValues()) {
            Integer numberOfPatients = resultOfAllTreatmentsMap.get(patientState);
            if (numberOfPatients != null) {
                resultOfAllTreatments
                        .append(patientState.getState())
                        .append(":")
                        .append(numberOfPatients);
            } else {
                resultOfAllTreatments
                        .append(patientState.getState())
                        .append(":0");
            }
            if (patientState.getId() < PatientState.values().length) {
                resultOfAllTreatments.append(",");
            }
        }

        return String.valueOf(resultOfAllTreatments);
    }

}
