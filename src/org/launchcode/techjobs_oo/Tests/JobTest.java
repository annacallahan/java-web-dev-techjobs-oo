package org.launchcode.techjobs_oo.Tests;

import org.junit.Before;
import org.junit.Test;
import org.launchcode.techjobs_oo.*;

import static org.junit.Assert.*;

public class JobTest {

    Job emptyJobOne;
    Job emptyJobTwo;
    Job equalJobOne;
    Job equalJobTwo;
    Job emptyFieldJob;

    @Before public void emptyJobs() {
        emptyJobOne = new Job();
        emptyJobTwo = new Job();
        equalJobOne = new Job("QA Engineer", new Employer("Apple"), new Location("California"), new PositionType("Quality control"), new CoreCompetency("Very Thorough"));
        equalJobTwo = new Job("QA Engineer", new Employer("Apple"), new Location("California"), new PositionType("Quality control"), new CoreCompetency("Very Thorough"));
        emptyFieldJob = new Job("Jr Developer", new Employer(), new Location("California"), new PositionType("Quality control"), new CoreCompetency("Very Thorough"));

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
        assertFalse(equalJobOne.equals(equalJobTwo));
    }

    @Test
    public void blankLineToString() {
        assertEquals('\n',equalJobOne.toString().charAt(0));
        assertEquals('\n', equalJobOne.toString().charAt(equalJobOne.toString().length()-1));
    }

    @Test
    public void fieldLabelToString() {
        assertTrue(equalJobOne.toString().contains("ID: "+equalJobOne.getId()));
        assertTrue(equalJobOne.toString().contains("Name: "+equalJobOne.getName()));
        assertTrue(equalJobOne.toString().contains("Employer: "+equalJobOne.getEmployer()));
        assertTrue(equalJobOne.toString().contains("Location: "+equalJobOne.getLocation()));
        assertTrue(equalJobOne.toString().contains("Position Type: "+equalJobOne.getPositionType()));
        assertTrue(equalJobOne.toString().contains("Core Competency: "+equalJobOne.getCoreCompetency()));

    }

    @Test
    public void blankFieldToString() {
        assertTrue(emptyFieldJob.toString().contains("Data not available"));
    }


}
