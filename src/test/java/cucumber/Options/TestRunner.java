package cucumber.Options;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/java/features", 
			glue= {"stepDefinitions"},
			strict = true,
			plugin = {
					"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
					"json:target/jsonReports/cucumber-report.json"
					})
			//tags={"@DeletePlace"})
public class TestRunner {
	
}
