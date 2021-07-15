package com.iraagent.tests;

import com.google.gson.internal.$Gson$Preconditions;
import com.iraagent.core.BasicSetup;
import com.iraagent.pages.IraChatPage;
import com.iraagent.utilities.CommonUtilities;
import com.iraagent.utilities.WaitUtilities;
import com.iraagent.utilities.WebElementUtil;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Set;

/**
 * Created by Balashankar
 */
public class SanityTest extends BasicSetup {

private IraChatPage iraChatPage;
private WebElementUtil webElementUtil;
private CommonUtilities commonUtilities;

    @BeforeClass(alwaysRun = true)
    public void init() {
        iraChatPage =new IraChatPage(driver);
        webElementUtil=new WebElementUtil();
        commonUtilities=new CommonUtilities();
    }

  //Verify Whether need help is displayed
    @Test(priority=1)

    public void waitForVisibilityOf_NeedHelp(){
        WaitUtilities.waitForVisibilityOf(iraChatPage.need_Help_Chat,"not visible");
        webElementUtil.clickElement(iraChatPage.getNeed_Help_Chat());
}
@Test(priority = 2)

    public void click_On_StartOver() throws InterruptedException {
      //  driver.switchTo().frame("avm_chat_widget_9687c536-4f2e-4e28-b3c1-8b447d1a12bc");
        //webElementUtil.clickElement(iraChatPage.getStartOver());
Set<String> win=    driver.getWindowHandles();
    System.out.println(""+win);
}

}
