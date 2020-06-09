package co.com.magudel.application;

import co.com.magudel.model.mudanza.dto.WorkInput;
import co.com.magudel.model.mudanza.dto.WorkReport;
import co.com.magudel.orchestrator.mudanza.Mudanza;
import org.apache.commons.io.IOUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.reactive.ServerHttpResponse;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class FileControllerTest {

    @InjectMocks
    private FileController fileController;

    @Mock
    private ServerHttpResponse httpResponse;
    @Mock
    private HttpHeaders httpHeaders;
    @Mock
    private Mudanza mudanza;

    @Captor
    ArgumentCaptor<Mono<DataBuffer>> argumentCaptor;

    @Before
    public void setUp(){
        when(httpResponse.getHeaders()).thenReturn(httpHeaders);
        when(httpResponse.writeWith(any())).thenReturn(Mono.empty());
    }

    @Test
    public void shouldExecuteMudanza() throws IOException {
        WorkInput workInput = new WorkInput("", "");
        when(httpResponse.writeWith(argumentCaptor.capture())).thenReturn(Mono.empty());

        when(mudanza.execute(workInput)).thenReturn(new WorkReport("Case #1: 2", ""));
        Mono<Void> response = fileController.upload(workInput, httpResponse);

        StepVerifier.create(response)
                .expectSubscription()
                .expectComplete()
                .verify();

        DataBuffer dataBuffer = argumentCaptor.getValue().block();

        verify(mudanza).execute(workInput);
        verify(httpResponse).writeWith(any());

        Assert.assertEquals("Case #1: 2", IOUtils.toString(dataBuffer.asInputStream(), StandardCharsets.UTF_8.name()));
    }


}
