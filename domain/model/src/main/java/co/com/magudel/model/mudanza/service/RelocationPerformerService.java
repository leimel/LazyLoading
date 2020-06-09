package co.com.magudel.model.mudanza.service;

import co.com.magudel.model.mudanza.dto.JobSpecification;
import co.com.magudel.model.mudanza.dto.WorkResult;

public interface RelocationPerformerService {

    WorkResult maximizeTrips(JobSpecification jobSpecification);
}
