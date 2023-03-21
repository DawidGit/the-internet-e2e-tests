package com.example.seleniumtests;


import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class TheInternetAppMainPage {


    public final String mainPageAddress = "http://localhost:5000/";

    public final SelenideElement welcomeSign = $("h1.heading");

    public final SelenideElement availableExamples = $("h2");

    public final SelenideElement elementInMenu = $("ul.li");

}