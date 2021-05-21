package org.launchcode.techjobs_oo;

import java.util.Objects;

public class Job {

    private int id;
    private static int nextId = 1;

    private String name;
    private Employer employer;
    private Location location;
    private PositionType positionType;
    private CoreCompetency coreCompetency;

    public Job() {
        id = nextId++;
    }

    public Job(String name, Employer employer, Location location, PositionType positionType,
               CoreCompetency coreCompetency) {
        this();
        this.name = name;
        this.employer = employer;
        this.location = location;
        this.positionType = positionType;
        this.coreCompetency = coreCompetency;
    }

    // Custom methods for equals(), hashCode(), and toString()

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Job job = (Job) o;
        return id == job.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    /* For the toString() method I decided to use %n for creating new lines
    * and consequently had to use printf in the main function. The reason for this
    * is that newline characters in Java are platform-dependent and could be either
    * \r\n, \r, or \n. Yes, I know it's ugly, but it should work across multiple OSs. */
    @Override
    public String toString() {
        if (name == null && employer == null && location == null
            && positionType == null && coreCompetency == null) {
            return "%nOOPS! This job does not seem to exist.%n";
        }

        String jobListing = "%n";
        jobListing += "ID: " + id + "%n";
        jobListing += "Name: " + (name == null || name.isEmpty() ? "Data not available" : name) + "%n";
        jobListing += "Employer: " + (employer == null || employer.getValue().isEmpty() ? "Data not available" : employer.getValue()) + "%n";
        jobListing += "Location: " + (location == null || location.getValue().isEmpty() ? "Data not available" : location.getValue()) + "%n";
        jobListing += "Position Type: " + (positionType == null || positionType.getValue().isEmpty() ? "Data not available" : positionType.getValue()) + "%n";
        jobListing += "Core Competency: " + (coreCompetency == null || coreCompetency.getValue().isEmpty() ? "Data not available" : coreCompetency.getValue()) + "%n";
        jobListing += "%n";

        return jobListing;
    }

    // Getters and setters for every field except nextID and a getter for id

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public PositionType getPositionType() {
        return positionType;
    }

    public void setPositionType(PositionType positionType) {
        this.positionType = positionType;
    }

    public CoreCompetency getCoreCompetency() {
        return coreCompetency;
    }

    public void setCoreCompetency(CoreCompetency coreCompetency) {
        this.coreCompetency = coreCompetency;
    }
}
