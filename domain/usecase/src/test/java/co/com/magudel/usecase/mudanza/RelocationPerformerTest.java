package co.com.magudel.usecase.mudanza;

import co.com.magudel.model.mudanza.dto.JobDay;
import co.com.magudel.model.mudanza.dto.JobSpecification;
import co.com.magudel.model.mudanza.dto.WorkResult;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.List;

public class RelocationPerformerTest {

    private RelocationPerformer relocationPerformer = new RelocationPerformer();

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void shouldCalculateMaxTravels() throws JsonProcessingException {

        WorkResult workResult = relocationPerformer.maximizeTrips(DataProvider.buildJobSpecification());

        Assert.assertNotNull(workResult);
        Assert.assertEquals(5, workResult.getTravels().size());

        Assert.assertEquals(2, workResult.getTravels().get(0).getNumTravels().intValue());
        Assert.assertEquals("Case #1", workResult.getTravels().get(0).getName());
        Assert.assertEquals("Case #1: 2", workResult.getTravels().get(0).toString());

        Assert.assertEquals(1, workResult.getTravels().get(1).getNumTravels().intValue());
        Assert.assertEquals("Case #2", workResult.getTravels().get(1).getName());
        Assert.assertEquals("Case #2: 1", workResult.getTravels().get(1).toString());

        Assert.assertEquals(2, workResult.getTravels().get(2).getNumTravels().intValue());
        Assert.assertEquals("Case #3", workResult.getTravels().get(2).getName());
        Assert.assertEquals("Case #3: 2", workResult.getTravels().get(2).toString());

        Assert.assertEquals(3, workResult.getTravels().get(3).getNumTravels().intValue());
        Assert.assertEquals("Case #4", workResult.getTravels().get(3).getName());
        Assert.assertEquals("Case #4: 3", workResult.getTravels().get(3).toString());

        Assert.assertEquals(8, workResult.getTravels().get(4).getNumTravels().intValue());
        Assert.assertEquals("Case #5", workResult.getTravels().get(4).getName());
        Assert.assertEquals("Case #5: 8", workResult.getTravels().get(4).toString());
    }

    @Test
    public void shouldCalculate3Travels() {
        WorkResult workResult = relocationPerformer.maximizeTrips(DataProvider.buildJobSpecificationOneDay3Travels());

        Assert.assertNotNull(workResult);
        Assert.assertEquals(1, workResult.getTravels().size());

        Assert.assertEquals(3, workResult.getTravels().get(0).getNumTravels().intValue());
        Assert.assertEquals("Case #1", workResult.getTravels().get(0).getName());
        Assert.assertEquals("Case #1: 3", workResult.getTravels().get(0).toString());
    }

    @Test
    public void shouldThrowExcepcion() {
        expectedException.expect(NullPointerException.class);
        expectedException.expectMessage("The userIdentification is required");

        JobSpecification jobSpecification = new JobSpecification();
        jobSpecification.setDays(1);
        jobSpecification.setDaysSpecification(List.of(new JobDay()));

        relocationPerformer.maximizeTrips(jobSpecification);

    }

}
