package org.launchcode.techjobs_oo.Tests;

import org.junit.Before;
import org.junit.Test;
import org.launchcode.techjobs_oo.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class JobTest {
    Job test_job;
    Job test_job2;
    Job test_job3;
    Job test_job4;
    @Before
    public void createNewJob() {
        test_job = new Job();
        test_job2 = new Job();
        test_job3 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        test_job4 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
    }

    @Test
    public void testSettingJobId() {
        assertFalse(test_job.getId() == test_job2.getId());
        assertEquals(test_job.getId() + 1, test_job2.getId());
    }
    @Test
    public void testJobConstructorSetsAllFields() {
        assertEquals("Product tester", test_job3.getName());
        assertEquals("ACME", test_job3.getEmployer().getValue());
        assertEquals("Desert", test_job3.getLocation().getValue());
        assertEquals("Quality control", test_job3.getPositionType().getValue());
        assertEquals("Persistence", test_job3.getCoreCompetency().getValue());

    }
    @Test
    public void testJobsForEquality() {
        assertFalse(test_job3.getId() == test_job4.getId());
    }
    @Test
    public void testToStringEmpty() {
        assertEquals('\n', test_job4.toString().charAt(0));
        assertEquals('\n', test_job4.toString().charAt(test_job4.toString().length() -1));
    }
    @Test
    public void testToStringLabels() {
        assertEquals(
                "\n" +
                "ID: " + test_job4.getId() + "\n" +
                "Name: " + test_job4.getName() + "\n" +
                "Employer: " + test_job4.getEmployer().getValue() + "\n" +
                "Location: " + test_job4.getLocation().getValue() + "\n" +
                "Position Type: " + test_job4.getPositionType().getValue() + "\n" +
                "Core Competency: " + test_job4.getCoreCompetency().getValue() + "\n" +
                "\n", test_job4.toString());
    }

}
