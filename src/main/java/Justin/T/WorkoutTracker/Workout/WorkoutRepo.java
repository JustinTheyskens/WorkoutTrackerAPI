package Justin.T.WorkoutTracker.Workout;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class WorkoutRepo
{
    private List<Workout> workouts = new ArrayList<Workout>();

    List<Workout> findAll()
    {
        return workouts;
    }

    Optional<Workout> findById(int id)
    {
        return workouts.stream()
                .filter(r -> r.id() == id)
                .findFirst();
    }

    void create(Workout Workout)
    {
        workouts.add(Workout);
    }

    void update(Workout workout, Integer id)
    {
        Optional<Workout> existingWorkout = findById(id);

        if (existingWorkout.isPresent())
        {
            workouts.set(workouts.indexOf(existingWorkout.get()), workout);
        }
    }

    void delete(Integer id)
    {
        workouts.removeIf(r -> r.id() == id);
    }

    @PostConstruct
    private void init()
    {
        Workout workout1 = new Workout(1, "Bicep Curls", 20, 3, 12 );
        Workout workout2 = new Workout(2, "Seated Rear Delt Flies", 25, 3, 15);
        Workout workout3 = new Workout(3, "Shoulder Shrugs", 25, 3, 20);
        workouts.add(workout1);
        workouts.add(workout2);
        workouts.add(workout3);
    }
}
