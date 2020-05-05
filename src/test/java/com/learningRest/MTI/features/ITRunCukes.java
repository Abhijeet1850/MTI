package com.learningRest.MTI.features;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = { "pretty", "html:target/cucumber", "json:target/cucumber.json" }, tags = {
		"@dummy2", "~@ignore" })
public class ITRunCukes {

}
