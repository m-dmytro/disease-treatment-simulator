package com.example.diseasetreatmentsimulator.config;

import com.example.diseasetreatmentsimulator.service.CLITaskReaderImpl;
import com.example.diseasetreatmentsimulator.service.ScannerTaskReaderImpl;
import com.example.diseasetreatmentsimulator.service.ITaskReader;
import com.example.diseasetreatmentsimulator.service.MedicineTreatmentTaskExecutor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfiguration {

    @Bean
    @ConditionalOnProperty(name = "enableScannerInput", havingValue = "true", matchIfMissing = false)
    public ITaskReader scannerTaskReader(MedicineTreatmentTaskExecutor treatmentTaskExecutor) {
        return new ScannerTaskReaderImpl(treatmentTaskExecutor);
    }

    @Bean
    @ConditionalOnProperty(name = "enableCLIInput", havingValue = "true", matchIfMissing = false)
    public ITaskReader cliTaskReader(MedicineTreatmentTaskExecutor treatmentTaskExecutor) {
        return new CLITaskReaderImpl(treatmentTaskExecutor);
    }

}
