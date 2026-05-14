package org.example.trainingrest.Service;

import org.example.trainingrest.pojo.Exercise;
import org.example.trainingrest.pojo.Program;
import org.springframework.stereotype.Service;

@Service
public class CountCaloriesService {

    public int count(Program program) {
        int total = 0;
        for (Exercise exercise : program.getExercises()) {
            total += exercise.getKcal();
        }

        return total;
    }
}
