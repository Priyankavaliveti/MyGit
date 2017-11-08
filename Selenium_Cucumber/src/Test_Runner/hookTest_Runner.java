package Test_Runner;

import org.junit.runner.RunWith;
import cucumber.api.junit.Cucumber;
import cucumber.api.CucumberOptions;

@RunWith(Cucumber.class)
//@CucumberOptions(features="featurefiles.hookTest",glue={"Step_Definition.hookTest_Definition"})

@CucumberOptions(features="featurefiles/hookTest.feature",glue={"src/Step_Definition/hookTest_Definition.java"})
public class hookTest_Runner
{ 
}