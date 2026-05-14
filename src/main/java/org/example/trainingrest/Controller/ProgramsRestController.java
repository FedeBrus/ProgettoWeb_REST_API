package org.example.trainingrest.Controller;

import org.example.trainingrest.Repository.ProgramsRepository;
import org.example.trainingrest.Service.CountCaloriesService;
import org.example.trainingrest.pojo.Program;
import org.example.trainingrest.pojo.Exercise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProgramsRestController {

    private final ProgramsRepository programsRepository;
    private final CountCaloriesService countCaloriesService;

    @Autowired
    public ProgramsRestController(ProgramsRepository programsRepository, CountCaloriesService countCaloriesService) {
        this.programsRepository = programsRepository;
        this.countCaloriesService = countCaloriesService;
    }

    @GetMapping("/default")
    public List<Program> defaultPrograms() {
        return programsRepository.getDefaults();
    }

    @GetMapping("/default/{defaultProgramName}")
    public List<Exercise> detailsOfDefaultProgram(@PathVariable String defaultProgramName) {
        return programsRepository.getDetails(defaultProgramName);
    }

    @PostMapping("/calories")
    public int calories(@RequestBody Program program) {
        return countCaloriesService.count(program);
    }
}
