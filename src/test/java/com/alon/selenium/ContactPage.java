package com.alon.selenium;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class ContactPage {

    private final SelenideElement submitButton = $("a[aria-label='submit']");
    private final SelenideElement foreNameError = $("#forename-err");
    private final SelenideElement emailError = $("#email-err");
    private final SelenideElement messageError = $("#message-err");
    private final SelenideElement foreNameField = $("#forename");
    private final SelenideElement emailField = $("#email");
    private final SelenideElement messageField = $("#message");


    public ContactPage clickSubmit() {
        submitButton.click();
        return this;
    }

    public ContactPage verifyForeNameError() {
        foreNameError.shouldBe(visible).shouldHave(text("Forename is required"));
        return this;
    }

    public ContactPage verifyEmailError() {
        emailError.shouldBe(visible).shouldHave(text("Email is required"));
        return this;
    }

    public ContactPage verifyMessageError() {
        messageError.shouldBe(visible).shouldHave(text("Message is required"));
        return this;
    }

    public ContactPage enterName(String name) {
        foreNameField.setValue(name);
        return this;
    }

    public ContactPage enterEmail(String email) {
        emailField.setValue(email);
        return this;
    }

    public ContactPage enterMessage(String message) {
        messageField.setValue(message);
        return this;
    }

    public ContactPage verifyForeNameErrorDisappear() {
        if (foreNameField.isDisplayed())
            foreNameField.shouldHave(exactOwnText(""));
        else foreNameField.shouldBe(hidden);
        return this;
    }

    public ContactPage verifyEmailErrorDisappear() {
        if (emailField.isDisplayed())
            emailField.shouldHave(exactOwnText(""));
        else  emailField.shouldBe(hidden);
        return this;
    }

    public ContactPage verifyMessageErrorDisappear() {
        if (messageField.isDisplayed())
            messageField.shouldHave(exactOwnText(""));
        else messageField.shouldBe(hidden);
        return this;
    }
}
