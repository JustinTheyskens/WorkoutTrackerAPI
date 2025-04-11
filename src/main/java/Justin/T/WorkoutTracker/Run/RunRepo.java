package Justin.T.WorkoutTracker.Run;
import java.util.List;
import org.springframework.data.repository.ListCrudRepository;
public interface RunRepo extends ListCrudRepository<Run, Integer>
{
    List<Run> findAllByLocation(String location);
}
