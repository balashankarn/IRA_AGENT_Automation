package com.iraagent.core;


import com.aventstack.extentreports.ExtentReports;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.iraagent.jsonmodels.LoginModel;
import com.iraagent.report.ReportLibrary;
import com.iraagent.utilities.ScreenshotUtility;
import com.iraagent.utilities.WaitUtilities;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

@Listeners({ScreenshotUtility.class})
public class BasicSetup {


    public static WebDriver driver ;
    protected static Properties properties;
    private ReportLibrary reportLibrary;
    protected static ExtentReports extent;
    public static final int TIMEOUT_IN_SECONDS = 26;
    private ObjectMapper mapper;
    private JsonNode doc;
    private LoginModel loginModel;
    public String browser;
    public String environment;

    public final static Logger logger = LogManager.getLogger(BasicSetup.class);

    public static ChromeOptions options;

    private static final String PROPERTIES_FILEPATH = "./config.properties";
    public static String downloadPath ;

    @BeforeSuite(alwaysRun = true)
    public void setUp() {
        this.defineProperties();
        this.defineDriver();
        this.defineEnvironment();
        reportLibrary = new ReportLibrary();
        extent = reportLibrary.extentReportSetup();
        WaitUtilities.initWait(driver, TIMEOUT_IN_SECONDS);
        mapper = new ObjectMapper();
        mapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);


    }

        public LoginModel getData(String nodeKey) throws JsonProcessingException {
            mapper = new ObjectMapper();
            mapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
            mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
            try {
                doc = mapper.readTree(new File(properties.getProperty("loginData.json")));

            } catch (Exception exception) {
                System.out.println("Exception" + exception);
            }
            JsonNode jsonNode = doc.path(nodeKey);
            loginModel = mapper.treeToValue(jsonNode, LoginModel.class);
            return loginModel;
        }




    public void defineDriver() {
        browser = System.getProperty("browser") != null ? System.getProperty("browser") : "chrome" ;
        switch (browser){
            case "firefox" :
                System.setProperty("webdriver.gecko.driver",properties.getProperty("firefoxExePath"));
                driver = new FirefoxDriver();
                break;
            case "chrome" : {
                System.setProperty("webdriver.chrome.driver", properties.getProperty("chromeExePath"));

         //Disable the automation pop
                options = new ChromeOptions();
                options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
           //downdload path setting
                HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
                chromePrefs.put("profile.default_content_settings.popups", 0);
                options.setExperimentalOption("prefs",chromePrefs);
                //Code for dissable save password the pop up
                  chromePrefs.put("credentials_enable_service", false);
                chromePrefs.put("profile.password_manager_enabled", false);
                options.setExperimentalOption("prefs", chromePrefs);
                driver = new ChromeDriver(options);
            }
                break;
        }
        driver.manage().window().maximize();
        logger.info("Driver defined");
    }

    public void defineEnvironment(){
        environment = System.getProperty("env") != null ? System.getProperty("env") : "stagingEnvironment";
        switch (environment){
            case "qaEnvironment" :
            driver.get(properties.getProperty("qaEnvironment"));
            break;

            case "stagingEnvironment" :
                driver.get(properties.getProperty("stagingEnvironment"));
                break;
        }
    }

    public void defineProperties(){

        properties = new Properties();
        try {
            File file = new File(PROPERTIES_FILEPATH);
            FileInputStream fileInput = new FileInputStream(file);
            properties.load(fileInput);
        } catch (IOException e) {
            System.out.println("Exception"+e);
        }
    }

    @AfterSuite
    public void afterSuite(){
        reportLibrary.endReport();
        //driver.quit();
    }
}
