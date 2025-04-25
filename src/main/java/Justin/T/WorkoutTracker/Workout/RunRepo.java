package Justin.T.WorkoutTracker.Workout;

import Justin.T.WorkoutTracker.Run.Run;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface RunRepo extends ListCrudRepository<Run, Integer>
{
    List<Run> findAllByLocation(String location);
}
