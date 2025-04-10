package Justin.T.WorkoutTracker;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application
{

	private static final Logger log = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args)
	{
		SpringApplication.run(Application.class, args);
	}

//	@Bean
//	CommandLineRunner runner(RunRepo repo)
//	{
//		return args ->
//		{
//			Run run1 = new Run(1, "Fist Run", LocalDateTime.now(), LocalDateTime.now().plus(1, ChronoUnit.HOURS), 5, Location.Outdoor);
//			repo.create(run1);
//		};
//	}
}
