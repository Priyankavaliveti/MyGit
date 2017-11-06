package Test_Runner;

import org.junit.runner.RunWith;
import cucumber.api.junit.Cucumber;
import cucumber.api.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="featurefiles/google.feature",glue={"src/Step_Definition/google_Definition.java"})

public class google_Runner
{ 
}