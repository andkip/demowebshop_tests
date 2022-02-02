package tests;

import api.ApiSteps;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import config.App;
import io.qameta.allure.selenide.AllureSelenide;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.MainPage;

public class DemowebshopTests {
    ApiSteps apiSteps = new ApiSteps();
    MainPage mainPage = new MainPage();

    @BeforeAll
    static void configureBaseUrl() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        RestAssured.baseURI = App.config.getApiUrl();
        Configuration.baseUrl = App.config.getWebUrl();
    }

    @Test
    @DisplayName("Successful authorization to the demowebshop (API + UI)")
    void loginWithCookieTest() {
        apiSteps.getAndSetCookieToTheBrowser();
        mainPage.openMainPage();
        mainPage.verifySuccessfulAuthorization();
    }

    @Test
    @DisplayName("Add book to cart and check its presence (API + UI)")
    void addBookToCartAndCheckIt() {
        apiSteps.addBookToCart();
        mainPage.openMainPage();
        mainPage.checkCartFilling("1");
    }
}