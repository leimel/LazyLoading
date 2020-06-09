package co.com.magudel.usecase.mudanza;

import co.com.magudel.model.mudanza.EmptyFile;
import co.com.magudel.model.mudanza.dto.DayTravel;
import co.com.magudel.model.mudanza.dto.WorkReport;
import co.com.magudel.model.mudanza.dto.WorkResult;
import co.com.magudel.model.mudanza.service.WriterService;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public class FileWriter implements WriterService {

    @Override
    public WorkReport createFile(final WorkResult workResult){
        String fileContent = Optional.ofNullable(workResult)
                .map(WorkResult::getTravels)
                .orElse(new ArrayList<>())
                .stream()
                .map(DayTravel::toString)
                .collect(Collectors.joining("\n"));

        if (Objects.isNull(fileContent) || "".equals(fileContent.trim()))
            throw new EmptyFile("Work result is empty");

        return new WorkReport(fileContent, workResult.getUserIdentification());
    }
}
