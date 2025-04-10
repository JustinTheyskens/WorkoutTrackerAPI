package Justin.T.WorkoutTracker.Run;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;

import java.time.LocalDateTime;

public record Run
        (
            @Id Integer id,
            @NotEmpty String name,
            LocalDateTime started,
            LocalDateTime completed,
            @Positive Integer miles,
            Location location,
            @Version
            Integer version
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
