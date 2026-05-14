package org.example.trainingrest.Repository;

import org.example.trainingrest.pojo.Exercise;
import org.example.trainingrest.pojo.Program;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProgramsRepository {
    private final JdbcTemplate jdbc;

    @Autowired
    public ProgramsRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    @Transactional
    public List<Program> getDefaults() {
        String sql = """
            SELECT DISTINCT e.program_name
            FROM Exercises e
        """;

        RowMapper<String> rm = (r, i) -> {
            return r.getString(1);
        };

        List<String> defaultProgramNames = jdbc.query(sql, rm);

        List<Program> result = new ArrayList<>();

        for (String programName : defaultProgramNames) {

            sql = """
                SELECT e.name, e.sets, e.reps, e.kcal
                FROM Exercises e
                WHERE e.program_name = ?;
            """;

            RowMapper<Exercise> rme = (r, i) -> {
                return new Exercise(
                        r.getString(1),
                        r.getInt(2),
                        r.getInt(3),
                        r.getInt(4)
                );
            };

            List<Exercise> programExercises = jdbc.query(sql, rme, programName);

            result.add(new Program(programName, programExercises));

            // DA MIGLIORARE
            // Fare una query con una join che sicuramente il dbms è più efficiente di noi
            // Utilizzare una mappa per inserire i vari exercises dentro lo stesso program
        }

        return result;
    }

    public List<Exercise> getDetails(String defaultProgramName) {
        String sql = """
                SELECT e.name, e.sets, e.reps, e.kcal
                FROM Exercises e
                WHERE e.program_name = ?;
            """;

        RowMapper<Exercise> rme = (r, i) -> {
            return new Exercise(
                    r.getString(1),
                    r.getInt(2),
                    r.getInt(3),
                    r.getInt(4)
            );
        };

        List<Exercise> programExercises = jdbc.query(sql, rme, defaultProgramName);

        return programExercises;
    }
}
