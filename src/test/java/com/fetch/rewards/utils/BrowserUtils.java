package com.fetch.rewards.utils;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BrowserUtils {
    static WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 20);
    public static void waits(int seconds){
        try {
            Thread.sleep(seconds * 1000);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static void waits(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
    }
}
