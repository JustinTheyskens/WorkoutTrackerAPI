package Justin.T.WorkoutTracker.Run;
import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.util.Assert;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class RunRepo
{
    private List<Run> runs = new ArrayList<Run>();

    private static final Logger log = LoggerFactory.getLogger(RunRepo.class);
    private final JdbcClient jdbcClient;

    public RunRepo(JdbcClient jdbcClient)
    {
        this.jdbcClient = jdbcClient;
    }

    List<Run> findAll()
    {
        return jdbcClient
                .sql("select * from Run")
                .query(Run.class)
                .list();
    }

    Optional<Run> findById(int id)
    {
        return jdbcClient
                .sql("SELECT id, name, started, completed, miles, location, FROM Run WHERE id = :id")
                .param("id", id)
                .query(Run.class)
                .optional();
    }

    void create(Run run)
    {
        var updated = jdbcClient
                .sql("INSERT INTO Run(id, name, started, completed, miles, location) values(?, ?, ?, ?, ?, ?)")
                .params(List.of(run.id(), run.name(), run.started(), run.completed(), run.miles(), run.location().toString()))
                .update();

        Assert.state(updated == 1, "failed to create " + run.name());
    }

    void update(Run run, Integer id)
    {
        var updated = jdbcClient
                .sql("update Run set name = ?, started = ?, completed = ?, miles = ?, location = ?, where id = ?")
                .params(List.of(run.name(), run.started(), run.completed(), run.miles(), run.location().toString(), id))
                .update();
    }

    void delete(Integer id)
    {
        var updated = jdbcClient.sql("DELETE FROM Run WHERE id = :id")
                .param("id", id)
                .update();

        Assert.state(updated == 1, "failed to delete run " + id);
    }

    @PostConstruct
    private void init()
    {
//        Run run1 = new Run(1, "Fist Run", LocalDateTime.now(), LocalDateTime.now().plus(1, ChronoUnit.HOURS), 5, Location.Outdoor);
//        Run run2 = new Run(2, "Second Run", LocalDateTime.now(), LocalDateTime.now().plus(2, ChronoUnit.HOURS), 10, Location.Outdoor);
//        Run run3 = new Run(3, "Third Run", LocalDateTime.now(), LocalDateTime.now().plus(1, ChronoUnit.HOURS), 7, Location.Indoor);
//        runs.add(run1);
//        runs.add(run2);
//        runs.add(run3);
    }
}
