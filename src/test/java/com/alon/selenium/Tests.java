package com.alon.selenium;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.open;


public class Tests {

    @BeforeClass
    public void beforeClass() {
        Configuration.browser = "firefox";
//        Configuration.holdBrowserOpen = true;
//        Configuration.fastSetValue = true;

        open("https://d1lb45u1msk0w5.cloudfront.net/#/");
    }

    @Test
    public void verifyErrorMessages() {
        ContactPage contactPage = new NavBar().navigateToContactPage();

        contactPage
                .clickSubmit()
                .verifyForeNameError()
                .verifyEmailError()
                .verifyMessageError()
                .enterName("Dan")
                .verifyForeNameErrorDisappear()
                .enterEmail("dan@abc.com")
                .verifyEmailErrorDisappear()
                .enterMessage("Nice Pizza")
                .verifyMessageErrorDisappear();
    }

    @Test
    public void verifyMenuItemAndPrice() {
        MenuPage menuPage = new NavBar().navigateToMenuPage();

        SelenideElement item = menuPage
                .navigateToSidesMenu()
                .getMenuItem("Chunky Chips and Aioli");

        item.$(".kilojoules").shouldHave(text("3273"));
        item.$(".price").shouldHave(text("9.99"));
    }
}
