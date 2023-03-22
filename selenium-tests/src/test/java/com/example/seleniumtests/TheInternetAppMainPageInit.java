package com.example.seleniumtests;


import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TheInternetAppMainPageInit extends SetupBrowser {

    public TheInternetAppMainPage mainPage = new TheInternetAppMainPage();

    public SelenideElement mainPageMenu = $(By.tagName("ul"));


    @BeforeEach
    public void setUp() {
        open(mainPage.mainPageAddress);
    }

    @Test
    public void mainPageInitTest() {
        assertEquals("Welcome to the-internet", mainPage.welcomeSign.getText());
        assertEquals("Available Examples", mainPage.availableExamples.getText());
    }

    @Test
    public void checkAvailableElementsInMenu() throws IOException {

        ElementsCollection rows = mainPageMenu.$$("li");
        validateElementsInMenu(rows);
    }

    private void validateElementsInMenu(ElementsCollection rows) throws IOException {
        List<String> rowsToList;
        rowsToList = rows.texts();

        List<String> providedExamples;
        try {
            providedExamples = FileUtils.readLines(new File("src/test/java/resources/available-examples.txt"), "utf-8");
        } catch (Exception e) {
            throw new IOException(e.getMessage());
        }
        assertEquals(providedExamples.size(), rows.size());
        assertEquals(providedExamples, rowsToList);

    }
}
