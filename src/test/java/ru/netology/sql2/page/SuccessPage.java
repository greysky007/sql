package ru.netology.sql2.page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class SuccessPage {
    private SelenideElement heading = $x("//h2[contains(@class, 'heading')]");

    public SuccessPage() {
        heading.shouldBe(visible);
    }
}
