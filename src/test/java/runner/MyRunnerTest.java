package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions
		(
				features="src/test/resources/features",
				glue={"stepDefinitions","hooks"},
				publish=true,
				plugin = {"pretty", "html:target/Cucumber-reports.html"},
				tags = "@all"
//				tags = "@validcredentials or @invalidcredentials" ----this two scenario will run
//				tags = "not @login"  --------all scenarios excluding login scenarios will run
		)


public class MyRunnerTest {

	}
