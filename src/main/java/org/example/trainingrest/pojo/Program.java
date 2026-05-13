package org.example.trainingrest.pojo;

import org.example.trainingrest.pojo.Exercise;

import java.util.ArrayList;
import java.util.List;

public class Program {
    private String name;
    private boolean isDefault;
    private String owner;
    private List<Exercise> exercises;

    public Program(String name, boolean isDefault, String owner) {
        this.name = name;
        this.isDefault = isDefault;
        this.owner = owner;
        this.exercises = new ArrayList<>();
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public boolean isDefault() { return isDefault; }
    public void setDefault(boolean isDefault) { this.isDefault = isDefault; }

    public String getOwner() { return owner; }
    public void setOwner(String owner) { this.owner = owner; }

    public List<Exercise> getExercises() { return exercises; }
    public void setExercises(List<Exercise> exercises) { this.exercises = exercises; }

    public void addExercise(Exercise exercise) {
        this.exercises.add(exercise);
    }
}