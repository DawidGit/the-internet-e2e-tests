package com.example.seleniumtests;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class GoogleTest extends SetupBrowser {

    @Test
    public void googleWorks() {

        open("http://www.columbia.edu/~fdc/sample.html");
        $("img[alt='Sample image']").shouldBe(Condition.appear);

    }
}
