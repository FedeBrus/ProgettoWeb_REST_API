package org.example.trainingrest.Controller;

import org.example.trainingrest.Repositories.ProgramsRepository;
import org.example.trainingrest.pojo.Program;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;
import java.util.List;

@RestController
public class ProgramsRestController {

    private final ProgramsRepository programsRepository;

    @Autowired
    public ProgramsRestController(ProgramsRepository programsRepository) {
        this.programsRepository = programsRepository;
    }

    @GetMapping("/default")
    public List<Program> defaultPrograms() {
        return programsRepository.getDefaults();
    }
}
