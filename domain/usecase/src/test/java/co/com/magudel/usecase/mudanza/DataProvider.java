package co.com.magudel.usecase.mudanza;

import co.com.magudel.model.mudanza.dto.JobDay;
import co.com.magudel.model.mudanza.dto.JobSpecification;
import co.com.magudel.model.mudanza.dto.WorkInput;
import co.com.magudel.model.mudanza.dto.WorkResult;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Base64;
import java.util.List;

public class DataProvider {

    private DataProvider(){}

    public static JobSpecification buildJobSpecification() throws JsonProcessingException {
        String jsonString = "{\"days\":5,\"infoJobDay\":[{\"name\":\"Case #1\",\"elementsWeight\":[1,1,30,30]},{\"name\":\"Case #2\",\"elementsWeight\":[20,20,20]},{\"name\":\"Case #3\",\"elementsWeight\":[1,2,3,4,5,6,7,8,9,10,11]},{\"name\":\"Case #4\",\"elementsWeight\":[9,19,29,39,49,59]},{\"name\":\"Case #5\",\"elementsWeight\":[8,32,44,47,56,60,71,76,85,91]}]}";

        JobSpecification jobSpecification = new ObjectMapper().readValue(jsonString, JobSpecification.class);
        jobSpecification.setUserIdentification("123456789");
        return jobSpecification;
    }

    public static JobSpecification buildJobSpecificationOneDay3Travels() {
        JobSpecification jobSpecification = new JobSpecification();
        jobSpecification.setDays(1);
        JobDay jobDay = new JobDay();
        jobDay.setElementsWeight(List.of(100, 100, 100));
        jobDay.setName("Case #1");
        jobSpecification.setDaysSpecification(List.of(jobDay));
        jobSpecification.setUserIdentification("123456789");

        return jobSpecification;
    }

    public static WorkInput builWorkInput(String path) throws IOException {
        return new WorkInput(readFile(path), "1036951676");
    }

    public static WorkInput builEmptyWorkInput(String path) throws IOException {
        return new WorkInput(readFile(path), "1036951676");
    }

    public static WorkResult buildWorkResult() throws JsonProcessingException {
        String jsonString = "{\"travels\":[{\"name\":\"Case #1\",\"numTravels\":2},{\"name\":\"Case #2\",\"numTravels\":1},{\"name\":\"Case #3\",\"numTravels\":2},{\"name\":\"Case #4\",\"numTravels\":3},{\"name\":\"Case #5\",\"numTravels\":8}]}";

        WorkResult workResult = new ObjectMapper().readValue(jsonString, WorkResult.class);
        workResult.setUserIdentification("123456789");
        return workResult;
    }

    public static String readFile(String path) throws IOException {
        Path fullPath = Path.of(getPath(path));
        byte[] bytes = Files.readAllBytes(fullPath);
        return Base64.getEncoder().encodeToString(bytes);
    }

    private static String getPath(String resourceName){
        return System.getProperty("user.dir") + resourceName;
    }

}
