package co.com.magudel.orchestrator.mudanza;

import co.com.magudel.model.mudanza.dto.JobSpecification;
import co.com.magudel.model.mudanza.dto.WorkReport;
import co.com.magudel.model.mudanza.dto.WorkResult;
import co.com.magudel.model.mudanza.service.RelocationPerformerService;

public class RelocationPermormerStep extends Mudanza<JobSpecification, WorkResult> {

    private RelocationPerformerService relocationPerformerService;

    public RelocationPermormerStep(RelocationPerformerService relocationPerformerService) {
        this.relocationPerformerService = relocationPerformerService;
    }

    @Override
    public WorkReport execute(JobSpecification input) {
        return checkNext(relocationPerformerService.maximizeTrips(input));
    }
}
