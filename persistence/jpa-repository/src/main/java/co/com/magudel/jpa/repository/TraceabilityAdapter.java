package co.com.magudel.jpa.repository;

import co.com.magudel.jpa.entity.Traceability;
import co.com.magudel.model.mudanza.entity.TraceabilityEntity;
import co.com.magudel.model.mudanza.repository.TraceabilityRepository;
import org.modelmapper.ModelMapper;

import java.util.Optional;

public class TraceabilityAdapter implements TraceabilityRepository {

    private final TraceabilityRepositoryJpa repository;
    private final ModelMapper modelMapper;

    public TraceabilityAdapter(final TraceabilityRepositoryJpa repository, final ModelMapper modelMapper){
        this.repository = repository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Optional<TraceabilityEntity> save(TraceabilityEntity traceability){
        return Optional.ofNullable(traceability)
                .map(t -> modelMapper.map(t, Traceability.class))
                .map(repository::save)
                .map(t -> modelMapper.map(t, TraceabilityEntity.class));
    }

}
