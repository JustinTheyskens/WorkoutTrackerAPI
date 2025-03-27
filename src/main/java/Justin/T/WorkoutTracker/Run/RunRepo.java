package Justin.T.WorkoutTracker.Run;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class RunRepo
{
    private List<Run> runs = new ArrayList<Run>();



//    List<Run> findAll()
//    {
//        return runs;
//    }
//
//    Optional<Run> findById(int id)
//    {
//        return runs.stream()
//                .filter(r -> r.id() == id)
//                .findFirst();
//    }
//
//    void create(Run run)
//    {
//        runs.add(run);
//    }
//
//    void update(Run run, Integer id)
//    {
//        Optional<Run> existingRun = findById(id);
//
//        if (existingRun.isPresent())
//        {
//            runs.set(runs.indexOf(existingRun.get()), run);
//        }
//    }
//
//    void delete(Integer id)
//    {
//        runs.removeIf(r -> r.id() == id);
//    }
//
//    @PostConstruct
//    private void init()
//    {
//        Run run1 = new Run(1, "Fist Run", LocalDateTime.now(), LocalDateTime.now().plus(1, ChronoUnit.HOURS), 5, Location.Outdoor);
//        Run run2 = new Run(2, "Second Run", LocalDateTime.now(), LocalDateTime.now().plus(2, ChronoUnit.HOURS), 10, Location.Outdoor);
//        Run run3 = new Run(3, "Third Run", LocalDateTime.now(), LocalDateTime.now().plus(1, ChronoUnit.HOURS), 7, Location.Indoor);
//        runs.add(run1);
//        runs.add(run2);
//        runs.add(run3);
//    }
}
