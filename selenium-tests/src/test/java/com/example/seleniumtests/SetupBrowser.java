package com.example.seleniumtests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.logging.*;


import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.logging.Level;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;


public class SetupBrowser {



    public static final String downloadPath = "src/test/java/resources/downloads";

    public static final File downloadFileDirectory = new File(downloadPath);


    @BeforeAll
    public static void setUpAll() {
        LoggingPreferences logPrefs = new LoggingPreferences();
        logPrefs.enable(LogType.BROWSER, Level.ALL);
        logPrefs.enable(LogType.PERFORMANCE,Level.ALL);

        MutableCapabilities capabilities = new MutableCapabilities();
        capabilities.setCapability("goog:loggingPrefs",logPrefs);
        capabilities.setCapability("--no-sandbox", true);
        capabilities.setCapability("--disable-dev-shm-usage", true);
        Configuration.browserCapabilities = capabilities;
        Configuration.browserSize = "1280x800";
        Configuration.downloadsFolder = downloadPath;
        Configuration.timeout = 10000;
        Configuration.headless = true;
        Configuration.webdriverLogsEnabled = true;
        SelenideLogger.addListener("allure", new AllureSelenide());

        Logs logs = getWebDriver().manage().logs();
        printLog(logs.get(LogType.BROWSER));
    }

    @AfterAll
    public static void clear() throws IOException {
        FileUtils.cleanDirectory(downloadFileDirectory);
    }


    static void printLog(LogEntries entries) {
        Logger logger= LogManager.getLogger(SetupBrowser.class);
        logger.info("{} log entries found", entries.getAll().size());
        for (LogEntry entry : entries) {
            logger.info("{} {} {}",
                    new Date(entry.getTimestamp()), entry.getLevel(), entry.getMessage()
            );
        }
    }


}
