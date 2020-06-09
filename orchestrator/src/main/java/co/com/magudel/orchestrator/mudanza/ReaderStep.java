package co.com.magudel.orchestrator.mudanza;

import co.com.magudel.model.mudanza.dto.JobSpecification;
import co.com.magudel.model.mudanza.dto.WorkInput;
import co.com.magudel.model.mudanza.dto.WorkReport;
import co.com.magudel.model.mudanza.service.ReaderService;

public class ReaderStep extends Mudanza<WorkInput, JobSpecification> {

    private ReaderService readerService;

    public ReaderStep(ReaderService readerService) {
        this.readerService = readerService;
    }

    @Override
    public WorkReport execute(WorkInput input) {
        return checkNext(readerService.convertFileToDTO(input));
    }
}
