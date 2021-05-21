package org.launchcode.techjobs_oo.Tests;

import org.junit.Test;
import org.launchcode.techjobs_oo.*;

import static org.junit.Assert.*;

public class JobTest {

    @Test
    public void testSettingJobId() {
        Job jobOne = new Job();
        Job jobTwo = new Job();

        assertFalse(jobOne.getId() == jobTwo.getId());

        assertTrue((jobTwo.getId() - jobOne.getId()) == 1);
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
    }

    @Test
    public void testIfJobToStringMethodReturnsJobDoesNotExistWithEmptyConstructor() {
        Job job = new Job();

        assertTrue(job.toString().contains("OOPS! This job does not seem to exist."));
    }

    @Test
    public void testIfJobToStringMethodAddsDataNotAvailableToField() {
        Job job = new Job("", new Employer("ACME"),
                new Location("Desert"), new PositionType("Quality control"),
                new CoreCompetency("Persistence"));

        assertTrue(job.toString().contains("Data not available"));
    }

    @Test
    public void testJobToStringMethodForEqualityToExpectedString() {
        Job job = new Job("Product tester", new Employer("ACME"),
                new Location("Desert"), new PositionType("Quality control"),
                new CoreCompetency("Persistence"));

        assertEquals("%nID: 9%nName: Product tester%nEmployer: ACME%nLocation: Desert%n" +
                "Position Type: Quality control%nCore Competency: Persistence%n%n", job.toString());
    }
}
