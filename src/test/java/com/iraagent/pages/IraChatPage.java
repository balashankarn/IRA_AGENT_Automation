package com.iraagent.pages;

import com.iraagent.core.BasicSetup;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

/**
 * Created by Balashankar
 */
public class IraChatPage extends BasicSetup {

    public IraChatPage(WebDriver driver){
        this.driver= driver;
        PageFactory.initElements(driver,this);
    }
@FindBy(xpath = "//*[@id=\"avm_chat_widget_9687c536-4f2e-4e28-b3c1-8b447d1a12bc\"]/div[3]")
    public WebElement need_Help_Chat;

    public WebElement getNeed_Help_Chat() {
        return need_Help_Chat;
    }

 @FindBys({
         @FindBy(xpath = "")
         @FindBy(css = "")
 })
 private List<WebElement> StartOver;

    @FindBy(xpath = "//*[@id=\"messageEditor-region\"]/div/div[4]/div[2]/div/a[1]")
    public WebElement help_Button;

  @FindBy(xpath = "//*[@id=\"messageEditor-region\"]/div/div[4]/div[2]/div/a[3]")
  public WebElement contact_US;
  @FindBy(xpath = "//*[@id=\"msg-1aff8e73-3a20-45b4-bd03-1586766cf845\"]/div/div[2]/a")
    public WebElement download_Policy;

    public WebElement getHelp_Button() {
        return help_Button;
    }

    public WebElement getContact_US() {
        return contact_US;
    }

    public WebElement getDownload_Policy() {
        return download_Policy;
    }
}
