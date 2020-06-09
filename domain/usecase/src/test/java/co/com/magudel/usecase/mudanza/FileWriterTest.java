package co.com.magudel.usecase.mudanza;

import co.com.magudel.model.mudanza.EmptyFile;
import co.com.magudel.model.mudanza.dto.WorkReport;
import co.com.magudel.model.mudanza.dto.WorkResult;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;

public class FileWriterTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    FileWriter fileWriter = new FileWriter();

    @Test
    public void shouldConvertDtoToBase64File() throws JsonProcessingException {
        WorkResult workResult = DataProvider.buildWorkResult();

        WorkReport workReportOutput = fileWriter.createFile(workResult);

        Assert.assertNotNull(workReportOutput);
        Assert.assertEquals("Case #1: 2\n" +
                "Case #2: 1\n" +
                "Case #3: 2\n" +
                "Case #4: 3\n" +
                "Case #5: 8", workReportOutput.getContent());
        Assert.assertEquals("123456789", workReportOutput.getIdentification());
    }

    @Test
    public void shouldThrowEmptyFile() {
        expectedException.expect(EmptyFile.class);
        expectedException.expectMessage("Work result is empty");

        fileWriter.createFile(new WorkResult("", new ArrayList<>()));
    }
}
