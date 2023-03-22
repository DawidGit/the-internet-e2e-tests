package com.example.seleniumtests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import java.io.File;
import java.io.IOException;

public class SetupBrowser {


    public static final String downloadPath = "src/test/java/resources/downloads";

    public static final File downloadFileDirectory = new File(downloadPath);

    @BeforeAll
    public static void setUpAll() {
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
