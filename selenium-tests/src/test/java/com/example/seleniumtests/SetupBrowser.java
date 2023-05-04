package com.example.seleniumtests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.MutableCapabilities;

import java.io.File;
import java.io.IOException;


public class SetupBrowser {


    public static final String downloadPath = "src/test/java/resources/downloads";

    public static final File downloadFileDirectory = new File(downloadPath);


    @BeforeAll
    public static void setUpAll() {
        MutableCapabilities capabilities = new MutableCapabilities();
        capabilities.setCapability("--disable-dev-shm-usage", true);
        Configuration.browserCapabilities = capabilities;
        Configuration.browserSize = "1280x800";
        Configuration.downloadsFolder = downloadPath;
        Configuration.timeout = 10000;
        Configuration.headless = true;
        Configuration.webdriverLogsEnabled = true;
        SelenideLogger.addListener("allure", new AllureSelenide());

    }

    @AfterAll
    public static void clear() throws IOException {
        FileUtils.cleanDirectory(downloadFileDirectory);
    }

}
