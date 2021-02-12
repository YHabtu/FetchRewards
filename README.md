# FetchRewards
I used Cucumber BDD Page Object Model to solve the task even though, I have countered some issues with Alert exception(selenium.UnhandledAlertException). My main language is Java. 
I have created feature file to describe my test scenarios. I have created Cucumber runner class to run my test case from my feature file. 

 Scenario: locating a fake gold bar
      Given user is on the scale page
      When user scales the gold bar inserting numbers
      And user clicks on "Weigh"
      Then user should be easily identify the fake gold bar


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

implemented the the actual code in step definitions where i created scalePage object to call the web elements.

I found some spelling errors on the application "Weighings" instead of "Weightings"
