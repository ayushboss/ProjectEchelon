package com.phantomapplications.www.projectechelon;

import java.util.Date;

/**
 * Created by ayushboss on 3/10/18.
 */

public class Assignment {
    String name;
    String assignmentGrade;
    String dateAssigned;
    String dateDue;
    String assignmentNote;
    String average;

    public String getName() {
        return name;
    }

    public String getDateAssigned() {
        return dateAssigned;
    }

    public String getDateDue() {
        return dateDue;
    }

    public String getAssignmentGrade() {
        return assignmentGrade;
    }

    public String getAssignmentNote() {
        return assignmentNote;
    }

    public String getAverage() {
        return average;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDateAssigned(String dateAssigned) {
        this.dateAssigned = dateAssigned;
    }

    public void setDateDue(String dateDue) {
        this.dateDue = dateDue;
    }

    public void setAssignmentGrade(String assignmentGrade) {
        this.assignmentGrade = assignmentGrade;
    }

    public void setAssignmentNote(String assignmentNote) {
        this.assignmentNote = assignmentNote;
    }

    public void setAverage(String average) {
        this.average = average;
    }
}
