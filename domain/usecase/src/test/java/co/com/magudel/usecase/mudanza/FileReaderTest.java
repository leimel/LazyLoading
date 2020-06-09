package co.com.magudel.usecase.mudanza;

import co.com.magudel.model.mudanza.EmptyFile;
import co.com.magudel.model.mudanza.dto.JobSpecification;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class FileReaderTest {

    private FileReader fileReader = new FileReader();

    @Test
    public void shouldConvertFContentFileToDto() throws IOException {

        JobSpecification jobSpecification = fileReader.convertFileToDTO(DataProvider.builWorkInput("\\src\\test\\resources\\input\\lazy_loading_example_input.txt"));

        Assert.assertNotNull(jobSpecification);
        Assert.assertEquals(5, jobSpecification.getDays().intValue());
        Assert.assertEquals(5, jobSpecification.getInfoJobDay().size());

        Assert.assertEquals("Case #1", jobSpecification.getInfoJobDay().get(0).getName());
        Assert.assertEquals(4, jobSpecification.getInfoJobDay().get(0).getElementsWeight().size());

        Assert.assertEquals("Case #2", jobSpecification.getInfoJobDay().get(1).getName());
        Assert.assertEquals(3, jobSpecification.getInfoJobDay().get(1).getElementsWeight().size());

        Assert.assertEquals("Case #3", jobSpecification.getInfoJobDay().get(2).getName());
        Assert.assertEquals(11, jobSpecification.getInfoJobDay().get(2).getElementsWeight().size());

        Assert.assertEquals("Case #4", jobSpecification.getInfoJobDay().get(3).getName());
        Assert.assertEquals(6, jobSpecification.getInfoJobDay().get(3).getElementsWeight().size());

        Assert.assertEquals("Case #5", jobSpecification.getInfoJobDay().get(4).getName());
        Assert.assertEquals(10, jobSpecification.getInfoJobDay().get(4).getElementsWeight().size());
    }

    @Test
    public void shouldReturnExceptionEmptyFile() {
        try {
            fileReader.convertFileToDTO(DataProvider.builEmptyWorkInput("\\src\\test\\resources\\input\\empty_file.txt"));
        } catch (Exception e) {
            Assert.assertTrue(e instanceof EmptyFile);
            EmptyFile emptyFile = (EmptyFile) e;
            Assert.assertEquals("Job specification is empty", emptyFile.getMessage());
        }
    }
}
