package co.com.magudel.application;

import co.com.magudel.model.mudanza.repository.TraceabilityRepository;
import co.com.magudel.model.mudanza.service.ReaderService;
import co.com.magudel.model.mudanza.service.RelocationPerformerService;
import co.com.magudel.model.mudanza.service.WriterService;
import co.com.magudel.orchestrator.mudanza.Mudanza;
import co.com.magudel.usecase.mudanza.FileReader;
import co.com.magudel.usecase.mudanza.FileWriter;
import co.com.magudel.usecase.mudanza.RelocationPerformer;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class UseCaseConfigurationTest {

    @InjectMocks
    UseCaseConfiguration useCaseConfiguration;

    @Mock
    private TraceabilityRepository traceabilityRepository;

    @Test
    public void shouldInitializeBeans(){
        ReaderService readerService = useCaseConfiguration.readerService();
        RelocationPerformerService relocationPerformerService = useCaseConfiguration.relocationPerformerService();
        WriterService writerService = useCaseConfiguration.writerService();
        Mudanza mudanza = useCaseConfiguration.mudanzaStep(readerService, relocationPerformerService, writerService, traceabilityRepository);

        Assert.assertNotNull(readerService);
        Assert.assertTrue(readerService instanceof FileReader);
        Assert.assertNotNull(relocationPerformerService);
        Assert.assertTrue(relocationPerformerService instanceof RelocationPerformer);
        Assert.assertNotNull(writerService);
        Assert.assertTrue(writerService instanceof FileWriter);
        Assert.assertNotNull(mudanza);
    }
}
