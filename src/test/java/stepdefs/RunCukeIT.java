package stepdefs;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = { "summary", "json:target/cucumber-json.json",
		"tech.grasshopper.AllureCucumberMappingPlugin:target/cucumber-allure.json" }/* , tags = "@city" */)
public class RunCukeIT {

}