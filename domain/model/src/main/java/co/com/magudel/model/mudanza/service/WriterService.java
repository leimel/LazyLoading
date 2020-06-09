package co.com.magudel.model.mudanza.service;

import co.com.magudel.model.mudanza.dto.WorkReport;
import co.com.magudel.model.mudanza.dto.WorkResult;

public interface WriterService {

    WorkReport createFile(final WorkResult workResult);
}
