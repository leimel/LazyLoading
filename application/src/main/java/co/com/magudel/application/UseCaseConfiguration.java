package co.com.magudel.application;

import co.com.magudel.model.mudanza.repository.TraceabilityRepository;
import co.com.magudel.model.mudanza.service.ReaderService;
import co.com.magudel.model.mudanza.service.RelocationPerformerService;
import co.com.magudel.model.mudanza.service.WriterService;
import co.com.magudel.orchestrator.mudanza.*;
import co.com.magudel.usecase.mudanza.FileReader;
import co.com.magudel.usecase.mudanza.FileWriter;
import co.com.magudel.usecase.mudanza.RelocationPerformer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfiguration {

    @Bean
    public ReaderService readerService(){
        return new FileReader();
    }

    @Bean
    public RelocationPerformerService relocationPerformerService(){
        return new RelocationPerformer();
    }

    @Bean
    public WriterService writerService(){
        return new FileWriter();
    }


    @Bean
    public Mudanza mudanzaStep(final ReaderService readerService, final RelocationPerformerService relocationService, final WriterService writerService, final TraceabilityRepository traceabilityRepository) {
        ReaderStep readerStep = new ReaderStep(readerService);
        readerStep
                .linkWith(new RelocationPermormerStep(relocationService))
                .linkWith(new WriterStep(writerService))
                .linkWith(new PersistenceStep(traceabilityRepository));
        return readerStep;

    }
}
