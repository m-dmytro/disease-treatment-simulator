package com.example.diseasetreatmentsimulator.service;

import com.example.diseasetreatmentsimulator.mapper.DrugTreatmentMapper;
import com.example.diseasetreatmentsimulator.mapper.TreatmentActionBuilderMapper;
import com.example.diseasetreatmentsimulator.treatment.model.PatientState;
import com.example.diseasetreatmentsimulator.treatment.model.RequestedTask;
import com.example.diseasetreatmentsimulator.treatment.model.TreatmentResult;
import com.example.diseasetreatmentsimulator.treatment.model.TreatmentTask;
import com.example.diseasetreatmentsimulator.treatment.treatment.DrugTreatment;
import com.example.diseasetreatmentsimulator.treatment.treatmentAction.DrugTreatmentAction;
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

    public static final String UNSUPPORTED_PATIENT_TYPE_ERROR = "Wrong request: unsupported patient type. Possible patients: F,H,D,I,X";
    public static final String UNSUPPORTED_DRUG_TYPE_ERROR = "Wrong request: unsupported drug type. Possible drugs: As,An,I,P";

    @Autowired
    private DrugTreatmentMapper drugTreatmentMapper;
    @Autowired
    private TreatmentActionBuilderMapper treatmentActionBuilderMapper;

    public String runAllRequestedTreatments(List<String> patients, List<String> drugs) {
        RequestedTask requestedTask = extractAndValidateRequestedParameters(patients, drugs);
        if (requestedTask.error() != null) {
            return requestedTask.error();
        }
        Map<PatientState, Integer> resultOfAllTreatmentsMap = executeTreatmentsToEachPatient(requestedTask.patientStates(), requestedTask.drugTreatmentActions());
        StringBuilder resultOfAllTreatments = aggregateResultMapToString(resultOfAllTreatmentsMap);
        return String.valueOf(resultOfAllTreatments);
    }

    private RequestedTask extractAndValidateRequestedParameters(List<String> patients, List<String> drugs) {
        List<PatientState> patientStates;
        LinkedList<DrugTreatmentAction> drugTreatmentActions;
        LinkedList<DrugTreatment> drugTreatments;
        try {
            patientStates = patients.stream().map(PatientState::getPatientState).toList();
        } catch (UnsupportedOperationException uoe) {
            return new RequestedTask(UNSUPPORTED_PATIENT_TYPE_ERROR);
        }
        try {
            drugTreatments = drugTreatmentMapper.getDrugTreatments(drugs);
            drugTreatmentActions = treatmentActionBuilderMapper.getGeneralTreatmentActions(drugTreatments);
        } catch (UnsupportedOperationException uoe) {
            return new RequestedTask(UNSUPPORTED_DRUG_TYPE_ERROR);
        }
        return new RequestedTask(drugTreatmentActions, patientStates);
    }

    private static Map<PatientState, Integer> executeTreatmentsToEachPatient(List<PatientState> patientStates, LinkedList<DrugTreatmentAction> drugTreatmentActions) {
        Map<PatientState, Integer> resultOfAllTreatmentsMap = new HashMap<>();
        for (PatientState patient: patientStates) {
            TreatmentResult patientGenerallTreatmentResult = new TreatmentResult(patient);
            for (DrugTreatmentAction treatmentAction: drugTreatmentActions) {
                TreatmentTask task = new TreatmentTask(patientGenerallTreatmentResult.getPatientState(), patientGenerallTreatmentResult.getAlreadyUsedDrugs());
                TreatmentResult patientDrugTreatmentResult = treatmentAction.treat(task);
                patientGenerallTreatmentResult.merge(patientDrugTreatmentResult);
            }

            resultOfAllTreatmentsMap
                    .compute(patientGenerallTreatmentResult.getPatientState(),
                            (k, v) -> (v != null ? v : 0) + 1);
        }
        return resultOfAllTreatmentsMap;
    }

    private static StringBuilder aggregateResultMapToString(Map<PatientState, Integer> resultOfAllTreatmentsMap) {
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
        return resultOfAllTreatments;
    }

}
