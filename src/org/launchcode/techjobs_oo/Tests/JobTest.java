package org.launchcode.techjobs_oo.Tests;

import org.junit.Before;
import org.junit.Test;
import org.launchcode.techjobs_oo.*;

import static org.junit.Assert.*;

public class JobTest {

    Job emptyJobOne;
    Job emptyJobTwo;

    @Before public void emptyJobs() {
        emptyJobOne = new Job();
        emptyJobTwo = new Job();
    }

    @Test
    public void testSettingJobId() {
        assertEquals(emptyJobTwo.getId(), emptyJobOne.getId()+1);
    }

    @Test
    public void testJobContructorSetsAllFields(){
        Job newJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertEquals(newJob.getName(),"Product tester");

        assertTrue(newJob.getEmployer() instanceof Employer);
        assertEquals(newJob.getEmployer().getValue(), "ACME");

        assertTrue(newJob.getLocation() instanceof Location);
        assertEquals(newJob.getLocation().getValue(), "Desert");

        assertTrue(newJob.getPositionType() instanceof PositionType);
        assertEquals(newJob.getPositionType().getValue(), "Quality control");

        assertTrue(newJob.getCoreCompetency() instanceof CoreCompetency);
        assertEquals(newJob.getCoreCompetency().getValue(), "Persistence");
    }

    @Test
    public void testJobsForEquality() {
        Job equalJobOne = new Job("QA Engineer", new Employer("Apple"), new Location("California"), new PositionType("Quality control"), new CoreCompetency("Very Thorough"));
        Job equalJobTwo = new Job("QA Engineer", new Employer("Apple"), new Location("California"), new PositionType("Quality control"), new CoreCompetency("Very Thorough"));

        assertFalse(equalJobOne.equals(equalJobTwo));
    }


}
