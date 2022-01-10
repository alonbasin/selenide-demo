package com.alon.selenium;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class MenuPage {

    private final SelenideElement sidesMenuButton = $(byText("Sides"));
//        $(By.xpath("//a[text()[contains(.,'Sides')]]")).click();

    public MenuPage navigateToSidesMenu() {
        sidesMenuButton.click();
        return this;
    }

    public SelenideElement getMenuItem(String name) {
        return $$(".v-card.menuItem")
                .filter(visible)
                .filter(text(name))
                .get(0);
    }
}
