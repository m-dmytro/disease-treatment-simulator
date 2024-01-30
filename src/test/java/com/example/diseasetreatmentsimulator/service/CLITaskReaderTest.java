package com.example.diseasetreatmentsimulator.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class CLITaskReaderTest {

    @Mock
    private MedicineTreatmentTaskExecutor treatmentTaskExecutor;

    CLITaskReader sut;

    @BeforeEach
    void warmUp() {
        sut = new CLITaskReader(treatmentTaskExecutor);
    }

    @Test
    void processRequestedTreatment_1timeCallTaskExecutor_when1ArgWasSpecified() {
        //Given
        String[] requestedArgs = {"D,D"};

        //When
        sut.processRequestedTreatment(requestedArgs);

        //Then
        verify(treatmentTaskExecutor, times(1)).runAllRequestedTreatments(anyList(), anyList());
    }

    @Test
    void processRequestedTreatment_1timeCallTaskExecutor_when2ArgsWereSpecified() {
        //Given
        String[] requestedArgs = {"D,D", "As,I"};

        //When
        sut.processRequestedTreatment(requestedArgs);

        //Then
        verify(treatmentTaskExecutor, times(1)).runAllRequestedTreatments(anyList(), anyList());
    }

    @Test
    void processRequestedTreatment_notCallTaskExecutor_whenMoreThan2ArgsWereSpecified() {
        //Given
        String[] requestedArgs = {"D,D", "As,I", "P"};

        //When
        sut.processRequestedTreatment(requestedArgs);

        //Then
        verify(treatmentTaskExecutor, times(0)).runAllRequestedTreatments(anyList(), anyList());
    }

}
