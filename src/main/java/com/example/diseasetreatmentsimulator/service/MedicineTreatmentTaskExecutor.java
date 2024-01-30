package com.example.diseasetreatmentsimulator.service;

import com.example.diseasetreatmentsimulator.mapper.DrugTreatmentMapper;
import com.example.diseasetreatmentsimulator.model.PatientState;
import com.example.diseasetreatmentsimulator.model.RequestedTask;
import com.example.diseasetreatmentsimulator.model.TreatmentResult;
import com.example.diseasetreatmentsimulator.model.TreatmentTask;
import com.example.diseasetreatmentsimulator.model.builder.TreatmentActionBuilder;
import com.example.diseasetreatmentsimulator.model.treatment.DrugTreatment;
import com.example.diseasetreatmentsimulator.model.treatmentAction.DrugTreatmentAction;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class MedicineTreatmentTaskExecutor {
    private static final Logger LOG = LoggerFactory.getLogger(MedicineTreatmentTaskExecutor.class);

    @Autowired
    private DrugTreatmentMapper drugTreatmentMapper;
    @Autowired
    private TreatmentActionBuilder treatmentActionBuilder;

    public String runAllRequestedTreatments(List<String> patients, List<String> drugs) {
        RequestedTask requestedTask = exctratAndValidateRequestedParameters(patients, drugs);
        if (requestedTask == null) {
            return StringUtils.EMPTY;
        }
        Map<PatientState, Integer> resultOfAllTreatmentsMap = executeTreatmentsToEachPatient(requestedTask.patientStates(), requestedTask.drugTreatmentActions());
        StringBuilder resultOfAllTreatments = aggregateResultMapToSting(resultOfAllTreatmentsMap);
        return String.valueOf(resultOfAllTreatments);
    }

    private RequestedTask exctratAndValidateRequestedParameters(List<String> patients, List<String> drugs) {
        List<PatientState> patientStates;
        LinkedList<DrugTreatmentAction> drugTreatmentActions;
        LinkedList<DrugTreatment> drugTreatments;
        try {
            patientStates = patients.stream().map(PatientState::getPatientState).toList();
        } catch (UnsupportedOperationException uoe) {
            LOG.error("Wrong request: unsupported patient type. Possible patients: F,H,D,I,X");
            return null;
        }
        try {
            drugTreatments = drugTreatmentMapper.getDrugTreatments(drugs);
            drugTreatmentActions = treatmentActionBuilder.getGeneralTreatmentActions(drugTreatments);
        } catch (UnsupportedOperationException uoe) {
            LOG.error("Wrong request: unsupported drug type. Possible drugs: As,An,I,P");
            return null;
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

    private static StringBuilder aggregateResultMapToSting(Map<PatientState, Integer> resultOfAllTreatmentsMap) {
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
