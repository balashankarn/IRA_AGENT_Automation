package com.iraagent.utilities;

import org.openqa.selenium.*;

import static com.iraagent.core.BasicSetup.driver;

public class WebElementUtil {

    public void setValue(WebElement element , String value){
        element.clear();
        element.sendKeys(value);
    }

    public void clickElement(WebElement element){
        element.click();
    }

    public void getCurrentPageURL(WebDriver driver){
        driver.getCurrentUrl();
    }

  public boolean isElementDisplayed(WebElement element){
      boolean flag = false;
      try {
          if (element.isDisplayed()) {
              flag = true;
          }
      } catch (NoSuchElementException exception) {
          //flag = false;
      }
      return flag;
  }



  // code for stale element exception
    public boolean retryingFindClick(By by) {
        boolean result = false;
        int attempts = 0;
        while(attempts < 4) {
            try {
                driver.findElement(by).click();
                result = true;
                break;
            } catch(StaleElementReferenceException e) {
            }
            attempts++;
        }
        return result;
    }


}
