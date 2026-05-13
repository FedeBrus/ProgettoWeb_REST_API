package org.example.trainingrest.Repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class ProgramsRepository {
    private final JdbcTemplate jdbc;

    @Autowired
    public ProgramsRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    @Transactional
    public void addUser(User u) {
        String sql = "INSERT INTO UserData VALUES (?, ?, ?, ?, ?, ?)";
        jdbc.update(sql,
                u.getUsername(),
                u.getName(),
                u.getSurname(),
                u.getDate_of_birth(),
                u.getEmail(),
                java.sql.Date.valueOf(u.getReg_date())
        );
    }

    @Transactional
    public int removeExpiredUsers() {
        String sql = "DELETE FROM USERS WHERE ENABLED = FALSE";
        return jdbc.update(sql);
    }

}
