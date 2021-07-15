package com.iraagent.utilities;

public enum Messages {

    /***Login Screen***/
    USERNAME("Username textbox is not displayed"),
    PASSWORD("Password textbox is not displayed"),
    SUBMIT("Submit button is not displayed"),

    /***Side Menu and Dashboard***/
    MENULIST("Menu list is not displayed"),
    DASHBOARDMESSAGE("Dashboard tab is not displayed"),

    /***Report Tab***/
    REPORTSTABMESSAGE("Reports tab is not displayed"),

    /***SO Attendance Tab***/
    SOATTENDANCE("SO Attendance tab is not displayed"),
    SOATTENDANCESUMMARY("SO Attendance Summary Log tab is not displayed"),
    SOATTENDANCEDAILYLOG("SO Attendance Daily Log tab is not displayed"),

    /***Manager Attendance Tab***/
    MANAGERATTENDANCE("Manager Attendance Tab is not displayed"),
    MANAGERATTENDANCESUMMARY("Manager Attendance Summary tab is not displayed"),
    MANAGERATTENDANCEDAILYLOG("Manager Attendance Daily Log tab is not displayed"),

    /***SO LIVE TRACKING Tab***/
    SOLIVETRACKING("SO Live tracking tab is not displayed"),
    SOTRACKINGHISTORY("SO Tracking History tab is not displayed"),

    /***MANAGER LIVE TRACKING Tab***/
    MANAGERLIVETRACKING("Manager Live Tracking tab is not displayed"),
    MANAGERTRACKINGHISTORY("Manager Tracking History tab is not displayed"),

    /***MANAGER LIST Tab***/
    MANAGERLIST("Manager List tab is not displayed"),
    MANAGERUPLOADHISTORY("Manager Upload History tab is not displayed"),

    /***SO LIST Tab***/
    SOLIST("SO List tab is not displayed"),
    SOUPLOADHISTORY("SO Upload History tab is not displayed"),

    /***IMEI MANAGEMENT Tab***/
    IMEIMANAGEMENT("IMEI tab is not displayed"),

    /***PERFORMANCE AND INCENTIVES Tab***/
    PERFORMANCELIST("Performance List tab is not displayed"),
    PERFORMANCEUPLOADHISTORY("Performance Upload History tab is not displayed"),

    /***STORE LIST Tab***/
    STORELIST("Store List tab is not displayed"),
    STOREUPLOADHISTORY("Store Upload tab is not displayed"),

    /***BRANCH LIST Tab***/
    BRANCHLIST("Branch List tab is not displayed"),
    BRANCHUPLOAD("Branch Upload tab is not displayed"),

    /***NOTIFICATION Tab***/
    NOTIFICATIONUSERDEVICES("Notification User Devices tab is not displayed"),
    SENDAMSNOTIFICATION("Send AMS Notification tab is not displayed"),
    SENDINBOXNOTIFICATION("Send Inbox Notification tab is not displayed"),
    NOTIFICATIONHISTORY("Notification History tab is not displayed"),

    /***MANAGE BUSINESS UNIT Tab***/
    MANAGEBUSINESSUNIT("Manage Business Unit tab is not displayed"),

    /***CONFIG Tab***/
    CONFIGPAPI("Config API tab is not displayed"),

    /***LOG Tab***/
    LOG("Log tab is not displayed");

    private final String message;

    public String getMessage() {
        return message;
    }

    Messages(String message) {
        this.message = message;
    }

}
