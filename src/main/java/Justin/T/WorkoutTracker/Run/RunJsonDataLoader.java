package Justin.T.WorkoutTracker.Run;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.asm.TypeReference;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.JdbcTemplate;

import java.io.IOException;
import java.io.InputStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class RunJsonDataLoader implements CommandLineRunner
{
    private static final Logger log = LoggerFactory.getLogger(RunJsonDataLoader.class);
    private final JdbcClientRunRepo repo;
    private final ObjectMapper mapper;

    public RunJsonDataLoader(JdbcClientRunRepo repo, ObjectMapper mapper)
    {
        this.repo = repo;
        this.mapper = mapper;
    }

    @Override
    public void run(String... args) throws Exception
    {
        if (repo.count() == 0)
        {
            try(InputStream inputStream = TypeReference.class.getResourceAsStream("/run.json"))
            {
                Runs allRuns = mapper.readValue(inputStream, Runs.class);
                log.info("reading {} runs from JSON data and saving it to DB.", allRuns.runs().size());
                repo.saveAll(allRuns.runs());
            }
            catch(IOException e)
            {
                throw new RuntimeException("Failed to read JSON data.", e);
            }

        }
        else
        {
            log.info("Not loading runs from JSON because the collection contains data.");
        }
    }
}
