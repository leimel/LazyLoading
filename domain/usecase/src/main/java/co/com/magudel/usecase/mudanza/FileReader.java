package co.com.magudel.usecase.mudanza;

import co.com.magudel.model.mudanza.EmptyFile;
import co.com.magudel.model.mudanza.dto.JobDay;
import co.com.magudel.model.mudanza.dto.JobSpecification;
import co.com.magudel.model.mudanza.dto.WorkInput;
import co.com.magudel.model.mudanza.service.ReaderService;

import java.util.Base64;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class FileReader implements ReaderService {

    @Override
    public JobSpecification convertFileToDTO(final WorkInput workInput) {
        List<String> lines = getFileLines(workInput);

        List<JobDay> infoJobDay = new LinkedList<>();

        int day = 1;
        for(int it = 1; it < lines.size(); it++){
            Integer elementsByDay = Integer.valueOf(lines.get(it));
            List<Integer> elements =  getElements(it+1, it+elementsByDay, lines);
            infoJobDay.add(new JobDay("Case #" + day++, elements));
            it+= elementsByDay;
        }

        Integer numDays = Integer.valueOf(lines.get(0));
        return new JobSpecification(workInput.getIdentification(), numDays, infoJobDay);
    }

    private List<String> getFileLines(WorkInput workInput) {
        List<String> lines = Optional.ofNullable(workInput)
                .map(WorkInput::getContentBase64)
                .map(content -> Base64.getDecoder().decode(content))
                .map(String::new)
                .orElse("")
                .lines()
                .collect(Collectors.toList());

        if (lines.isEmpty())
            throw new EmptyFile("Job specification is empty");

        return lines;
    }

    private List<Integer> getElements(int fromIndex, int toIndex, List<String> properties) {
        return properties.subList(fromIndex, toIndex+1)
                .stream()
                .map(Integer::valueOf)
                .sorted()
                .collect(Collectors.toList())
                ;
    }

}
