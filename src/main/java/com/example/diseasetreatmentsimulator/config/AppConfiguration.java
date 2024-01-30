package com.example.diseasetreatmentsimulator.config;

import com.example.diseasetreatmentsimulator.service.CLITaskReader;
import com.example.diseasetreatmentsimulator.service.MedicineTreatmentTaskExecutor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfiguration {

    @Bean
    @ConditionalOnProperty(name = "enableCLIInput", havingValue = "true", matchIfMissing = false)
    public CLITaskReader cliTaskReader(MedicineTreatmentTaskExecutor treatmentTaskExecutor) {
        return new CLITaskReader(treatmentTaskExecutor);
    }

}
