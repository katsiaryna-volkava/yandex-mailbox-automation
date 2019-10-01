package suites;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber-report/smoketest", "json:target/cucumber.json"},
        tags = {"@SMOKE"},
        glue = {"src.test.java.features"},
        features = "src\\test\\java\\features\\LogoutFromMailbox.feature")
public class SmokeTestSuite extends AbstractTestNGCucumberTests {

}
