package co.com.magudel.application;

import co.com.magudel.model.mudanza.dto.WorkInput;
import co.com.magudel.model.mudanza.dto.WorkReport;
import co.com.magudel.orchestrator.mudanza.Mudanza;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.core.io.buffer.DefaultDataBufferFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.nio.charset.StandardCharsets;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/file", produces = MediaType.APPLICATION_JSON_VALUE)
public class FileController {

    private Mudanza<WorkInput, WorkReport> mudanza;

    @Autowired
    public FileController(Mudanza<WorkInput, WorkReport> mudanza) {
        this.mudanza = mudanza;
    }

    @PostMapping
    public Mono<Void> upload(@RequestBody WorkInput workInput, ServerHttpResponse response) {

        WorkReport workReport = Optional.ofNullable(workInput)
                .map(w -> mudanza.execute(w))
                .orElse(new WorkReport());

        response.setStatusCode(HttpStatus.OK);
        response.getHeaders().set(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=report.txt");
        response.getHeaders().setContentType(MediaType.TEXT_PLAIN);

        DataBuffer dataBuffer = new DefaultDataBufferFactory().wrap(workReport.getContent().getBytes(StandardCharsets.UTF_8));

        return response.writeWith(Mono.just(dataBuffer));
    }
}
