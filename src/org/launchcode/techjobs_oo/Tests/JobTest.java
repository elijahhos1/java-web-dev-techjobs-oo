package org.launchcode.techjobs_oo.Tests;

import org.junit.Before;
import org.junit.Test;
import org.launchcode.techjobs_oo.*;

import static org.junit.Assert.*;

public class JobTest {

    @Test
    public void testSettingJobId() {
        Job jobOne = new Job();
        Job jobTwo = new Job();

        assertFalse(jobOne.getId() == jobTwo.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        Job job = new Job("Product tester", new Employer("ACME"),
                new Location("Desert"), new PositionType("Quality control"),
                new CoreCompetency("Persistence"));

        assertTrue(job instanceof Job);
        assertEquals("Product tester", job.getName());
        assertEquals("ACME", job.getEmployer().getValue());
        assertEquals("Desert", job.getLocation().getValue());
        assertEquals("Quality control", job.getPositionType().getValue());
        assertEquals("Persistence", job.getCoreCompetency().getValue());
    }

    @Test
    public void testJobsForEquality() {
        Job jobOne = new Job("Product tester", new Employer("ACME"),
                new Location("Desert"), new PositionType("Quality control"),
                new CoreCompetency("Persistence"));

        Job jobTwo = new Job("Product tester", new Employer("ACME"),
                new Location("Desert"), new PositionType("Quality control"),
                new CoreCompetency("Persistence"));


        assertFalse(jobOne.equals(jobTwo));
    }

    @Test
    public void testJobForProperToStringMethodOutput() {
        Job job = new Job("Product tester", new Employer("ACME"),
                new Location("Desert"), new PositionType("Quality control"),
                new CoreCompetency("Persistence"));

        // Testing if there are new lines before and after the output of toString().
        assertEquals("%n", job.toString().substring(0, 2));
        assertEquals("%n", job.toString().substring(job.toString().length() - 2));

        // Testing if the output of toString() matches the expected string literal.
        assertEquals("%nID: 1%nName: Product tester%nEmployer: ACME%nLocation: Desert%n" +
                "Position Type: Quality control%nCore Competency: Persistence%n%n", job.toString());


        Job newJob = new Job("", new Employer("ACME"),
                new Location("Desert"), new PositionType("Quality control"),
                new CoreCompetency("Persistence"));

        // Testing if a field left out in the Job object declaration adds
        // "Data not available" to the output of toString().
        assertTrue(newJob.toString().contains("Data not available"));


        Job newNewJob = new Job();

        // Testing if a job without initialized fields (except for id) matches
        // "OOPS! This job does not seem to exist." when toString() is called.
        assertTrue(newNewJob.toString().contains("OOPS! This job does not seem to exist."));
    }
}
