package com.iraagent.utilities;


import com.iraagent.core.BasicSetup;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class WaitUtilities extends BasicSetup {

    private static WebDriverWait wait;

    public static void initWait(WebDriver driver, int timeoutInSeconds) {
        try{
            wait = new WebDriverWait(driver, timeoutInSeconds);
        }catch(Exception e){
            throw e;
        }
    }

    public static void waitImplicitly(WebDriver driver) {
        try{
            driver.manage().timeouts().implicitlyWait(TIMEOUT_IN_SECONDS, TimeUnit.SECONDS);
        }catch(Exception e){
            throw e;
        }
    }

    public static void waitForVisibilityOf(WebElement element, String message) {
        try {
            wait.withMessage(message);
            wait.until(ExpectedConditions.visibilityOf(element));
        }catch(Exception e){
            throw e;
        }
    }

    public static void waitForPageToLoad(String url, String message){
        wait.withMessage(message);
        wait.until(ExpectedConditions.urlToBe(url));
    }


    public static void waitForElementToBeClickable(WebElement element, String message) {
        try{
            wait.withMessage(message);
            wait.until(ExpectedConditions.visibilityOf(element));
        }catch(Exception e){
            throw e;
        }
    }

    public static void waitForNonVisibilityOf(WebElement element, String message) {
        try{
            wait.withMessage(message);
            wait.until(ExpectedConditions.invisibilityOf(element));
        }catch(Exception e){
            throw e;
        }
    }

    public static void waitForTextToBePresentInElement(WebElement element, String message) {
        try{
            wait.withMessage(message);
            wait.until(ExpectedConditions.textToBePresentInElement(element, message));
        }catch(Exception e){
            throw e;
        }
    }

    public static void waitImplicitly(WebDriver driver, int seconds) {
        try{
            driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
        }catch(Exception e){
            throw e;
        }
    }
 public static void waitForAlertPopup(WebDriver driver,int seconds){
         try{
             Alert alert = wait.until(ExpectedConditions.alertIsPresent());
             alert.accept();

         } catch(Exception e){
             throw e;
         }
 }

    public static void checkAlert() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 360);
            wait.until(ExpectedConditions.alertIsPresent());
            Alert alert = driver.switchTo().alert();
            alert.accept();
        } catch (Exception e) {
            throw e;
        }
    }

}
