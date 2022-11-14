package cucumber.Options;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(
			features = "src/main/java/features",
			glue = {"stepDefinitions"},
			plugin = "json:target/jsonReports/cucumber-report.json" // Reports
//			tags = "@DeletePlace"
		)

public class TestRunner {

}