package com.example.seleniumtests;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class GoogleTest {

    @Test
    public void googleWorks() throws IOException {

        open("https://www.google.com");
        $("div[class='RNNXgb']").shouldBe(Condition.appear);

    }
}
