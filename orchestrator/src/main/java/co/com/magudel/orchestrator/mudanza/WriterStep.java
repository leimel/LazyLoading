package co.com.magudel.orchestrator.mudanza;

import co.com.magudel.model.mudanza.dto.WorkReport;
import co.com.magudel.model.mudanza.dto.WorkResult;
import co.com.magudel.model.mudanza.service.WriterService;

public class WriterStep extends Mudanza<WorkResult, WorkReport> {

    private WriterService writerService;

    public WriterStep(WriterService writerService) {
        this.writerService = writerService;
    }

    @Override
    public WorkReport execute(WorkResult input) {
        return checkNext(writerService.createFile(input));
    }
}
