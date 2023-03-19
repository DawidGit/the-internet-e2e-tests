package com.example.seleniumtests;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.io.File;
import java.io.FileNotFoundException;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class TheInternetAppTest extends TheInternetAppMainPageInit {

    @Test
    public void checkAddRemoveElements() {
        SelenideElement addRemoveOption = mainPageMenu.$(By.linkText("Add/Remove Elements"));

        addRemoveOption.click();

        $("button[onclick='addElement()']").click();
        $("button[onclick='addElement()']").click();
        $$("button[class='added-manually']").shouldBe(CollectionCondition.size(2));

        $$("button[class='added-manually']").asFixedIterable().forEach(SelenideElement::click);
        $("button[class='added-manually']").shouldBe(Condition.not(Condition.visible));
    }

    @Test
    public void checkBrokenImages() {

        SelenideElement addRemoveOption = mainPageMenu.$(By.linkText("Broken Images"));
        addRemoveOption.click();
        ElementsCollection images = $$("img");
        images.asFixedIterable().forEach(image -> image.shouldBe(Condition.visible));

    }

    @Test
    public void checkFileDownloadOption() throws FileNotFoundException {

        SelenideElement addRemoveOption = mainPageMenu.$(By.linkText("File Download"));

        addRemoveOption.click();
        $("h3").shouldBe(Condition.text("File Downloader"));

        File helloFile = $("a[href ='download/some-file.txt']").download();
        Assertions.assertTrue(helloFile.getName().matches("some-file.txt"));

    }

    @Test
    public void checkDragAndDropOption() {
        SelenideElement dragAndDropOption = mainPageMenu.$(By.linkText("Drag and Drop"));
        dragAndDropOption.click();
        $("h3").shouldBe(Condition.text("Drag and Drop"));

        $("div[id='column-a']").dragAndDropTo("div[id='column-b']");
        $("div[id='column-a']").shouldHave(Condition.text("B"));
    }


}
