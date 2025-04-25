package Justin.T.WorkoutTracker.Workout;

import Justin.T.WorkoutTracker.Run.Run;
import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class JdbcClientWorkoutRepo
{
    private List<Workout> workouts = new ArrayList<Workout>();

    private static final Logger log = LoggerFactory.getLogger(JdbcClientWorkoutRepo.class);
    private final JdbcClient jdbcClient;

    public JdbcClientWorkoutRepo(JdbcClient jdbcClient)
    {
        this.jdbcClient = jdbcClient;
    }

    public List<Workout> findAll()
    {
        return jdbcClient
                .sql("select * from Workout")
                .query(Workout.class)
                .list();
    }

    public int count()
    {
        return findAll().size();
    }

    public void saveAll(List<Workout> workouts)
    {
        // add logic here
    }

    public Optional<Workout> findById(int id)
    {
        return jdbcClient
                .sql("SELECT id, name, started, completed, miles, location, FROM Workout WHERE id = :id")
                .param("id", id)
                .query(Workout.class)
                .optional();
    }

    public void create(Workout workout)
    {
        var updated = jdbcClient
                .sql("INSERT INTO Workout(id, name, sets, reps, weight) values(?, ?, ?, ?, ?)")
                .params(List.of(workout.id(), workout.name(), workout.sets(), workout.reps(), workout.weight()))
                .update();

        Assert.state(updated == 1, "failed to create " + workout.name());
    }

    public void update(Workout workout, Integer id)
    {
        var updated = jdbcClient
                .sql("update Workout set name = ?, sets = ?, reps = ?, weight = ?, where id = ?")
                .params(List.of(workout.name(), workout.sets(), workout.reps(), workout.weight(), workout.id()))
                .update();
    }

    public void delete(Integer id)
    {
        var updated = jdbcClient.sql("DELETE FROM Workout WHERE id = :id")
                .param("id", id)
                .update();

        Assert.state(updated == 1, "failed to delete workout " + id);
    }

    public List<Workout> findAllByWeight(Integer weight)
    {
        return jdbcClient
                .sql("SELECT * FROM workout WHERE weight = :weight")
                .param("weight", weight)
                .query(Workout.class)
                .list();
    }

    @PostConstruct
    private void init()
    {
    }
}
