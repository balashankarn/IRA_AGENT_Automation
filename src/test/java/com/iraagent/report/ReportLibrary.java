package com.iraagent.report;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.iraagent.core.BasicSetup;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;


public class ReportLibrary extends BasicSetup {

    public static ExtentSparkReporter sparkReporter;
    public ExtentReports extentReports;
    public ExtentTest test;

    //@BeforeTest
    public ExtentReports extentReportSetup() {
        //location of the extent report

        extentReports = new ExtentReports();
        String reportPath = properties.getProperty("reportspath") + "/test-output/" + new SimpleDateFormat("yyyy-MM-dd hh-mm-ss-ms").format(new Date()) + "ExtentReport.html";


        sparkReporter = new ExtentSparkReporter(new File(reportPath));

        sparkReporter.config().setDocumentTitle("Mobile Automation");
        sparkReporter.config().setReportName("Automation Execution Report");
        sparkReporter.config().setTheme(Theme.DARK);

        extentReports.attachReporter(sparkReporter);

        extentReports.setSystemInfo("Application Name","AMSPortal");
        extentReports.setSystemInfo("Platform", System.getProperty("os.name"));
        extentReports.setSystemInfo("Environment","prod");

        return extentReports;
    }

    //@AfterTest
    public void endReport() {
        extent.flush();
    }

}
