package com.example.seleniumtests;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class GoogleTest extends SetupBrowser {

    @Test
    public void googleWorks() {

        open("https://www.google.com");
        $("div[class='RNNXgb']").shouldBe(Condition.appear);

    }
}
