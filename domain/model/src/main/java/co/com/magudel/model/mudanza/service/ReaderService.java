package co.com.magudel.model.mudanza.service;

import co.com.magudel.model.mudanza.dto.JobSpecification;
import co.com.magudel.model.mudanza.dto.WorkInput;

public interface ReaderService {

    JobSpecification convertFileToDTO(final WorkInput workInput);
}
