package com.alon.selenium;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class NavBar {

private final SelenideElement contactButton = $$("a[aria-label='contact']").filter(visible).get(0);
private final SelenideElement menuButton = $$("a[aria-label='menu']").filter(visible).get(0);


    public ContactPage navigateToContactPage() {
        contactButton.click();
        return page(ContactPage.class);
    }

    public MenuPage navigateToMenuPage() {
        menuButton.click();
        return page(MenuPage.class);
    }

}
