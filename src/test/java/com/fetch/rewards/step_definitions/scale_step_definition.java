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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class scale_step_definition {
    scalePage scalePage = new scalePage();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 20);
    String weightText;
    Alert alert;


    @Given("user is on the scale page")
    public void user_is_on_the_scale_page() {
        String url = ConfigurationReader.getProperty("url");
        Driver.getDriver().get(url);
    }
    @When("user scales the gold bar inserting numbers")
    public void userScalesTheGoldBarInsertingNumbers() {
        scalePage.left_0.sendKeys("0");
        scalePage.left_1.sendKeys("1");
        scalePage.right_0.sendKeys("2");
        scalePage.right_1.sendKeys("3");
        BrowserUtils.waits(5);
        scalePage.weighBtn.click();
        weightText = scalePage.Weightings.getText();
        boolean equals = weightText.contains("=");
        boolean isLess = weightText.contains("<");
        boolean isGreater = weightText.contains(">");
        if (equals) {
            scalePage.left_0.clear();
            scalePage.left_1.clear();
            scalePage.right_0.clear();
            scalePage.right_1.clear();
            BrowserUtils.waits(10);
        }else if (isLess || isGreater) {
            scalePage.coins0Btn.click();
            try {
                wait.until(ExpectedConditions.alertIsPresent());
                alert = Driver.getDriver().switchTo().alert();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            String alertText = alert.getText();
            if (alertText.contains("Oops! Try Again!")) {
                scalePage.coins1Btn.click();
                BrowserUtils.waits(5);
                alert.accept();
                if (alertText.contains("Oops! Try Again!")) {
                    scalePage.coins2Btn.click();
                    BrowserUtils.waits(5);
                    alert.accept();

                }
                if (alertText.contains("Oops! Try Again!")) {
                    scalePage.coins3Btn.click();
                    BrowserUtils.waits(5);
                    alert.accept();
                }else {
                    Assert.assertTrue(alert.getText().contains("Yay! You find it!"));
                    BrowserUtils.waits(5);
                    alert.accept();
                }
            }

        }

            scalePage.left_0.sendKeys("4");
            scalePage.left_1.sendKeys("5");
            scalePage.right_0.sendKeys("6");
            scalePage.right_1.sendKeys("7");

            scalePage.weighBtn.click();

        if (equals) {
            BrowserUtils.waits(5);
            scalePage.left_0.clear();
            scalePage.left_1.clear();
            scalePage.right_0.clear();
            scalePage.right_1.clear();
        }else if (isLess || isGreater) {
            scalePage.coins4Btn.click();
            try {
                wait.until(ExpectedConditions.alertIsPresent());
                alert = Driver.getDriver().switchTo().alert();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            String alertText = alert.getText();
            if (alertText.contains("Oops! Try Again!")) {
                BrowserUtils.waits(5);
                alert.accept();
                scalePage.coins5Btn.click();
                if (alertText.contains("Oops! Try Again!")) {
                    BrowserUtils.waits(5);
                    alert.accept();
                    scalePage.coins6Btn.click();
                } else if (alertText.contains("Oops! Try Again!")) {
                    BrowserUtils.waits(5);
                    alert.accept();
                    scalePage.coins7Btn.click();
                }else {
                    Assert.assertTrue(alert.getText().contains("Yay! You find it!"));
                    BrowserUtils.waits(5);
                    alert.accept();
                }
            }

        }


    }


    @When("user clicks on {string}")
    public void user_clicks_on(String string) {
        scalePage.left_0.sendKeys("4");
        scalePage.left_1.sendKeys("5");
        scalePage.right_0.sendKeys("6");
        scalePage.right_1.sendKeys("7");
        scalePage.weighBtn.click();
        weightText = scalePage.Weightings.getText();
        boolean equals = weightText.contains("=");
        boolean isLess = weightText.contains("<");
        boolean isGreater = weightText.contains(">");

        scalePage.weighBtn.click();

        if (equals) {
            BrowserUtils.waits(5);
            scalePage.left_0.clear();
            scalePage.left_1.clear();
            scalePage.right_0.clear();
            scalePage.right_1.clear();
        }else if (isLess || isGreater) {
            scalePage.coins4Btn.click();
            try {
                wait.until(ExpectedConditions.alertIsPresent());
                alert = Driver.getDriver().switchTo().alert();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            String alertText = alert.getText();
            if (alertText.contains("Oops! Try Again!")) {
                BrowserUtils.waits(5);
                alert.accept();
                scalePage.coins5Btn.click();
                if (alertText.contains("Oops! Try Again!")) {
                    BrowserUtils.waits(5);
                    alert.accept();
                    scalePage.coins6Btn.click();
                } else if (alertText.contains("Oops! Try Again!")) {
                    BrowserUtils.waits(5);
                    alert.accept();
                    scalePage.coins7Btn.click();
                }else {
                    BrowserUtils.waits(5);
                    alert.accept();
                }
            }

        }
    }
    @Then("user should be easily identify the fake gold bar")
    public void user_should_be_easily_identify_the_fake_gold_bar()  {
        Assert.assertTrue(alert.getText().contains("Yay! You find it!"));
        Driver.closeDriver();

    }
}
