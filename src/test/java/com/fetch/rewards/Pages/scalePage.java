package com.fetch.rewards.Pages;

import com.fetch.rewards.utils.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class scalePage {

    public scalePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "left_0")
    public WebElement left_0;

    @FindBy(id = "left_1")
    public WebElement left_1;

    @FindBy(id = "left_2")
    public WebElement left_2;

    @FindBy(id = "right_0")
    public WebElement right_0;

    @FindBy(id = "right_1")
    public WebElement right_1;

    @FindBy(id = "right_2")
    public WebElement right_2;

    @FindBy(id = "reset")
    public WebElement resetBtn;

    @FindBy(id = "weigh")
    public WebElement weighBtn;

    @FindBy(xpath = "//li[1]")
    public WebElement Weightings; // found misspelling Weighings(Weightings)

    @FindBy(id = "coin_0")
    public WebElement coins0Btn;

    @FindBy(id = "coin_1")
    public WebElement coins1Btn;

    @FindBy(id = "coin_2")
    public WebElement coins2Btn;

    @FindBy(id = "coin_3")
    public WebElement coins3Btn;

    @FindBy(id = "coin_4")
    public WebElement coins4Btn;

    @FindBy(id = "coin_5")
    public WebElement coins5Btn;

    @FindBy(id = "coin_6")
    public WebElement coins6Btn;

    @FindBy(id = "coin_7")
    public WebElement coins7Btn;

    @FindBy(id = "coin_8")
    public WebElement coins8Btn;


}
