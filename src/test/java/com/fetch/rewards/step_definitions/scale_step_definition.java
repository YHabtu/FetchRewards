package com.fetch.rewards.step_definitions;
import com.fetch.rewards.Pages.scalePage;
import com.fetch.rewards.utils.BrowserUtils;
import com.fetch.rewards.utils.ConfigurationReader;
import com.fetch.rewards.utils.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class scale_step_definition {
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 20);
    scalePage scalePage = new scalePage();
    WebElement fakeBar=null;

    @Given("user is on the scale page")
    public void user_is_on_the_scale_page(){
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        String expectedtitle = "React App";
        String currentURL = "http://ec2-54-208-152-154.compute-1.amazonaws.com/";

        Assert.assertTrue("Title verification Failed",Driver.getDriver().getTitle().equals(expectedtitle));
        Assert.assertTrue("URL verification Failed",Driver.getDriver().getCurrentUrl().equals(currentURL));

    }

    @When("user scales the gold bar inserting numbers")
    public void user_scales_the_gold_bar_inserting_numbers() {
        wait.until(ExpectedConditions.visibilityOf(scalePage.left0));
        //place 123 on left  456 on right
        scalePage.left0.sendKeys("1");
        scalePage.left1.sendKeys("2");
        scalePage.left2.sendKeys("3");
        scalePage.right0.sendKeys("4");
        scalePage.right1.sendKeys("5");
        scalePage.right2.sendKeys("6");

        BrowserUtils.waits(3);
        scalePage.weigh.click();
        //assert the sign in the response box
        wait.until(ExpectedConditions.visibilityOf(scalePage.responseTableRow1));
        String line1Response = scalePage.responseTableRow1.getText();
        BrowserUtils.waits(3);

        if(line1Response.contains("=")){
            wait.until(ExpectedConditions.visibilityOf(scalePage.reset));
            BrowserUtils.waits(3);

            scalePage.reset.click();

            scalePage.left0.sendKeys("7");
            scalePage.right0.sendKeys("8");

            wait.until(ExpectedConditions.elementToBeClickable(scalePage.weigh));

            scalePage.weigh.click();
            BrowserUtils.waits(3);

            wait.until(ExpectedConditions.visibilityOf(scalePage.responseTableRow2));
            String line2Response = scalePage.responseTableRow2.getText();
            BrowserUtils.waits(3);
            if(line2Response.contains("=")){
                fakeBar = scalePage.coin_0;
            }else if(line2Response.contains(">")){
                fakeBar=scalePage.coin_8;
            }else{
                fakeBar=scalePage.coin_7;
            }

        }else if(line1Response.contains(">")){
            wait.until(ExpectedConditions.visibilityOf(scalePage.reset));
            BrowserUtils.waits(3);

            scalePage.reset.click();
            BrowserUtils.waits(3);

            scalePage.left0.sendKeys("4");
            scalePage.right0.sendKeys("5");
            BrowserUtils.waits(3);

            scalePage.weigh.click();
            BrowserUtils.waits(3);

            wait.until(ExpectedConditions.visibilityOf(scalePage.responseTableRow2));
            String line2Response = scalePage.responseTableRow2.getText();
            if(line2Response.contains("=")){
                fakeBar = scalePage.coin_6;
            }else if(line2Response.contains(">")){
                fakeBar=scalePage.coin_5;
            }else{
                fakeBar=scalePage.coin_4;
            }

        } else if(line1Response.contains("<")){
            wait.until(ExpectedConditions.visibilityOf(scalePage.reset));
            BrowserUtils.waits(3);

            scalePage.reset.click();
            BrowserUtils.waits(3);

            scalePage.left0.sendKeys("1");
            scalePage.right0.sendKeys("2");
            BrowserUtils.waits(3);

            scalePage.weigh.click();
            BrowserUtils.waits(3);

            wait.until(ExpectedConditions.visibilityOf(scalePage.responseTableRow2));
            String line2Response = scalePage.responseTableRow2.getText();
            if(line2Response.contains("=")){
                fakeBar = scalePage.coin_3;
            }else if(line2Response.contains(">")){
                fakeBar=scalePage.coin_2;
            }else{
                fakeBar=scalePage.coin_1;
            }

        }


    }

    @Then("user should be easily identify the fake gold bar")
    public void user_should_be_easily_identify_the_fake_gold_bar() {
        wait.until(ExpectedConditions.visibilityOf(scalePage.coin_0));
        BrowserUtils.waits(2);

        fakeBar.click();
        BrowserUtils.waits(2);
        Alert alert = Driver.getDriver().switchTo().alert();
        BrowserUtils.waits(2);

        String alertMessasge = alert.getText();
        String expectedAlertMessasge = "Yay! You find it!";
        BrowserUtils.waits(2);

        Assert.assertTrue("Alert Message FAILED" ,alertMessasge.contains(expectedAlertMessasge));
        BrowserUtils.waits(2);
        //System.out.println(alertMessasge);

        alert.accept();

        BrowserUtils.waits(2);
        Driver.getDriver().close();

    }
}
