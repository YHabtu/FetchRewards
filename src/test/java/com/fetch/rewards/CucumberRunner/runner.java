package com.fetch.rewards.CucumberRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources",
        glue = "com/fetch/rewards/step_definitions",
        dryRun = false,
        publish = true
)
public class runner {
}
