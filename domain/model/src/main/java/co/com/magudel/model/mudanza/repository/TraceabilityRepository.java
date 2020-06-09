package co.com.magudel.model.mudanza.repository;

import co.com.magudel.model.mudanza.entity.TraceabilityEntity;

import java.util.Optional;

public interface TraceabilityRepository {

    Optional<TraceabilityEntity> save(TraceabilityEntity traceability);
}
