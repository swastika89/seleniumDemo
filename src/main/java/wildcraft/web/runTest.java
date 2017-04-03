package wildcraft.web;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
features = "classpath:features",
plugin = {"pretty", "html:target/cucumber-html-report"} ,
tags = { "@Verify_InvalidPassword" }
)
public class runTest extends AbstractTestNGCucumberTests {
}