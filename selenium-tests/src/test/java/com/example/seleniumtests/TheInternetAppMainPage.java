package com.example.seleniumtests;


import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class TheInternetAppMainPage {


    public final String mainPageAddress = "http://192.168.0.1:5000/";

    public final SelenideElement welcomeSign = $("h1.heading");

    public final SelenideElement availableExamples = $("h2");

}
