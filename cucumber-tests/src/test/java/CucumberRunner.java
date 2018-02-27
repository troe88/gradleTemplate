import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        tags = {"@ID-3"},
        features = {"src/test/resources"}
)
public class CucumberRunner {
}
