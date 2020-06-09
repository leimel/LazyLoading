package co.com.magudel.orchestrator.mudanza;

import co.com.magudel.model.mudanza.dto.WorkReport;
import co.com.magudel.model.mudanza.entity.TraceabilityEntity;
import co.com.magudel.model.mudanza.repository.TraceabilityRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Date;
import java.util.Optional;

public class PersistenceStep extends Mudanza<WorkReport, WorkReport> {
    private static final Logger LOGGER = LogManager.getLogger(PersistenceStep.class);

    private TraceabilityRepository traceabilityRepository;

    public PersistenceStep(TraceabilityRepository traceabilityRepository) {
        this.traceabilityRepository = traceabilityRepository;
    }

    @Override
    public WorkReport execute(WorkReport input) {
        TraceabilityEntity traceabilityEntity = new TraceabilityEntity(input.getIdentification(), new Date());
        Optional<TraceabilityEntity> entitySaved = traceabilityRepository.save(traceabilityEntity);

        if (entitySaved.isEmpty()) {
            String errorMsg = String.format("Traceability could not be saved, identification: %s", traceabilityEntity.getIdentification());
            LOGGER.error(errorMsg);
        }

        return checkNext(input);
    }
}
