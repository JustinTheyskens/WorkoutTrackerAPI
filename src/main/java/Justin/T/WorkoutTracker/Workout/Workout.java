package Justin.T.WorkoutTracker.Workout;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;

public record Workout
        (
                Integer id,
                @NotEmpty String name,
                @Positive Integer weight,
                @Positive Integer sets,
                @Positive Integer reps
        )
{
}
