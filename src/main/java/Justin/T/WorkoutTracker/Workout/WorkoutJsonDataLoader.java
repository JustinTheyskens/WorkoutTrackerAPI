package Justin.T.WorkoutTracker.Workout;

import Justin.T.WorkoutTracker.Workout.JdbcClientWorkoutRepo;
import Justin.T.WorkoutTracker.Workout.Workouts;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.asm.TypeReference;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;

@Component
public class WorkoutJsonDataLoader implements CommandLineRunner
{
    private static final Logger log = LoggerFactory.getLogger(WorkoutJsonDataLoader.class);
    private final JdbcClientWorkoutRepo repo;
    private final ObjectMapper mapper;

    public WorkoutJsonDataLoader(JdbcClientWorkoutRepo repo, ObjectMapper mapper)
    {
        this.repo = repo;
        this.mapper = mapper;
    }

    @Override
    public void run(String... args) throws Exception
    {
        if (repo.count() == 0)
        {
            try(InputStream inputStream = TypeReference.class.getResourceAsStream("/run.json"))
            {
                Workouts allWorkouts = mapper.readValue(inputStream, Workouts.class);
                log.info("reading {} workouts from JSON data and saving it to DB.", allWorkouts.workouts().size());
                repo.saveAll(allWorkouts.workouts());
            }
            catch(IOException e)
            {
                throw new RuntimeException("Failed to read JSON data.", e);
            }

        }
        else
        {
            log.info("Not loading workouts from JSON because the collection contains data.");
        }
    }
}
