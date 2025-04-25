package Justin.T.WorkoutTracker.Workout;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface WorkoutRepo extends ListCrudRepository<Workout, Integer>
{
    List<Workout> findAllByWeight(Integer weight);
}
