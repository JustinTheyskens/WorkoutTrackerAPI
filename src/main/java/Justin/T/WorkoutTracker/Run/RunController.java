package Justin.T.WorkoutTracker.Run;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/runs")
public class RunController
{

    private final RunRepo Repo;

    public RunController(RunRepo repo)
    {
        Repo = repo;
    }

    @GetMapping("/home")
    String home()
    {
        return "Welcome, Runners!";
    }

    @GetMapping("/runs")
    List<Run> findAll()
    {
        return Repo.findAll();
    }

    @GetMapping("/{id}")
    Run findById(@PathVariable Integer id) throws RunNotFoundException
    {
        Optional<Run> run = Repo.findById(id);
        if (run.isEmpty())
        {
            throw new RunNotFoundException();
        }

        return run.get();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    void Create(@Valid @RequestBody Run run)
    {
        Repo.create(run);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    void update(@Valid @RequestBody Run run, @PathVariable Integer id)
    {
        Repo.update(run, id);
    }

    @DeleteMapping
    void delete(@PathVariable Integer id)
    {
        Repo.delete(id);
    }
}
