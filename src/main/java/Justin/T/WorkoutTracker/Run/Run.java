package Justin.T.WorkoutTracker.Run;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;

import java.time.LocalDateTime;

public record Run
        (
            Integer id,
            @NotEmpty String name,
            LocalDateTime started,
            LocalDateTime completed,
            @Positive Integer miles,
            Location location
        )
{
        public Run
        {
                if (!completed.isAfter(started))
                {
                        throw new IllegalArgumentException("completed time must be after started time.");
                }
        }
}
