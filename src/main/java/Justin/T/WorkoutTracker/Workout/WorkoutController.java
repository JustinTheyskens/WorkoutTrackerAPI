package Justin.T.WorkoutTracker.Workout;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/workouts")
public class WorkoutController
{
    private final WorkoutRepo Repo;

    public WorkoutController(WorkoutRepo repo)
    {
        Repo = repo;
    }

    @GetMapping("/home")
    String home()
    {
        return "Welcome, to your workout!";
    }

    @GetMapping("/workouts")
    List<Workout> findAll()
    {
        return Repo.findAll();
    }

    @GetMapping("/{id}")
    Workout findById(@PathVariable Integer id) throws WorkoutNotFoundException
    {
        Optional<Workout> workout = Repo.findById(id);
        if (workout.isEmpty())
        {
            throw new WorkoutNotFoundException();
        }

        return workout.get();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    void Create(@Valid @RequestBody Workout workout)
    {
        Repo.create(workout);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    void update(@Valid @RequestBody Workout workout, @PathVariable Integer id)
    {
        Repo.update(workout, id);
    }

    @DeleteMapping
    void delete(@PathVariable Integer id)
    {
        Repo.delete(id);
    }
}
