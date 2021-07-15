package com.iraagent.utilities;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.iraagent.core.BasicSetup;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CommonUtilities extends BasicSetup {


    public CommonUtilities() {

    }







 //This Method I have written for wait for stale element exception
    public void waitForElementPresent(final By by, int timeout){
        WebDriverWait wait = (WebDriverWait)new WebDriverWait(driver,timeout)
                .ignoring(StaleElementReferenceException.class);
        wait.until(new ExpectedCondition<Boolean>(){
            @Override
            public Boolean apply(WebDriver webDriver) {
                WebElement element = webDriver.findElement(by);
                return element != null && element.isDisplayed();
            }
        });
    }
    // This method I have written to over ElementClickInterceptedException
    public void clickOnStartOver() {

        Actions action = new Actions(driver);

        //pass the product name that has to be searched in the website
        action.contextClick(driver.findElement(By.xpath("//*[@id=\"messageEditor-region\"]/div/div[4]/div[2]/div/a[1]")));
    }
    // This method I have written to over ElementClickInterceptedException
    public void closeUploadPopup(){
        WebElement closeUploadPopUP=driver.findElement(By.xpath("//*[@id=\"uploadFile\"]/div/div/div[1]/button"));
        JavascriptExecutor js =(JavascriptExecutor)driver;
        js.executeScript("arguments[0].click()",closeUploadPopUP);
    }
    // This method I have written to over ElementClickInterceptedException
    public void fileUpload(){
        WebElement fileUpload=driver.findElement(By.xpath("//*[@id=\"fileUpload\"]/div[2]/input"));
        JavascriptExecutor js =(JavascriptExecutor)driver;
        js.executeScript("arguments[0].click()",fileUpload);
    }
// This method I have written to over ElementClickInterceptedException
    ////*[@id="additionalFilters"]/div/div/div[1]/button

    public void fileDownload(){
        WebElement fileDownload=driver.findElement(By.xpath("//*[@id=\"sample-file-link\"]"));
        JavascriptExecutor js =(JavascriptExecutor)driver;
        js.executeScript("arguments[0].click()",fileDownload);
    }


    public void apply_Button(){
        WebElement apply_Button=driver.findElement(By.id("getSearchedReportAction"));
        JavascriptExecutor js =(JavascriptExecutor)driver;
        js.executeScript("arguments[0].click()",apply_Button);
    }


    // create file
    public void createFile(){
        String fileName = new SimpleDateFormat("yyyyMMddHHmm'.txt'").format(new Date());
        File file =new File("C:\\Users\\techjini\\Downloads\\CFL_AMS_Automation_Web1\\salesone_webportal\\Downloads\\Collectiondownloadlinks\\fileName.txt");
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}

