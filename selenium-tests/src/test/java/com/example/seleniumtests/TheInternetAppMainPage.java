package com.example.seleniumtests;


import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class TheInternetAppMainPage {


    public final String mainPageAddress = "http://172.17.0.2:5000/";

    public final SelenideElement welcomeSign = $("h1.heading");

    public final SelenideElement availableExamples = $("h2");

}
