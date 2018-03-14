package com.phantomapplications.www.projectechelon;

import java.util.ArrayList;

/**
 * Created by ayushboss on 3/10/18.
 */

public class Category {
    private String name;
    private String weight;
    private ArrayList<Assignment> assignments = new ArrayList<>();
    private String average;

    public Category(String title, ArrayList<Assignment> assignmentArrayList) {
        name = title;
        assignments = assignmentArrayList;
    }

    public String getAverage() {
        return average;
    }

    public ArrayList<Assignment> getAssignments() {
        return assignments;
    }

    public String getName() {
        return name;
    }

    public String getWeight() {
        return weight;
    }

    public void setAverage(String average) {
        this.average = average;
    }

    public void setAssignments(ArrayList<Assignment> assignments) {
        this.assignments = assignments;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }
}
