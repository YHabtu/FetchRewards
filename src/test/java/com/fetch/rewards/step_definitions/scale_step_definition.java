package com.fetch.rewards.step_definitions;

import com.fetch.rewards.Pages.scalePage;
import com.fetch.rewards.utils.ConfigurationReader;
import com.fetch.rewards.utils.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;

public class scale_step_definition {
    scalePage scalePage = new scalePage();

    @Given("user is on the scale page")
    public void user_is_on_the_scale_page() {
        String url = ConfigurationReader.getProperty("url");
        Driver.getDriver().get(url);
    }
    @When("user scale the gold bars by inserting nums")
    public void userScaleTheGoldBarsByInsertingNums() {
        scalePage.left_0.sendKeys("0");
        scalePage.left_1.sendKeys("1");
        scalePage.right_0.sendKeys("2");
        scalePage.right_1.sendKeys("3");
    }
    @When("user clicks on {string}")
    public void user_clicks_on(String string) {
        scalePage.weighBtn.click();
    }
    @Then("user should be able to find the fake bar")
    public void user_should_be_able_to_find_the_fake_bar() {
        String weightingsText = scalePage.Weightings.getText();
        if(!weightingsText.contains("<") || weightingsText.contains(">")){
            scalePage.resetBtn.click();
           scalePage.left_0.sendKeys("4");
           scalePage.left_1.sendKeys("5");
           scalePage.right_0.sendKeys("1");
           scalePage.right_1.sendKeys("0");
           if(weightingsText.contains("<") || weightingsText.contains(">")){
               System.out.println(true);
           }
         }else{
            System.out.println(false);
        }



    }



}
