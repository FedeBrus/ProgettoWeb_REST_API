package org.example.trainingrest.Repositories;

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
            SELECT p.name, p.owner
            FROM Programs p
            WHERE p.is_default = TRUE;
        """;

        RowMapper<String[]> rm = (r, i) -> {
            return new String[] {r.getString(1), r.getString(2)};
        };

        List<String[]> defaultPrograms = jdbc.query(sql, rm);

        List<Program> result = new ArrayList<>();

        for (String[] dp : defaultPrograms) {
            String programName = dp[0];
            String programOwner = dp[1];

            sql = """
                SELECT e.name, e.sets, e.reps, e.kcal
                FROM Exercises e
                WHERE e.program_name = ? AND e.program_owner = ?;
            """;

            RowMapper<Exercise> rme = (r, i) -> {
                return new Exercise(
                        r.getString(1),
                        r.getInt(2),
                        r.getInt(3),
                        r.getInt(4)
                );
            };

            List<Exercise> programExercises = jdbc.query(sql, rme, programName, programOwner);

            Program toBeAdded = new Program(programName, true, programOwner);
            toBeAdded.setExercises(programExercises);
            result.add(toBeAdded);

            // DA MIGLIORARE
            // Fare una query con una join che sicuramente il dbms è più efficiente di noi
            // Utilizzare una mappa per inserire i vari exercises dentro lo stesso program
        }

        return result;
    }
}
